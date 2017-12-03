package mains_criptografia;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import rsa.Criptografia;
import rsa.CriptografiaGerarChaves;
import rsa.Key;

public class MAIN_TESTE_CRIPTOGRAFIA {
	public static void main (String [] args) throws NoSuchAlgorithmException
	{
		CriptografiaGerarChaves gerarKey = new CriptografiaGerarChaves();
		ArrayList<Key> chaves = gerarKey.gerarChave();
		Criptografia cripto = new Criptografia();		
		byte[] txtEncript = cripto.criptografar("", chaves.get(0).getChavePublica());
		String txtDescrpt = cripto.descriptografar(txtEncript, chaves.get(0).getChavePrivada());		
		System.out.println("Chave Privada: "+chaves.get(0).getChavePrivada().toString()+" - Chave Pública: "+chaves.get(0).getChavePublica().toString()+" ---- Texto Criptografado: "+txtEncript+" - Texto Descriptografado: "+txtDescrpt);
		
	}
}
