package escavadorProcesso;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


// Essa classe recebe o TOKEN do usuário como argumento
// E devolve uma list de IDs com os monitoramentos cadastrados pelo usuário

public class MonitoramentoDiario {
	
public String monitoramentoDiario(String token) throws Exception{
	
		ArrayList listId = new ArrayList();
		
		try{
			
			
		 String link2 = "https://www.escavador.com/api/v1/monitoramentos";
		 HttpClient client = HttpClients.custom().build();
		 
		 // seta no request as informações do HTTP
		 HttpUriRequest request = RequestBuilder.get()
				  .setUri(link2)
				  
				  .setHeader("Authorization", "Bearer " + token)
				  .setHeader("X-Requested-With", "XMLHttpRequest")
				  .build();
		 
		 // executa o HTTP
		 HttpResponse response2 =  client.execute(request);
		 
		 //ranforma o retorno em string e Printa na tela a resposta
		 String aux = EntityUtils.toString(response2.getEntity());
	//	 System.out.println(aux);
		 JSONObject jo = new JSONObject (aux);
		 
		 
		 JSONArray x =  (JSONArray) jo.get("items");
		 
		 boolean gambiarra = false;
		 int i = 0;
		 ArrayList list = new ArrayList();
		 while(gambiarra == false){
			 try{
				 list.add(x.get(i));
				 i = i+1;
			 }catch(JSONException e){
				 gambiarra = true;	 
			 }
		 }
		 
		 for(int j = 0;j<=list.size();j++){
			 JSONObject jAux = (JSONObject) list.get(j); 
			 
			 String categoria = (String)jAux.get("categoria");
			 
			 
			 if (("PESSOA".equals(categoria)) || ("ADVOGADO".equals(categoria)) ){
				 int id = (int) jAux.get("id");
				//	 System.out.println(id);
				 //getAparicoesMonitoramento(token,id);
				 	AparicoesProcesso aparicoes = new AparicoesProcesso();
				 	aparicoes.getAparicoesMonitoramento(token, id);
				 //	listId.add(id);
				 	
				 	
				 
			 }
			 
			
			 
		}
		 
		 
		}catch(IndexOutOfBoundsException z){
			
			 return "erro";
		} catch (IOException e) {
			
			 return "erro";
		} catch (JSONException e) {
			 
			 return "erro";
		}
		return "sucesso";
		
	}
}
