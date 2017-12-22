package outputs.trello;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

//Requesição de Key https://trello.com/app-key
//Key Knivet teste: fae4acfcba958d16f9af4bef4f58156c
//Token permanente: b82e489a106bfe0032a01eb540b5f85b3a729d345a00f2b85ee633665f12c3f6

public class TrelloPostList {

	public static String PostList(String nomeB,String idBoard,String key, String token) throws ClientProtocolException, IOException
	{
		String id = "";
		//Inicia cliente HTTP
		HttpClient httpclient = HttpClients.createDefault();
		//Link base da trello boards
		HttpPost httppost = new HttpPost("https://api.trello.com/1/lists");
		//Cria variavel List para adicionar os parametros
		List<NameValuePair> parametros = new ArrayList<NameValuePair>(2);
		//BasicNameValuePair(tipo do parametro {ver site trello devellopers}), valor que será passado)
		parametros.add(new BasicNameValuePair("name", nomeB));
		parametros.add(new BasicNameValuePair("idBoard", idBoard));
		parametros.add(new BasicNameValuePair("key", key));
		parametros.add(new BasicNameValuePair("token", token));
		//Encode todos os parametros na entidade do site http
		httppost.setEntity(new UrlEncodedFormEntity(parametros, "UTF-8"));
		//Envia o http montado para a internet
		HttpResponse response = httpclient.execute(httppost);
		//Pega resposta do http (ainda não implementado)
		
		//Tratamento da resposta (ainda nao implementado)
		HttpEntity entity = response.getEntity();
		 if (entity != null) {
			 String output = EntityUtils.toString(response.getEntity());
			 JSONObject json = new JSONObject(output);
			 id = json.get("id").toString();	
		 }
		 return id;
	}
}
