package outputs.trello;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class TrelloGetMemberID {

	
	public String getMemberId(String token, String key){
		String idMember = "";
		
		try{
			String link = "https://api.trello.com/1/tokens/"+token;
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
			 JSONObject jo = new JSONObject (aux);
			  idMember = (String)jo.get("idMember");
			 
			 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return idMember;
		
	}
	
}
