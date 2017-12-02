package digesto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.steadystate.css.parser.ParseException;

public class InputDadosTxt {
	
	public static void main(String[] args) throws IOException
	{
		
	}
	
	public JSONObject inputDigesto (String input) throws org.json.simple.parser.ParseException
	{
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(input);		
		return json;
	}
	
	public static ArrayList<String> getJson(String numPro){
		ArrayList<String> saidafinal = new ArrayList<String>();		
			String filePath = "";						
			 try {
				             // read the json file
				             FileReader reader = new FileReader(filePath);
				  
				             JSONParser jsonParser = new JSONParser();
				             JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
				             
      
//				              get a String from the JSON object
//				             String firstName = (String) jsonObject.get("area");
//				             
//				             System.out.println("Area: " + firstName);
				             JSONArray audiencias = (JSONArray) jsonObject.get("audiencias");
				             ArrayList<String> audOut = new ArrayList<String>();
				             for(int i=0; i<audiencias.size();i++)
				             {
				            	 String aux = audiencias.get(i).toString();
				            	 String[] auxA = aux.split(",");
				            	 for(int j=0;j<auxA.length;j++)
				            	 {			            		 
				            		 auxA[j] = auxA[j].replace("[", "");
				            		 auxA[j] = auxA[j].replace("]", "");
				            		 auxA[j] = auxA[j].replace(",", "");
				            		 auxA[j] = auxA[j].replace("\"", "");
				            		 audOut.add(auxA[j]);
				            	 }
				            	 
				            	 
				             }
				             String datAud = audOut.get(0);
				             String vara = audOut.get(1);
				             String tipoAud = "Audiência "+audOut.get(2);
				             datAud = "05-02-2018";
				             String num = (String) jsonObject.get("numero");
				             
				             JSONArray partes = (JSONArray) jsonObject.get("partes");
				             ArrayList<String> partesOut = new ArrayList<String>();
				             ArrayList<String> partesOF = new ArrayList<String>();
				             ArrayList<ArrayList> parte = new ArrayList<>();
				             for(int i=0; i<partes.size();i++)
				             {
				            	 String aux = partes.get(i).toString();
				            	 String[] auxA = aux.split(",");
				            	 for(int j=0;j<auxA.length;j++)
				            	 {			            		 
				            		 auxA[j] = auxA[j].replace("[", "");
				            		 auxA[j] = auxA[j].replace("]", "");
				            		 auxA[j] = auxA[j].replace(",", "");
				            		 auxA[j] = auxA[j].replace("\"", "");
				            		 partesOut.add(auxA[j]);	
				            	 }	
				            	 parte.add(partesOut);
				            	 partesOut = new ArrayList<String>();
				             }
				             ArrayList aux = new ArrayList();
				             ArrayList output = new ArrayList();
				             for(int i=0;i<parte.size();i++)
				             {
				            	 aux = parte.get(i);
				            	 output.add(parte.get(i).get(2)+"("+parte.get(i).get(8)+") CNPJ/CPF "+parte.get(i).get(6)+" ADVG: "+parte.get(i).get(10)+" UF("+parte.get(i).get(13)+")\n");
				            	 //aux.add(partesOut.get(2)+"("+partesOut.get(8)+") CNPJ/CPF "+partesOut.get(6)+" ADVG: "+partesOut.get(10)+" UF("+partesOut.get(13)+")");
				             }
				             ArrayList<String> aux2 = new ArrayList<String>();
				             ArrayList<String> outT = new ArrayList<String>();
				             for(int i=0;i<output.size();i++)
				             {
				            	 aux2.add((String) output.get(i)); 
				            	 String repl = aux2.get(i).replaceAll("false", "");
				            	 repl = aux2.get(i).replaceAll("ADVG: false UF(false)", "");
				            	 repl = aux2.get(i).replaceAll("null", "");
				            	 outT.add(repl);
				            	 
				            	
				             }
				             ArrayList<String> saidaF = new ArrayList<String>();
				             for(int i=0;i<outT.size();i++)
				             {
				            	 String aux3 = outT.get(i).replaceAll("ADVG: false UF(false)", "");
				            	 aux3 = aux3.replaceAll("false", "");
				            	 aux3 = aux3.replaceAll("null", "");
				            	 aux3 = aux3.replaceAll("ADVG:  UF()", "");		
				            	 aux3 = aux3.replaceAll("UF()", "");	
				            	 saidaF.add(aux3);
				             }
				             
				             String titulo = num;
				             String desc = "";
				             desc = tipoAud + " - " + vara + " \n \n";
				             String data = "";
				             data = datAud;
				             for(int i=0;i<saidaF.size();i++)
				             {
				            	 desc = desc + " - " + saidaF.get(i);
				             }
				             
				             desc = desc + " - "  + " \n \n " + " Link do Peticionamento Original em PDF: "+"https://d2aru9ad1z9ipf.cloudfront.net/3d62faa441f7453f9ecb39dfec2f6c37.pdf";
				             
				             data = "02/05/2018";
				             saidafinal.add(titulo);
				             saidafinal.add(data);
				             saidafinal.add(desc);
				             
				             //System.out.println(partesOF);
				             
				             
				             
				             
//				             // get a number from the JSON object
//				             long id =  (long) jsonObject.get("id");
//				             System.out.println("The id is: " + id);
//				  
//				             // get an array from the JSON object
//				             JSONArray lang= (JSONArray) jsonObject.get("languages");
//				              
//				             // take the elements of the json array
//				             for(int i=0; i<lang.size(); i++){
//				                 System.out.println("The " + i + " element of the array: "+lang.get(i));
//				             }
//				             Iterator i = lang.iterator();
//				  
//				             // take each value from the json array separately
//				             while (i.hasNext()) {
//				                 JSONObject innerObj = (JSONObject) i.next();
//				                 System.out.println("language "+ innerObj.get("lang") +
//				                         " with level " + innerObj.get("knowledge"));
//				             }
//				             // handle a structure into the json object
//				             JSONObject structure = (JSONObject) jsonObject.get("job");
//				             System.out.println("Into job structure, name: " + structure.get("name"));
				  
				         } catch (FileNotFoundException ex) {
				             ex.printStackTrace();
				         } catch (IOException ex) {
				             ex.printStackTrace();
				         } catch (NullPointerException ex) {
				             ex.printStackTrace();
				         } catch (org.json.simple.parser.ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
		return saidafinal;
	}
}
