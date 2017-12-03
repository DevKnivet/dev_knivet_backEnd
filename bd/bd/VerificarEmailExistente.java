package bd;

import java.security.KeyPair;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.crypto.Cipher;

import bdClasses.Knivet;
import bdConnectionKnivetUmbler.BDConnection;
import rsa.RSAString;

public class VerificarEmailExistente {

	public boolean emailIgual(String email) throws Exception {
	 	//Cria a conexão com o BD (configurado em BDConnection)
        Connection conn = BDConnection.abrir();
        //Rodar script que será enviado para o banco de dados em SQL
        PreparedStatement comando = conn.prepareStatement("SELECT idknivet, email, senha, nomeUsr, emailRec FROM knivet ORDER BY idknivet ");
        //Receber o resultado do script enviado
        ResultSet resultado = comando.executeQuery();
        //Criar Array do tipo Knivet (com as mesmas variáveis da tabela)
        ArrayList<Knivet> lista = new ArrayList<Knivet>();
        //Enquanto houver resultados a serem pesquisados faça...
        boolean emailExistente = false;
        while (resultado.next()) {
        	//Criar uma variável do tipo Knivet para ser adicionado no ArrayList após salvar todos os dados
            Knivet linha = new Knivet();
            //Capturar os dados no seguinte modelo (variável da Arrey . setVariávelASerPega (variável da resposta do BD . get Tipo da Variável a ser salva (" nome da coluna que salva essa variável no BD "));
            linha.setEmail(resultado.getString("email"));
            linha.setEmailRec(resultado.getString("emailRec"));
            linha.setIdknivet(resultado.getInt("idknivet"));
            linha.setNomeUsr(resultado.getString("nomeUsr"));
            linha.setSenha(resultado.getString("senha"));
            //Adicionar a nova variável do tipo Knivet na lista (que será retornada futuramente)
            lista.add(linha);
        }
        RSAString rsa = new RSAString();
        Cipher cipher = rsa.gerarCipher();
        KeyPair keys = rsa.LoadKeyPair("C:\\chaves");
        rsa.inicializarRSA(keys, cipher);
        email = email.trim();
        for(int i=0;i<lista.size();i++)
        {
        	Knivet knivet = lista.get(i);
        	String emailKnivet = rsa.decrypt(knivet.getEmail());
        	emailKnivet = emailKnivet.trim();
        	if(emailKnivet.equals(email))
        	{
        		emailExistente = true;
        	}
        }
        
        //Fechar o resultado
        resultado.close();
        //Fechar o script
        comando.close();
        //Fechar comunicação (Para liberar memoria e num de usuários ativos para performance)
        conn.close();
        //Retornar lista de objetos Knivet com os dados
        return emailExistente;
    }
	
}
