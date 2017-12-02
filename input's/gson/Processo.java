package gson;

import java.util.ArrayList;

public class Processo {

	private boolean regional_cnj;
	private String numeroAlternativo;
	private ArrayList<AnexoObj> anexos = new ArrayList<>();
	private String vara;
	private String classeNatureza;
	private ArrayList<Mov> movs = new ArrayList<>();
	private String distribuicaoTipo;
	private String situacao;
	private String juiz;
	private String area;
	private String assuntoExtra;
	private ArrayList<Audiencia> audiencias = new ArrayList<>();
	private String vara_original;
	private int extinto;
	private int valor;
	private String alteradoEm;
	private String fonte_sistema;
	private String foro;
	private int situacao_situacaoID;
	private int instancia;
	private String sentencaData;
	private String numero;
	private ArrayList<Custom> customs = new ArrayList<>();
	private int flag;
	private String comarca_cnj;
	private String comarca;
	private int tribunalID;
	private int classeNatureza_dg;
	private String foro_cnj;
	private String tribunal;
	private int processoID;
	private String distribuicaoData;
	private boolean arquivado;
	private ArrayList<Classe> classes = new ArrayList<>();
	private ArrayList<Acesso> acessos = new ArrayList<>();
	private String uf;
	private String criadoEm;
	private ArrayList<Parte> partes = new ArrayList<>();
	
	public boolean isRegional_cnj() {
		return regional_cnj;
	}

	public void setRegional_cnj(boolean regional_cnj) {
		this.regional_cnj = regional_cnj;
	}

	public String getNumeroAlternativo() {
		return numeroAlternativo;
	}

	public void setNumeroAlternativo(String numeroAlternativo) {
		this.numeroAlternativo = numeroAlternativo;
	}

	public ArrayList<AnexoObj> getAnexos() {
		return anexos;
	}

	public void setAnexos(ArrayList<AnexoObj> anexos) {
		this.anexos = anexos;
	}

	public String getVara() {
		return vara;
	}

	public void setVara(String vara) {
		this.vara = vara;
	}

	public String getClasseNatureza() {
		return classeNatureza;
	}

	public void setClasseNatureza(String classeNatureza) {
		this.classeNatureza = classeNatureza;
	}

	public ArrayList<Mov> getMovs() {
		return movs;
	}

	public void setMovs(ArrayList<Mov> movs) {
		this.movs = movs;
	}

	public String getDistribuicaoTipo() {
		return distribuicaoTipo;
	}

	public void setDistribuicaoTipo(String distribuicaoTipo) {
		this.distribuicaoTipo = distribuicaoTipo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getJuiz() {
		return juiz;
	}

	public void setJuiz(String juiz) {
		this.juiz = juiz;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAssuntoExtra() {
		return assuntoExtra;
	}

	public void setAssuntoExtra(String assuntoExtra) {
		this.assuntoExtra = assuntoExtra;
	}

	public ArrayList<Audiencia> getAudiencias() {
		return audiencias;
	}

	public void setAudiencias(ArrayList<Audiencia> audiencias) {
		this.audiencias = audiencias;
	}

	public String getVara_original() {
		return vara_original;
	}

	public void setVara_original(String vara_original) {
		this.vara_original = vara_original;
	}

	public int getExtinto() {
		return extinto;
	}

	public void setExtinto(int extinto) {
		this.extinto = extinto;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getAlteradoEm() {
		return alteradoEm;
	}

	public void setAlteradoEm(String alteradoEm) {
		this.alteradoEm = alteradoEm;
	}

	public String getFonte_sistema() {
		return fonte_sistema;
	}

	public void setFonte_sistema(String fonte_sistema) {
		this.fonte_sistema = fonte_sistema;
	}

	public String getForo() {
		return foro;
	}

	public void setForo(String foro) {
		this.foro = foro;
	}

	public int getSituacao_situacaoID() {
		return situacao_situacaoID;
	}

	public void setSituacao_situacaoID(int situacao_situacaoID) {
		this.situacao_situacaoID = situacao_situacaoID;
	}

	public int getInstancia() {
		return instancia;
	}

	public void setInstancia(int instancia) {
		this.instancia = instancia;
	}

	public String getSentencaData() {
		return sentencaData;
	}

	public void setSentencaData(String sentencaData) {
		this.sentencaData = sentencaData;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ArrayList<Custom> getCustoms() {
		return customs;
	}

	public void setCustoms(ArrayList<Custom> customs) {
		this.customs = customs;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getComarca_cnj() {
		return comarca_cnj;
	}

	public void setComarca_cnj(String comarca_cnj) {
		this.comarca_cnj = comarca_cnj;
	}

	public String getComarca() {
		return comarca;
	}

	public void setComarca(String comarca) {
		this.comarca = comarca;
	}

	public int getTribunalID() {
		return tribunalID;
	}

	public void setTribunalID(int tribunalID) {
		this.tribunalID = tribunalID;
	}

	public int getClasseNatureza_dg() {
		return classeNatureza_dg;
	}

	public void setClasseNatureza_dg(int classeNatureza_dg) {
		this.classeNatureza_dg = classeNatureza_dg;
	}

	public String getForo_cnj() {
		return foro_cnj;
	}

	public void setForo_cnj(String foro_cnj) {
		this.foro_cnj = foro_cnj;
	}

	public String getTribunal() {
		return tribunal;
	}

	public void setTribunal(String tribunal) {
		this.tribunal = tribunal;
	}

	public int getProcessoID() {
		return processoID;
	}

	public void setProcessoID(int processoID) {
		this.processoID = processoID;
	}

	public String getDistribuicaoData() {
		return distribuicaoData;
	}

	public void setDistribuicaoData(String distribuicaoData) {
		this.distribuicaoData = distribuicaoData;
	}

	public boolean isArquivado() {
		return arquivado;
	}

	public void setArquivado(boolean arquivado) {
		this.arquivado = arquivado;
	}

	public ArrayList<Classe> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<Classe> classes) {
		this.classes = classes;
	}

	public ArrayList<Acesso> getAcessos() {
		return acessos;
	}

	public void setAcessos(ArrayList<Acesso> acessos) {
		this.acessos = acessos;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(String criadoEm) {
		this.criadoEm = criadoEm;
	}

	public ArrayList<Parte> getPartes() {
		return partes;
	}

	public void setPartes(ArrayList<Parte> partes) {
		this.partes = partes;
	}

	public Processo(boolean regional_cnj, String numeroAlternativo, ArrayList<AnexoObj> anexos, String vara,
			String classeNatureza, ArrayList<Mov> movs, String distribuicaoTipo, String situacao, String juiz,
			String area, String assuntoExtra, ArrayList<Audiencia> audiencias, String vara_original, int extinto,
			int valor, String alteradoEm, String fonte_sistema, String foro, int situacao_situacaoID, int instancia,
			String sentencaData, String numero, ArrayList<Custom> customs, int flag, String comarca_cnj, String comarca,
			int tribunalID, int classeNatureza_dg, String foro_cnj, String tribunal, int processoID,
			String distribuicaoData, boolean arquivado, ArrayList<Classe> classes, ArrayList<Acesso> acessos, String uf,
			String criadoEm, ArrayList<Parte> partes) {
		super();
		this.regional_cnj = regional_cnj;
		this.numeroAlternativo = numeroAlternativo;
		this.anexos = anexos;
		this.vara = vara;
		this.classeNatureza = classeNatureza;
		this.movs = movs;
		this.distribuicaoTipo = distribuicaoTipo;
		this.situacao = situacao;
		this.juiz = juiz;
		this.area = area;
		this.assuntoExtra = assuntoExtra;
		this.audiencias = audiencias;
		this.vara_original = vara_original;
		this.extinto = extinto;
		this.valor = valor;
		this.alteradoEm = alteradoEm;
		this.fonte_sistema = fonte_sistema;
		this.foro = foro;
		this.situacao_situacaoID = situacao_situacaoID;
		this.instancia = instancia;
		this.sentencaData = sentencaData;
		this.numero = numero;
		this.customs = customs;
		this.flag = flag;
		this.comarca_cnj = comarca_cnj;
		this.comarca = comarca;
		this.tribunalID = tribunalID;
		this.classeNatureza_dg = classeNatureza_dg;
		this.foro_cnj = foro_cnj;
		this.tribunal = tribunal;
		this.processoID = processoID;
		this.distribuicaoData = distribuicaoData;
		this.arquivado = arquivado;
		this.classes = classes;
		this.acessos = acessos;
		this.uf = uf;
		this.criadoEm = criadoEm;
		this.partes = partes;
	}
	
}
