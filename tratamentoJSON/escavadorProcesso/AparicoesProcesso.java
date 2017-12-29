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

public class AparicoesProcesso {
	
		private static String erro = "erro";
		
	public String getAparicoesMonitoramento(String token, int id ) throws Exception{
		// String link = "https://www.escavador.com/api/v1/monitoramentos/"+90175+"/aparicoes";
		ArrayList listId = new ArrayList();
		try{
		String link = "https://www.escavador.com/api/v1/monitoramentos/"+id+"/aparicoes";
		 HttpClient client = HttpClients.custom().build();
		 
		 // seta no request as informações do HTTP
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
			MovimentacaoProcesso movimentacao = new MovimentacaoProcesso();
			movimentacao.getMovimentacao(token, objeto_id);
		
			 
		}
		
		}catch(IndexOutOfBoundsException z){
			
			 return erro;
		} catch (IOException e) {
			 
			 return erro;
		} catch (JSONException e) {
			 
			 return erro;
		}
		return "sucesso";
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
