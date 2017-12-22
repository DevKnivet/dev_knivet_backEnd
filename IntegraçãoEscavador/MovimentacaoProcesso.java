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

import get.Get;
import tabelas.Escavador_id_movimentacoes;


// Recebe como argumento o token de autoriza��o e ID do processo
// Devolve uma string JSON com os detalhes da publicas��o do di�rio do processo


// id = id � uma
public class MovimentacaoProcesso {
	
	
	public String getMovimentacao(String token, int id) throws IOException, JSONException{
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
				// verificarBD(idMovimentacao);
				 System.out.println(string_JSON);
				 
				 ArrayList idMovimentacoes = new ArrayList();
				 
				 Escavador_id_movimentacoes movimentacoes = new Escavador_id_movimentacoes();
				 Get get = new get();				 
				 arrayListObjetoIdMovimentacoes =  get.buscarEscavador_Id_Movimentacoes();
				 
				 
				 
				
			
	
				 
				 // ele s� vai retornar o JSON da movimenta��o SE n�o tiver retornado antes, ou seja, se n�o estiver do BD
				 // como vamos estruturar o BD?
				 // criar uma tabela com as colunas,
			
				 // usu�rio, processo, idMovimenta��o, onde o usu�rio vai ser PK E FK 
				 
				 
				 
				 return string_JSON;
				 
				 
	}			 
	
	private boolean verificandoIdMovimentacao(int id, ArrayList idMovimentacoes ){
		 for(int i=0;i<arrayListObjetoIdMovimentacoes.size();i++)
		 {
			 arrayListObjetoIdMovimentacoes.get(i).getId;
			 arrayListObjetoIdMovimentacoes.get(i).getIdProcesso;
			 
		 }
		 
	
		return true;
		
	}
				

	
	
}