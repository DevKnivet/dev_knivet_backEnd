package escavadorProcesso;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import digesto.Digesto;
import digestoData4.Anexos;
import digestoInput.DigestoJSON;
import escavador.Processo;

public class EscavadorJSON {
	ArrayList<Envolvidos> envolvido = new ArrayList<Envolvidos>();
	public Processo tratarJSON(String input)
	{
		Processo processo = new Processo();
		JSONObject json = new JSONObject(input);
		processo.setData(json.optString("data"));
		processo.setDescricao_pequena(json.optString("descricao_pequena"));
		processo.setDiario_oficial(json.optString("diario_oficial"));
		processo.setEstado(json.optString("estado"));
		processo.setTipo(json.optString("tipo"));
		processo.setSecao(json.optString("secao"));
		processo.setConteudo(json.optString("conteudo"));
		processo.setTexto_categoria(json.opt("texto_categoria").toString());
		JSONArray envolvidosArray = json.getJSONArray("envolvidos");
		for(int i=0;i<envolvidosArray.length();i++)
		{
			JSONObject envolvidosObj = new JSONObject();
			envolvidosObj = envolvidosArray.getJSONObject(i);				
			Envolvidos envolvidosClasse = new Envolvidos();
			envolvidosClasse.setId(envolvidosObj.optInt("id"));
			envolvidosClasse.setNome(envolvidosObj.optString("nome"));
			envolvidosClasse.setObjeto_type(envolvidosObj.optString("objeto_type"));
			envolvidosClasse.setPivot_tipo(envolvidosObj.optString("pivot_tipo"));
			envolvidosClasse.setPivot_outros(envolvidosObj.optString("pivot_outros"));
			envolvidosClasse.setPivot_extra_nome(envolvidosObj.optString("pivot_extra_nome"));
			envolvidosClasse.setLink(envolvidosObj.optString("link"));
			envolvidosClasse.setLink_api(envolvidosObj.optString("link_api"));
			envolvidosClasse.setNome_sem_filtro(envolvidosObj.optString("nome_sem_filtro"));
			envolvidosClasse.setEnvolvido_tipo(envolvidosObj.optString("envolvido_tipo"));						
			envolvido.add(envolvidosClasse);
		}
		processo.setEnvolvido(envolvido);
		processo.setLink(json.optString("link"));
		processo.setLink_api(json.optString("link_api"));
		processo.setData_formatada(json.optString("data_formatada"));
		JSONObject processoIntObj = new JSONObject();
		processoIntObj = json.getJSONObject("processo");
		ProcessosInt processoInterno = new ProcessosInt();
		processoInterno.setId(processoIntObj.optInt("id"));
		processoInterno.setNumero_antigo(processoIntObj.optString("numero_antigo"));
		processoInterno.setNumero_novo(processoIntObj.optString("numero_novo"));
		processoInterno.setLink(processoIntObj.optString("link"));
		processoInterno.setLink_api(processoIntObj.optString("link_api"));
		processoInterno.setData_movimentacoes(processoIntObj.optString("data_movimentacoes"));
		JSONObject urlObj = new JSONObject();
		urlObj = processoIntObj.getJSONObject("url");
		processoInterno.setSlug(urlObj.optString("slug"));
		processoInterno.setObjeto_type(urlObj.optString("objeto_type"));
		processoInterno.setObjeto_id(urlObj.optInt("objeto_id"));		
		return processo;
	}
	public static void main (String [] args) throws FileNotFoundException, IOException, ParseException
	{
		EscavadorJSON json = new EscavadorJSON();
		JSONParser parser = new JSONParser();
	//	Object obj = parser.parse(new FileReader("/Users/user/Desktop/stringJSON.txt"));
		
		MonitoramentoDiario diario = new MonitoramentoDiario();
		try {
		//	diario.monitoramentoDiario(new ReceberToken().getToken("morg.guilherme@gmail.com", "AnnaBeth10"));
			// sem crédito na API
			diario.monitoramentoDiario(new ReceberToken().getToken("morgado@knivet.com.br", "AnnaBeth10"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro");
		}
	//	Processo processo = json.tratarJSON(obj.toString());
	}
}
