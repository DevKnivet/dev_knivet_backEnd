package escavadorProcesso;

public class CardTrelloEscavador {

	private String titulo;
	private String parteProcesso;
	private String parteProcessada;
	private String parteNaoIdentificada;
	private String parteUm, parteDois ;
	private String parteZero;
	private String descricao;
	private String processo;
	private String json;
	private int idMovimentacao;
	
	
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getProcesso() {
		return processo;
	}
	public void setProcesso(String processo) {
		this.processo = processo;
	}
	public int getIdMovimentacao() {
		return idMovimentacao;
	}
	public void setIdMovimentacao(int idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getParteNaoIdentificada() {
		return parteNaoIdentificada;
	}
	public void setParteNaoIdentificada(String parteNaoIdentificada) {
		this.parteNaoIdentificada = parteNaoIdentificada;
	}
	public String getParteZero() {
		return parteZero;
	}
	public void setParteZero(String parteZero) {
		this.parteZero = parteZero;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getParteProcesso() {
		return parteProcesso;
	}
	public CardTrelloEscavador(String vazio) {
		this.titulo = vazio;
		this.parteProcesso = vazio;
		this.parteProcessada = vazio;
		this.parteNaoIdentificada = vazio;
		this.parteUm =vazio;
		this.parteDois = vazio;
		this.parteNaoIdentificada = vazio;
	}
	public void setParteProcesso(String parteProcesso) {
		this.parteProcesso = parteProcesso;
	}
	public String getParteProcessada() {
		return parteProcessada;
	}
	public void setParteProcessada(String parteProcessada) {
		this.parteProcessada = parteProcessada;
	}
	
	public String getParteUm() {
		return parteUm;
	}
	public void setParteUm(String parteUm) {
		this.parteUm = parteUm;
	}
	public String getParteDois() {
		return parteDois;
	}
	public void setParteDois(String parteDois) {
		this.parteDois = parteDois;
	}
	
	

	

	
}
