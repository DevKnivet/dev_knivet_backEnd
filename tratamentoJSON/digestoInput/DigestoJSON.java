package digestoInput;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import digesto.Digesto;
import digestoData1.Data1;
import digestoData1.DataDigesto1;
import digestoData2.Data2;
import digestoData2.DataDigesto2;
import digestoData4.Advogado;
import digestoData4.Data4;
import digestoData4.DataDigesto4;
import digestoData4.Parte;

public class DigestoJSON {
	public Digesto tratarJSON(String input)
	{
		Digesto digesto = new Digesto();
		JSONArray json = new JSONArray(input);
		for(int i=0;i<json.length();i++)
		{
			JSONObject jsonObj = json.getJSONObject(i);
			digesto.setId(jsonObj.optInt("id"));
			digesto.setEvt_type(jsonObj.optInt("evt_type"));
			digesto.setCreated_at(jsonObj.optString("created_at"));
			digesto.setTarget_url(jsonObj.optString("target_url"));
			digesto.setTarget_number(jsonObj.optString("target_number"));			
			JSONArray source_urlArray = jsonObj.getJSONArray("source_url");
			ArrayList<String> source_url = new ArrayList<String>();
			for(int j=0;j<source_urlArray.length();j++)
			{				
				source_url.add((String) source_urlArray.get(j));
			}
			digesto.setSource_url(source_url);
			digesto.setSource_user_custom(jsonObj.optString("source_user_custom"));
			digesto.setApi_name(jsonObj.optString("api_name"));			
			if(digesto.getEvt_type()==1)
			{
				JSONArray dataArray = jsonObj.getJSONArray("data");
				DataDigesto1 data = new DataDigesto1();
				digesto.setData(data.data(dataArray));
			}
			if(digesto.getEvt_type()==2)
			{
				JSONArray dataArray = jsonObj.getJSONArray("data");
				DataDigesto2 data = new DataDigesto2();
				digesto.setData(data.data(dataArray));
			}
			if(digesto.getEvt_type()==4)
			{
				JSONArray dataArray = jsonObj.getJSONArray("data");
				DataDigesto4 data = new DataDigesto4();
				digesto.setData(data.data(dataArray));
			}
		}
		return digesto;
	}
	public static void main (String[] args) throws FileNotFoundException, IOException, ParseException
	{
		DigestoJSON json = new DigestoJSON();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/Users/Dezembro/Desktop/JSON4.txt"));
		Digesto digesto = json.tratarJSON(obj.toString());
	}
}