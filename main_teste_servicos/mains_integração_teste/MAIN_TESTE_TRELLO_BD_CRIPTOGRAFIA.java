package mains_integração_teste;

import java.io.IOException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import bd.GetKnivetInfos_DAO;
import bd.GetUltimoPKKnivet_DAO;
import bd.SetKnivetInfos_DAO;
import bd.VerificarEmailExistente;
import bdClasses.Knivet;
import net.bytebuddy.description.modifier.SynchronizationState;
import rsa.EspacoBranco;
import rsa.RSAString;

public class MAIN_TESTE_TRELLO_BD_CRIPTOGRAFIA {
	public static void main(String[] args) throws Exception
	{
		Knivet usuario = new Knivet();
		RSAString rsa = new RSAString();
		KeyPair keys = rsa.LoadKeyPair("C:\\chaves");
		Cipher cipher = rsa.gerarCipher();
		GetUltimoPKKnivet_DAO ultimoPK = new GetUltimoPKKnivet_DAO();
		SetKnivetInfos_DAO setKnivet = new SetKnivetInfos_DAO();
		GetKnivetInfos_DAO getKnivet = new GetKnivetInfos_DAO(); 
		int PK = ultimoPK.maiorPK();
		rsa.inicializarRSA(keys, cipher);
		usuario.setEmail(rsa.encrypt("joao.pedro.dezembro@uol.com.br"));
		usuario.setEmailRec(rsa.encrypt("dezembro@knivet.com.br"));		
		usuario.setIdknivet(PK);
		usuario.setNomeUsr(rsa.encrypt("João Pedro Silva Dezembro Leonelo"));
		usuario.setSenha(rsa.encrypt("knivet2017"));
		VerificarEmailExistente verificar = new VerificarEmailExistente();
		boolean emailDuplicado = verificar.emailIgual("joao.pedro.dezembro@uol.com.br");
		if(emailDuplicado == false)
		{
			setKnivet.adiciona(usuario, PK);
			ArrayList<Knivet> tabelaBD = getKnivet.buscar();		
			for(int i=0;i<tabelaBD.size();i++)
			{
				Knivet knivet = tabelaBD.get(i);
				String email = rsa.decrypt(knivet.getEmail());
				String emailRec = rsa.decrypt(knivet.getEmailRec());
				String nomeUsr = rsa.decrypt(knivet.getNomeUsr());
				String senha = rsa.decrypt(knivet.getSenha());
				email = email.trim();
				emailRec = emailRec.trim();
				nomeUsr = nomeUsr.trim();
				senha = senha.trim();
				System.out.println("Email: "+email+" - Senha: "+senha+" - Nome do usuário: "+nomeUsr+" - Email de Recuperação da conta: "+emailRec);
			}
		}
		else
		{
			System.out.println("Email ja cadastrado");
		}
		
	}
}
