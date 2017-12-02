package gson;

import java.util.ArrayList;

public class AnexoObj {

	private ArrayList<Anexo> anexos = new ArrayList<>();

	public ArrayList<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(ArrayList<Anexo> anexos) {
		this.anexos = anexos;
	}

	public AnexoObj(ArrayList<Anexo> anexos) {
		super();
		this.anexos = anexos;
	}
	
}
