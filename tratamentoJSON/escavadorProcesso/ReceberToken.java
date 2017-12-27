package escavadorProcesso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


// Essa classe através do método getToken, recebe Email e senha e devolve um token de acesso a API
// Caso a senha esteja errada, devolve uma String "erro"

public class ReceberToken {
	
public String getToken(String email, String senha) throws IOException{
		
		//                 REQUISÃO DO TOKEN
		
		//pega o link de requição do token, tipo post
		String link = "https://www.escavador.com/api/v1/request-token";
		
		// não sei dizer ao certo, mas necessário
		HttpClient httpclient = HttpClients.createDefault();
		// Tipo de HTTP Post
		HttpPost httppost = new HttpPost(link);
		   
		// add os parametros que são passados via HTTP
		List<NameValuePair> params = new ArrayList<>(2);
		//"morg.guilherme@gmail.com"
		//+"AnnaBeth10"
		params.add(new BasicNameValuePair("username",email));
		params.add(new BasicNameValuePair("password",senha));
		
		// adiciona no objeto HttpPost os parametros 
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		
		// Executa a URL, devolvendo um objeto do tipo mHttpResponse
		HttpResponse response = httpclient.execute(httppost);
			
		//Transforma o resultado em uma string e printa.
		String aux = EntityUtils.toString(response.getEntity());
		//System.out.println(aux);
		// Trata a String, devolvendo somente o token de acesso
		
		try{
			
		
		
		String []array = aux.split(",");
		String []array2 = array[2].split(":");
		String p = array2[1].replaceAll("\"", "");
		return p;
		} catch(ArrayIndexOutOfBoundsException erro){
			return "erro";
			
		}
		
}
	

}
