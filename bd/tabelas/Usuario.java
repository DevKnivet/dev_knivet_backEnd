package tabelas;

public class Usuario {
	private int id;
	private String email;
	private String senha;
	private String nomeUsr;
	private String emailRec;
	private int automacoes_ativas;
	private int automacoes_max;
	private int num_automatizacoes_total;
	private int minutos_salvos_total;
	private int erros_total;
	
	public int getAutomacoes_ativas() {
		return automacoes_ativas;
	}
	public void setAutomacoes_ativas(int automacoes_ativas) {
		this.automacoes_ativas = automacoes_ativas;
	}
	public int getAutomacoes_max() {
		return automacoes_max;
	}
	public void setAutomacoes_max(int automacoes_max) {
		this.automacoes_max = automacoes_max;
	}
	public int getNum_automatizacoes_total() {
		return num_automatizacoes_total;
	}
	public void setNum_automatizacoes_total(int num_automatizacoes_total) {
		this.num_automatizacoes_total = num_automatizacoes_total;
	}
	public int getMinutos_salvos_total() {
		return minutos_salvos_total;
	}
	public void setMinutos_salvos_total(int minutos_salvos_total) {
		this.minutos_salvos_total = minutos_salvos_total;
	}
	public int getErros_total() {
		return erros_total;
	}
	public void setErros_total(int erros_total) {
		this.erros_total = erros_total;
	}
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
