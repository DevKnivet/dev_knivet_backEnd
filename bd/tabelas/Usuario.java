package tabelas;

public class Usuario {
	private int id;
	private String email;
	private String senha;
	private String nomeUsr;
	private String emailRec;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNomeUsr() {
		return nomeUsr;
	}
	public void setNomeUsr(String nomeUsr) {
		this.nomeUsr = nomeUsr;
	}
	public String getEmailRec() {
		return emailRec;
	}
	public void setEmailRec(String emailRec) {
		this.emailRec = emailRec;
	}
}
