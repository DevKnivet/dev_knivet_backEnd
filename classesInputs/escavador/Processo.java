package escavador;

import java.util.ArrayList;

import escavadorProcesso.Envolvidos;
import escavadorProcesso.ProcessosInt;

public class Processo {
	private int id;
	private String secao;
	private String texto_categoria;
	private int diario_oficial_id;
	private int processo_id;
	private String tipo;
	private String conteudo;
	private String data;
	private String descricao_pequena;
	private String diario_oficial;
	private String estado;
	private ArrayList<Envolvidos> envolvido;
	private String link;
	private String link_api;
	private String data_formatada;
	private Processo processoInt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSecao() {
		return secao;
	}
	public void setSecao(String secao) {
		this.secao = secao;
	}
	public String getTexto_categoria() {
		return texto_categoria;
	}
	public void setTexto_categoria(String texto_categoria) {
		this.texto_categoria = texto_categoria;
	}
	public int getDiario_oficial_id() {
		return diario_oficial_id;
	}
	public void setDiario_oficial_id(int diario_oficial_id) {
		this.diario_oficial_id = diario_oficial_id;
	}
	public int getProcesso_id() {
		return processo_id;
	}
	public void setProcesso_id(int processo_id) {
		this.processo_id = processo_id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescricao_pequena() {
		return descricao_pequena;
	}
	public void setDescricao_pequena(String descricao_pequena) {
		this.descricao_pequena = descricao_pequena;
	}
	public String getDiario_oficial() {
		return diario_oficial;
	}
	public void setDiario_oficial(String diario_oficial) {
		this.diario_oficial = diario_oficial;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public ArrayList<Envolvidos> getEnvolvido() {
		return envolvido;
	}
	public void setEnvolvido(ArrayList<Envolvidos> envolvido) {
		this.envolvido = envolvido;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLink_api() {
		return link_api;
	}
	public void setLink_api(String link_api) {
		this.link_api = link_api;
	}
	public String getData_formatada() {
		return data_formatada;
	}
	public void setData_formatada(String data_formatada) {
		this.data_formatada = data_formatada;
	}
	public Processo getProcessoInt() {
		return processoInt;
	}
	public void setProcessoInt(Processo processoInt) {
		this.processoInt = processoInt;
	}
}
