package digestoData1;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataDigesto1 {
	public ArrayList<Data1> data(JSONArray dataArray)
	{
		ArrayList<Data1> data = new ArrayList<Data1>();
		for(int i=0;i<dataArray.length();i++)
		{
			JSONArray dataObj = dataArray.getJSONArray(i);
			Data1 dataClasse = new Data1();			
			if(!dataObj.isNull(0)) dataClasse.setData((String) dataObj.get(0));			
			if(!dataObj.isNull(1)) dataClasse.setTipo((String) dataObj.get(1));
			if(!dataObj.isNull(2)) dataClasse.setTexto((String) dataObj.get(2));
			if(!dataObj.isNull(3)) dataClasse.setNomeJuiz((String) dataObj.get(3));
			if(!dataObj.isNull(4)) dataClasse.setId((String) dataObj.get(4));
			if(!dataObj.isNull(5)) dataClasse.setTipoInteligente((String) dataObj.get(5));
			if(!dataObj.isNull(6)) dataClasse.setSubtipoInteligente((String) dataObj.get(6));
			data.add(dataClasse);
		}
		return data;
	}
}
