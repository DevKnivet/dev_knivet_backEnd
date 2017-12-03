package mains_criptografia;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import rsa.RSAString;

public class MAIN_TESTE_Criptografia {
	public static void main (String args[]) throws Exception
	{
		RSAString rsa = new RSAString();
		KeyPair keys = rsa.LoadKeyPair("C:\\chaves");
		Cipher cipher = rsa.gerarCipher();
		rsa.inicializarRSA(keys, cipher);		
		System.out.println(rsa.decrypt(rsa.encrypt("teste")));
	}
}
