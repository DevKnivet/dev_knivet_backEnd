package escavadorProcesso;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import digesto.Digesto;
import digestoInput.DigestoJSON;

public class EscavadorJSON {
	public Processo tratarJSON(String input)
	{
		Processo processo = new Processo();
		JSONObject json = new JSONObject(input);
		System.out.println(json.getString("id"));
		return null;
	}
	public static void main (String[] args) throws FileNotFoundException, IOException, ParseException
	{
		EscavadorJSON json = new EscavadorJSON();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/Users/user/Desktop/stringJSON.txt"));
		Processo processo = json.tratarJSON(obj.toString());
	}
}
