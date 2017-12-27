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


// Recebe como argumento o token de autoriza��o e ID do processo
// Devolve um ArrayList com titulo/descri��o da publicas��o do di�rio do processo


// id = id � uma
public class MovimentacaoProcesso {
	
	
	public ArrayList<String> getMovimentacao(String token, int id) throws Exception{
		   String link = "https://www.escavador.com/api/v1/movimentacoes/"+id;
		// String link = "https://www.escavador.com/api/v1/movimentacoes/"+286417944;
				 HttpClient client = HttpClients.custom().build();
				 
				 // seta no request as informa��es do HTTP
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
				 
				 /*
				 Set set = new Set();
				 
				
				 if(verificandoIdMovimentacao(idMovimentacao)){
					 // n�o insere no banco de dados
				 }else if(!(verificandoIdMovimentacao(idMovimentacao))){
					 // insere no banco de dados
					 // Vai ter erro de conex�o com o usu�rio
					 Escavador_id_movimentacoes aux = new Escavador_id_movimentacoes();
				//	 aux.setId_usr(id_usr);
					 aux.setNum_processo(""+idMovimentacao);
					 set.setEscavador_id_movimentacoes(aux);
				 }
				 */
				// System.out.println(string_JSON);
						 
				// ArrayList idMovimentacoes = new ArrayList();
				 
				// Escavador_id_movimentacoes movimentacoes = new Escavador_id_movimentacoes();
				 	ArrayList<String>postCard = new ArrayList<String>();
					postCard.add(tituloCardTrello(string_JSON));	
					postCard.add(descricaoCardTrello(string_JSON));
					
				 
				 
				
			
	
				 
				 // ele s� vai retornar o JSON da movimenta��o SE n�o tiver retornado antes, ou seja, se n�o estiver do BD
				 // como vamos estruturar o BD?
				 // criar uma tabela com as colunas,
			
				 // usu�rio, processo, idMovimenta��o, onde o usu�rio vai ser PK E FK 
				 
				 
				 
				 return postCard;
				 
				 
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
		 return x;
		 // informa��es
		 /*
		  * Descri��o pequena :
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
		 CardTrelloEscavador titulo = new CardTrelloEscavador("");
		
			 
		
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
			 				
			 					if ( aux.getPivot_tipo().equals("REU") || aux.getPivot_tipo().equals("PARTE R�")){
			 						titulo.setParteProcessada(titulo.getParteProcessada()+aux.getNome() +  " / ");
			 						titulo.setParteDois("R�u");	
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
		 ArrayList <Escavador_id_movimentacoes>arrayListObjetoIdMovimentacoes =  get.buscarEscavador_Id_Movimentacoes();
		
		
		 for(int i=0;i<arrayListObjetoIdMovimentacoes.size();i++)
		 {
			 Escavador_id_movimentacoes escavadorMovimentacoes = (Escavador_id_movimentacoes) arrayListObjetoIdMovimentacoes.get(i);
			 // ele n�o trata o erro de um ID de movimenta��o, estiver em mais de um usu�rio , mais para frente se preocupar com isso
			 
			 if (escavadorMovimentacoes.getNum_processo().equals(idString)){
				 aux =  true;
			 }else{
				 aux = false;
			 }			 
		 }
		return aux;
	}
	
	

}