package outputs.trello;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import get.Get;

// Essa classe retorna o ID de uma board se existir, caso não, retorna uma string de erro

public class TrelloPostExistingBoard {
	
	public String ProcurarBoardExistente(String key, String token, String username, String boardname) {
		
		try{
		String link = "https://api.trello.com/1/members/"+username+"/boards";
		HttpClient client = HttpClients.custom().disableCookieManagement().build();
		 // seta no request as informações do HTTP
		 HttpUriRequest request = RequestBuilder.get()
				  .setUri(link)
				 // .addParameter(new BasicNameValuePair("id",username))
				  .addParameter(new BasicNameValuePair("key",key))
				  .addParameter(new BasicNameValuePair("token",token))
				   
				  .build();
			
		 // executa o HTTP
		 HttpResponse response =  client.execute(request);
		 String aux = EntityUtils.toString(response.getEntity());	 
		 JSONArray y = new JSONArray(aux);
		  
		 boolean gambiarra = false;
		 int i = 0;
		 ArrayList list = new ArrayList();
		 while(gambiarra == false){
			 try{
				 list.add(y.get(i));
				 i = i+1;
			 }catch(JSONException e){
				 gambiarra = true;	 
				 
			 }
		 }
		 
		 for(int j = 0;j<=list.size();j++){
			 JSONObject jAux = (JSONObject) list.get(j); 
			 
			 String nome = (String)jAux.get("name");
			 
			 if(nome.equals(boardname)){
				 return  (String)jAux.get("id");
			 }
			 
		}
		 	
		} catch (IOException e) {
			e.printStackTrace();
			 System.out.println("erroa");
		} catch (IndexOutOfBoundsException e){
			return "board não encontrada";
		
		}
		
		return "board não encontrada";
	}
	/*
	public static void main(String Args[]) throws Exception{
		
		Get get = new Get();
		TrelloTokenKey tokenKey = get.getTokenKey(28);
		TrelloGetMemberID getMember = new TrelloGetMemberID();
		String memberId = getMember.getMemberId(tokenKey.getToken(), tokenKey.getKey());
		TrelloPostExistingBoard boardExistente = new TrelloPostExistingBoard();
		
		
		if(boardExistente.ProcurarBoardExistente(tokenKey.getKey(), tokenKey.getToken(), memberId, "Knivet").equals("board não encontrada")){
			System.out.println("Entrou if");
			
		}else{
			System.out.println("Fora do IF");
		}
		
	}
	*/

}
