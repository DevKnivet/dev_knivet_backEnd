package escavadorProcesso;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import escavador.Processo;
import get.Get;
import set.Set;
import tabelas.Escavador_id_movimentacoes;


// Recebe como argumento o token de autorização e ID do processo
// Devolve um ArrayList com titulo/descrição da publicasção do diário do processo


// id = id é uma
public class MovimentacaoProcesso {
	
	private CardTrelloEscavador titulo = new CardTrelloEscavador("");
	
	public CardTrelloEscavador getMovimentacao(String token, int id) throws Exception{
		   String link = "https://www.escavador.com/api/v1/movimentacoes/"+id;
		// String link = "https://www.escavador.com/api/v1/movimentacoes/"+286417944;
				 HttpClient client = HttpClients.custom().build();
				 
				 // seta no request as informações do HTTP
				 HttpUriRequest request = RequestBuilder.get()
						  .setUri(link)
					
						  .setHeader("Authorization", "Bearer " + token)
						  .setHeader("X-Requested-With", "XMLHttpRequest")
						  .build();
					
				 // executa o HTTP
				 HttpResponse response =  client.execute(request);
				 String string_JSON = EntityUtils.toString(response.getEntity());
				 JSONObject jo = new JSONObject (string_JSON);
				 int idMovimentacao = (int) jo.get("id");
 				 String processo = (String)jo.get("descricao_pequena");
 				 processo = processo.replace("Movimentação do processo","").trim();
				 /*
				 Set set = new Set();
				 
				
				 if(verificandoIdMovimentacao(idMovimentacao)){
					 // não insere no banco de dados
				 }else if(!(verificandoIdMovimentacao(idMovimentacao))){
					 // insere no banco de dados
					 // Vai ter erro de conexão com o usuário
					 Escavador_id_movimentacoes aux = new Escavador_id_movimentacoes();
				//	 aux.setId_usr(id_usr);
					 aux.setNum_processo(""+idMovimentacao);
					 set.setEscavador_id_movimentacoes(aux);
				 }
				 */
				// System.out.println(string_JSON);
						 
				// ArrayList idMovimentacoes = new ArrayList();
				 
				// Escavador_id_movimentacoes movimentacoes = new Escavador_id_movimentacoes();
				 
				 
				 	ArrayList<CardTrelloEscavador>postCard = new ArrayList<CardTrelloEscavador>();
				 	
				 	CardTrelloEscavador aux = new CardTrelloEscavador("");
				 	aux.setTitulo(tituloCardTrello(string_JSON));
				 	aux.setDescricao(descricaoCardTrello(string_JSON));
				 	aux.setIdMovimentacao(idMovimentacao);
				 	aux.setProcesso(processo);
				 	
				 	
				 	return aux;
				 
				 
	}			
	
	public String descricaoCardTrello(String stringJson){
		 EscavadorJSON json = new EscavadorJSON();
		 Processo processo = json.tratarJSON(stringJson);
		 
		 String conteudo = processo.getConteudo().replace("<p>", "")
				 .replace("\"", "")
				 .replace("<div>","").replaceAll("</div>", "")
				 .replace("<p>", "").replace("</p>","")
				 .replace("<span>","").replace("</span>", "").replace("<br>", "")
				 .replace("<span style="+"font-family:Arial, sans-serif;font-weight:bold;color:#231F20;"+" class="+"content-small"+">", "")
				 .replace("<p style=text-indent:14pt;><span style=font-family:Arial, sans-serif;color:#231F20; class=content-small>", "")
				 .replace("<p style=text-indent:28pt;><span style=font-family:Verdana, sans-serif; class=content-medium>", "")
				 .replace("<span style=font-family:Verdana, sans-serif; class=content-medium>","")
				 .trim();
		 
		 String texto_categoria = processo.getTexto_categoria().replace("<p>", "")
				 .replace("\"", "")
				 .replace("<div>","").replaceAll("</div>", "")
				 .replace("<p>", "").replace("</p>","")
				 .replace("<span>","").replace("</span>", "").replace("<br>", "\n")
				 .replace("<span style="+"font-family:Arial, sans-serif;font-weight:bold;color:#231F20;"+" class="+"content-small"+">", "")
				 .replace("<p style=text-indent:14pt;><span style=font-family:Arial, sans-serif;color:#231F20; class=content-small>", "")
				 .replace("<span style=font-family:Verdana, sans-serif;font-weight:bold; class=content-x-small>","")
				 .replace("<span class=content-bold >","")
				 .trim();
		 
		 
		 String x = processo.getDescricao_pequena()
				 +"\n"+ processo.getDiario_oficial()
				 + "\n" + processo.getTipo()
				 + "\n" + processo.getSecao()
				 + "\n" + texto_categoria
				 + "\n" + conteudo;
		 
		 
		 System.out.println(x + "\n");
		 titulo.setDescricao(x);
		 return x;
		 // informações
		 /*
		  * Descrição pequena :
		  * diario oficial
		  * Tipo
		  * secao
		  * conteudoz
		  */
	}
	
	public String tituloCardTrello(String stringJson) {
		 EscavadorJSON json = new EscavadorJSON();
		 Processo processo = json.tratarJSON(stringJson);
		
		 
		 ArrayList<Envolvidos> envolvidos = processo.getEnvolvido();
//		 CardTrelloEscavador titulo = new CardTrelloEscavador("");
		
			 
		
		 for(int i=0;i<= envolvidos.size();i++){
			 
			 try{
			 
				 Envolvidos aux = (Envolvidos)envolvidos.get(i);
			
			 	// System.out.println("teste2");
			
			 	if(aux.getPivot_tipo().equals("AGRAVANTE") /*|| aux.getPivot_tipo().equals("AUTOR")*/){
				 	titulo.setParteProcesso(titulo.getParteProcesso() +aux.getNome() + " / ");
				 	titulo.setParteUm("Agravante");
			 	}else 
			 		
			 		if(aux.getPivot_tipo().equals("AUTOR") || aux.getPivot_tipo().equals("PARTE AUTORA")){
			 			titulo.setParteProcesso(titulo.getParteProcesso() +aux.getNome() + " / ");
					 	titulo.setParteUm("Autor");
			 		}else
			 			if(aux.getPivot_tipo().equals("APELANTE")){
				 			titulo.setParteProcesso(titulo.getParteProcesso() +aux.getNome() + " / ");
						 	titulo.setParteUm("Apelante");
				 		}
			 		
			 		
			 			else
			 		
			 				if(aux.getPivot_tipo().contains("AGRAVAD") ){
			 					titulo.setParteProcessada(titulo.getParteProcessada()+aux.getNome() +  " / ");
			 					titulo.setParteDois("Agravado(a)");	
			 				}else
			 				
			 					if ( aux.getPivot_tipo().equals("REU") || aux.getPivot_tipo().equals("PARTE RÉ")){
			 						titulo.setParteProcessada(titulo.getParteProcessada()+aux.getNome() +  " / ");
			 						titulo.setParteDois("Réu");	
			 					}else
			 						if(aux.getPivot_tipo().contains("APELAD")){
			 							titulo.setParteProcessada(titulo.getParteProcessada()+aux.getNome() +  " / ");
				 						titulo.setParteDois("Apelado");	
			 						}
			 							else
			 								if(!((aux.getPivot_tipo().equals("ADVOGADO")) || (aux.getPivot_tipo().equals("ADVOGADA")) || (aux.getPivot_tipo().equals("REPRESENTANTE")) || (aux.getPivot_tipo().contains("JUIZ")) )){
			 									titulo.setParteNaoIdentificada(titulo.getParteNaoIdentificada()+aux.getNome() + " / ");
			 									titulo.setParteZero("Partes: ");
			 									titulo.setParteDois("");
			 									titulo.setParteUm("");
			 								}
			 	
		 	}catch(IndexOutOfBoundsException z){
				continue;
				
			}
			
			
		 }
		 	String retirarChar = "";
		 	if(titulo.getParteUm().equals("") && titulo.getParteDois().equals("")){
		 		 titulo.setTitulo(titulo.getParteZero()+titulo.getParteNaoIdentificada());
		 		 retirarChar = titulo.getTitulo().substring(0, titulo.getTitulo().length() - 3);
		 	}else{
		 		titulo.setTitulo(titulo.getParteUm()+" - "+titulo.getParteProcesso() + "\n" + titulo.getParteDois()+" - "+titulo.getParteProcessada());
		 		 retirarChar = titulo.getTitulo().substring(0, titulo.getTitulo().length() - 3);
		 	}
		 	 System.out.println(retirarChar + "\n");
		 	 return retirarChar;
	
	}
	
	public String dataCardTrello(String stringJson){

		String data = "";
		 EscavadorJSON json = new EscavadorJSON();
		 Processo processo = json.tratarJSON(stringJson);
		 data = processo.getData();
		
		return data;
	}
	
	
	
	public boolean verificandoIdMovimentacao(int id ) throws Exception{

		 String idString = ""+id;
		 boolean aux = false;
		 Get get = new Get();				 
		 ArrayList <Escavador_id_movimentacoes>arrayListObjetoIdMovimentacoes =  get.Escavador_Id_Movimentacoes();
		
		
		 for(int i=0;i<arrayListObjetoIdMovimentacoes.size();i++)
		 {
			 Escavador_id_movimentacoes escavadorMovimentacoes = (Escavador_id_movimentacoes) arrayListObjetoIdMovimentacoes.get(i);
			 // ele não trata o erro de um ID de movimentação, estiver em mais de um usuário , mais para frente se preocupar com isso
			 
			 if (escavadorMovimentacoes.getNum_processo().equals(idString)){
				 aux =  true;
			 }else{
				 aux = false;
			 }			 
		 }
		return aux;
	}
	
	

}