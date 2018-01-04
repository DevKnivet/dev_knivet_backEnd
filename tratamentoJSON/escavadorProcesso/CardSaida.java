package escavadorProcesso;

import java.util.ArrayList;

public class CardSaida {
	private ArrayList<CardTrelloEscavador> card = new ArrayList<CardTrelloEscavador>();
	private int id_usuario;
	
	public ArrayList<CardTrelloEscavador> getCard() {
		return card;
	}
	public void setCard(ArrayList<CardTrelloEscavador> card) {
		this.card = card;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
}
