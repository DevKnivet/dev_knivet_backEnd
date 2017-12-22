package digestoData2;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
public class DataDigesto2 {
	public ArrayList<Data2> data(JSONArray dataArray)
	{
		ArrayList<Data2> data = new ArrayList<Data2>();
		for(int i=0;i<dataArray.length();i++)
		{		
			JSONObject dataObj = new JSONObject();
			dataObj = dataArray.getJSONObject(i);
			Data2 dataClasse = new Data2();
			dataClasse.setUser_company_id(dataObj.optInt("user_company_id"));
			dataClasse.setCustom_type(dataObj.optInt("costom_type"));
			dataClasse.setProcesso_id(dataObj.optInt("processo_id"));
			dataClasse.setTexto(dataObj.optString("texto"));
			dataClasse.setPublished_at(dataObj.optString("published_at"));
			dataClasse.setPartes(dataObj.optString("partes"));
			dataClasse.setMonitored_source_id(dataObj.optInt("monitored_source_id"));
			dataClasse.setProc_alt(dataObj.optString("proc_alt"));
			dataClasse.setId(dataObj.optInt("id"));
			dataClasse.setPriority(dataObj.optInt("priority"));
			dataClasse.setMonitored_source_type(dataObj.optInt("monitored_source_type"));
			dataClasse.setDetected_at(dataObj.optString("detected_at"));
			dataClasse.setProc_apens(dataObj.optString("proc_apens"));
			dataClasse.setSnippet(dataObj.optString("snippet"));
			dataClasse.setProc(dataObj.optString("proc"));
			dataClasse.setAvailable_at(dataObj.optString("available_at"));
			dataClasse.setRecorte_id(dataObj.optInt("recorte_id"));
			dataClasse.setRead_at(dataObj.optString("read_at"));
			dataClasse.setAssunto(dataObj.optString("assunto"));
			dataClasse.setSecao_diario(dataObj.optString("secao_diario"));
			dataClasse.setAssunto_norm_1(dataObj.optInt("assunto_norm_1"));
			dataClasse.setAssunto_norm_2(dataObj.optInt("assunto_norm_2"));
			dataClasse.setNum_pag_original(dataObj.optInt("num_pag_original"));
			dataClasse.setAdvs(dataObj.optString("advs"));
			dataClasse.setUser_read_id(dataObj.optInt("user_read_id"));
			dataClasse.setDocurl(dataObj.optString("docurl"));
			dataClasse.setSource_id(dataObj.optInt("source_id"));
			dataClasse.setCached_docurl(dataObj.optString("cached_docurl"));
			dataClasse.setDoc_id(dataObj.optInt("doc_id"));
			data.add(dataClasse);
		}
		return data;		
	}
}
