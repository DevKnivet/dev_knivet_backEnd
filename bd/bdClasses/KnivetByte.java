package bdClasses;

public class KnivetByte {

	//Mesmas Variáveis que a tabela knivet possui no BD
	
	private int idknivet;
	private byte[] email;
	private byte[] senha;
	private byte[] nomeUsr;
	private byte[] emailRec;
	
	public int getIdknivet() {
		return idknivet;
	}
	public void setIdknivet(int idknivet) {
		this.idknivet = idknivet;
	}
	public byte[] getEmail() {
		return email;
	}
	public void setEmail(byte[] bs) {
		this.email = bs;
	}
	public byte[] getSenha() {
		return senha;
	}
	public void setSenha(byte[] senha) {
		this.senha = senha;
	}
	public byte[] getNomeUsr() {
		return nomeUsr;
	}
	public void setNomeUsr(byte[] nomeUsr) {
		this.nomeUsr = nomeUsr;
	}
	public byte[] getEmailRec() {
		return emailRec;
	}
	public void setEmailRec(byte[] emailRec) {
		this.emailRec = emailRec;
	}
	
}
