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

// Essa classe cont�m o m�todo getAparicoesMonitoramento, onde no m�todo getAparicoes, retorna um ArrayList
// com os IDs das movimenta��es

public class AparicoesProcesso {
	
		private static String erro = "erro";
		
	public ArrayList<Integer> getAparicoesMonitoramento(String token, int id ) throws Exception{
		// String link = "https://www.escavador.com/api/v1/monitoramentos/"+90175+"/aparicoes";

		ArrayList<Integer>postCard = new ArrayList<Integer>();
		try{
		String link = "https://www.escavador.com/api/v1/monitoramentos/"+id+"/aparicoes";
		 HttpClient client = HttpClients.custom().build();
		 
		 // seta no request as informa��es do HTTP
		 HttpUriRequest request = RequestBuilder.get()
				  .setUri(link)
			
				  .setHeader("Authorization", "Bearer " + token)
				  .setHeader("X-Requested-With", "XMLHttpRequest")
				  .build();
			
		 // executa o HTTP
		 HttpResponse response =  client.execute(request);
		 String aux = EntityUtils.toString(response.getEntity());

		 
		 
		// System.out.println(aux);
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
			 int objeto_id = (int) jAux.get("objeto_id");
			 
		//	 System.out.println(objeto_id);
		//	MovimentacaoProcesso movimentacao = new MovimentacaoProcesso();
			postCard.add(objeto_id);
		
			 
		}
		
		}catch(IndexOutOfBoundsException z){
			
			 z.getStackTrace();
		} catch (IOException e) {
			 
			 e.getStackTrace();
		} catch (JSONException e) {
			 
			 e.getStackTrace();
		}
		return postCard;
	}
	/*
	public void setArrayList (String token, ArrayList id) throws IOException{
		
		for (int i =0;i<=id.size();i++){
			int num_id = (int)id.get(i);
			getAparicoesMonitoramento(token, num_id);
			
		}
		
	}
	
	*/
	
	
}
