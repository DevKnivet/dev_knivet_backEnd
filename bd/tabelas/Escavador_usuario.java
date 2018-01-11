package tabelas;

public class Escavador_usuario {	
	private int id_usuario;
	private String token;
	private String email;
	private String senha;
	private int chamadas_total;
	private int erros_total;
	private int minutos_total;
	private int antigasMovimentacoes;
	
	public int getChamadas_total() {
		return chamadas_total;
	}
	public void setChamadas_total(int chamadas_total) {
		this.chamadas_total = chamadas_total;
	}
	public int getErros_total() {
		return erros_total;
	}
	public void setErros_total(int erros_total) {
		this.erros_total = erros_total;
	}
	public int getMinutos_total() {
		return minutos_total;
	}
	public void setMinutos_total(int minutos_total) {
		this.minutos_total = minutos_total;
	}	
	public int getAntigasMovimentacoes() {
		return antigasMovimentacoes;
	}
	public void setAntigasMovimentacoes(int antigasMovimentacoes) {
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
