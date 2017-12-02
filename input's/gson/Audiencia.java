package gson;

public class Audiencia {
	private String data;
	private String foro;
	private String tipoAud;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getForo() {
		return foro;
	}

	public void setForo(String foro) {
		this.foro = foro;
	}

	public String getTipoAud() {
		return tipoAud;
	}

	public void setTipoAud(String tipoAud) {
		this.tipoAud = tipoAud;
	}

	public Audiencia(String data, String foro, String tipoAud) {
		super();
		this.data = data;
		this.foro = foro;
		this.tipoAud = tipoAud;
	}
	
	

}
