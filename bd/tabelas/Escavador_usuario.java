package tabelas;

public class Escavador_usuario {	
	private int id_usuario;
	private String token;
	private String email;
	private String senha;
	private boolean antigasMovimentacoes;
	
	public boolean isAntigasMovimentacoes() {
		return antigasMovimentacoes;
	}
	public void setAntigasMovimentacoes(boolean antigasMovimentacoes) {
		this.antigasMovimentacoes = antigasMovimentacoes;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
}
