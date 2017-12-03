package rsa;

import java.security.PrivateKey;
import java.security.PublicKey;

public class Key {
	
	private PublicKey chavePublica; 
	private PrivateKey chavePrivada;
	
	public PublicKey getChavePublica() {
		return chavePublica;
	}
	public void setChavePublica(PublicKey chavePublica) {
		this.chavePublica = chavePublica;
	}
	public PrivateKey getChavePrivada() {
		return chavePrivada;
	}
	public void setChavePrivada(PrivateKey chavePrivada) {
		this.chavePrivada = chavePrivada;
	}

}
