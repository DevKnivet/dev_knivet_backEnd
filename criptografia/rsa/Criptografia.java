package rsa;

import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
   
  public class Criptografia {
    public byte[] criptografar(String texto, PublicKey chave)
    {
    	byte[] cipherText = null;      
        try {
          final Cipher cipher = Cipher.getInstance("RSA");
          cipher.init(Cipher.ENCRYPT_MODE, chave);
          cipherText = cipher.doFinal(texto.getBytes());
        } catch (Exception e) {
          e.printStackTrace();
        }      
        return cipherText;
    }
    
    public String descriptografar(byte[] texto, PrivateKey chave)
    {
    	byte[] dectyptedText = null;      
        try {
          final Cipher cipher = Cipher.getInstance("RSA");
          cipher.init(Cipher.DECRYPT_MODE, chave);
          dectyptedText = cipher.doFinal(texto);
     
        } catch (Exception ex) {
          ex.printStackTrace();
        }   
        return new String(dectyptedText);
    }
  }