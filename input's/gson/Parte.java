package gson;

import java.util.ArrayList;

public class Parte {
	
	private int id1;
	private int id2;
	private String nome1;
	private String nome2;
	private int id3;
	private int id4;
	private String cnpj;
	private int id5;
	private String tipo;
	private ArrayList<Advogado> advogados = new ArrayList<>();
	private boolean b1;
	private boolean b2;
	private boolean b3;
	private boolean b4;;
	private String null1;
	private String null2;
	public Parte(int id1, int id2, String nome1, String nome2, int id3, int id4, String cnpj, int id5, String tipo,
			ArrayList<Advogado> advogados, boolean b1, boolean b2, boolean b3, boolean b4, String null1, String null2) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.nome1 = nome1;
		this.nome2 = nome2;
		this.id3 = id3;
		this.id4 = id4;
		this.cnpj = cnpj;
		this.id5 = id5;
		this.tipo = tipo;
		this.advogados = advogados;
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.b4 = b4;
		this.null1 = null1;
		this.null2 = null2;
	}
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	public String getNome1() {
		return nome1;
	}
	public void setNome1(String nome1) {
		this.nome1 = nome1;
	}
	public String getNome2() {
		return nome2;
	}
	public void setNome2(String nome2) {
		this.nome2 = nome2;
	}
	public int getId3() {
		return id3;
	}
	public void setId3(int id3) {
		this.id3 = id3;
	}
	public int getId4() {
		return id4;
	}
	public void setId4(int id4) {
		this.id4 = id4;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public int getId5() {
		return id5;
	}
	public void setId5(int id5) {
		this.id5 = id5;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ArrayList<Advogado> getAdvogados() {
		return advogados;
	}
	public void setAdvogados(ArrayList<Advogado> advogados) {
		this.advogados = advogados;
	}
	public boolean isB1() {
		return b1;
	}
	public void setB1(boolean b1) {
		this.b1 = b1;
	}
	public boolean isB2() {
		return b2;
	}
	public void setB2(boolean b2) {
		this.b2 = b2;
	}
	public boolean isB3() {
		return b3;
	}
	public void setB3(boolean b3) {
		this.b3 = b3;
	}
	public boolean isB4() {
		return b4;
	}
	public void setB4(boolean b4) {
		this.b4 = b4;
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
	
}
