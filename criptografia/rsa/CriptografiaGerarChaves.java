package rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class CriptografiaGerarChaves {
	public ArrayList<Key> gerarChave() throws NoSuchAlgorithmException
    {
    	KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    	keyGen.initialize(1024);
    	KeyPair key = keyGen.generateKeyPair();
    	PrivateKey keyPrivada = key.getPrivate();
    	PublicKey keyPublica = key.getPublic();
    	ArrayList<Key> chaves = new ArrayList<Key>();
    	Key k = new Key();
    	k.setChavePrivada(keyPrivada);
    	k.setChavePublica(keyPublica);
    	chaves.add(k);
    	return chaves;
    }
}
