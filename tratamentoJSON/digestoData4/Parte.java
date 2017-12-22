package digestoData4;

import java.util.ArrayList;

public class Parte 
{
	int idParticipacao;
	int idParte;
	String nome;
	String nomeNormalizado;
	int cnpj;
	int cpf;
	String docFormatado;
	int parteRelacaoID;
	String relacaoNorm;
	ArrayList<Advogado> advogados;
	boolean parteAut;
	boolean parteCo;
	boolean parteRe;
	boolean parteNeutra;
	int cepPart;
	int idEntidade;
	boolean parteFisica;
	public int getIdParticipacao() {
		return idParticipacao;
	}
	public void setIdParticipacao(int idParticipacao) {
		this.idParticipacao = idParticipacao;
	}
	public int getIdParte() {
		return idParte;
	}
	public void setIdParte(int idParte) {
		this.idParte = idParte;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeNormalizado() {
		return nomeNormalizado;
	}
	public void setNomeNormalizado(String nomeNormalizado) {
		this.nomeNormalizado = nomeNormalizado;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getDocFormatado() {
		return docFormatado;
	}
	public void setDocFormatado(String docFormatado) {
		this.docFormatado = docFormatado;
	}
	public int getParteRelacaoID() {
		return parteRelacaoID;
	}
	public void setParteRelacaoID(int parteRelacaoID) {
		this.parteRelacaoID = parteRelacaoID;
	}
	public String getRelacaoNorm() {
		return relacaoNorm;
	}
	public void setRelacaoNorm(String relacaoNorm) {
		this.relacaoNorm = relacaoNorm;
	}
	public ArrayList<Advogado> getAdvogados() {
		return advogados;
	}
	public void setAdvogados(ArrayList<Advogado> advogados) {
		this.advogados = advogados;
	}
	public boolean isParteAut() {
		return parteAut;
	}
	public void setParteAut(boolean parteAut) {
		this.parteAut = parteAut;
	}
	public boolean isParteCo() {
		return parteCo;
	}
	public void setParteCo(boolean parteCo) {
		this.parteCo = parteCo;
	}
	public boolean isParteRe() {
		return parteRe;
	}
	public void setParteRe(boolean parteRe) {
		this.parteRe = parteRe;
	}
	public boolean isParteNeutra() {
		return parteNeutra;
	}
	public void setParteNeutra(boolean parteNeutra) {
		this.parteNeutra = parteNeutra;
	}
	public int getCepPart() {
		return cepPart;
	}
	public void setCepPart(int cepPart) {
		this.cepPart = cepPart;
	}
	public int getIdEntidade() {
		return idEntidade;
	}
	public void setIdEntidade(int idEntidade) {
		this.idEntidade = idEntidade;
	}
	public boolean isParteFisica() {
		return parteFisica;
	}
	public void setParteFisica(boolean parteFisica) {
		this.parteFisica = parteFisica;
	}
}
