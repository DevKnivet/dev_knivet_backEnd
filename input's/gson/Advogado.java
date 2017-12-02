package gson;

public class Advogado {

	private String id;
	private String nome;
	private String null1;
	private String null2;
	private String null3;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNull1() {
		return null1;
	}

	public void setNull1(String null1) {
		this.null1 = null1;
	}

	public String getNull2() {
		return null2;
	}

	public void setNull2(String null2) {
		this.null2 = null2;
	}

	public String getNull3() {
		return null3;
	}

	public void setNull3(String null3) {
		this.null3 = null3;
	}

	public Advogado(String id, String nome, String null1, String null2, String null3) {
		super();
		this.id = id;
		this.nome = nome;
		this.null1 = null1;
		this.null2 = null2;
		this.null3 = null3;
	}
	
}
