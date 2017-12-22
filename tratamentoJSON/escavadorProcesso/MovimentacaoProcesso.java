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

import get.Get;
import set.Set;
import tabelas.Escavador_id_movimentacoes;


// Recebe como argumento o token de autorização e ID do processo
// Devolve uma string JSON com os detalhes da publicasção do diário do processo


// id = id é uma
public class MovimentacaoProcesso {
	
	
	public String getMovimentacao(String token, int id) throws Exception{
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
				 
				 System.out.println(string_JSON);
				 
				// ArrayList idMovimentacoes = new ArrayList();
				 
				// Escavador_id_movimentacoes movimentacoes = new Escavador_id_movimentacoes();
				 
				 
				 
				 
				
			
	
				 
				 // ele só vai retornar o JSON da movimentação SE não tiver retornado antes, ou seja, se não estiver do BD
				 // como vamos estruturar o BD?
				 // criar uma tabela com as colunas,
			
				 // usuário, processo, idMovimentação, onde o usuário vai ser PK E FK 
				 
				 
				 
				 return string_JSON;
				 
				 
	}			 
	
	public boolean verificandoIdMovimentacao(int id ) throws Exception{

		String idString = ""+id;
		boolean aux = false;
		 Get get = new Get();				 
		 ArrayList <Escavador_id_movimentacoes>arrayListObjetoIdMovimentacoes =  get.buscarEscavador_Id_Movimentacoes();
		
		
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