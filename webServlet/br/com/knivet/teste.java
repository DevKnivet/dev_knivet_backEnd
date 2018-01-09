package br.com.knivet;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class teste {

  public static void main(String argv[]) {

	  try {
	         File inputFile = new File("C:/Users/Dezembro/Documents/PubChem/Compound_078175001_078200000.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         System.out.println("Elemento inicial :" + doc.getDocumentElement().getNodeName());
	         NodeList compounds = doc.getElementsByTagName("PC-Compound");
	         System.out.println("----------------------------");	         
	         for(int i=0;i<compounds.getLength();i++)
	         {
	        	 Node compound = compounds.item(i);
		         System.out.println("\nElemento Atual -> " + compound.getNodeName());
		         if (compound.getNodeType() == Node.ELEMENT_NODE) 
		         {		        	 
//		        	 System.out.println("Student roll no : " + eElement.getAttribute("PC-CompoundType_id_cid"));
		        	 
		        	 Element compoundEl = (Element) compound;
		        	 NodeList compoundId_ls = compoundEl.getElementsByTagName("PC-Compound_id");
		        	 Node compound_id = compoundId_ls.item(0);
//		        	 System.out.println(compound_id.getNodeName());
		        	 
		        	 Element compound_idEl = (Element) compound_id;
		        	 NodeList compoundType_ls = compound_idEl.getElementsByTagName("PC-CompoundType");
		        	 Node compoundType = compoundType_ls.item(0);
//		        	 System.out.println(compoundType.getNodeName());
		        	 
		        	 Element compoundType_idEl = (Element) compoundType;
		        	 NodeList compoundType_id_ls = compoundType_idEl.getElementsByTagName("PC-CompoundType_id");
		        	 Node compoundType_id = compoundType_id_ls.item(0);
//		        	 System.out.println(compoundType_id.getNodeName());
		        	 
		        	 Element compoundType_id_cid_El = (Element) compoundType_id;
		        	 NodeList compoundType_id_cid_ls = compoundType_id_cid_El.getElementsByTagName("PC-CompoundType_id_cid");
		        	 Node compoundType_id_cid = compoundType_id_cid_ls.item(0);
//		        	 System.out.println(compoundType_id_cid.getNodeName());
		        	 
		        	 Element cidEl = (Element) compoundType_id_cid;
		        	 NodeList cidLs = cidEl.getChildNodes();
		        	 System.out.println("Cid -> "+cidLs.item(0).getNodeValue());
		        	 
		        	 //PEGAR CID
		        	 Element compoundPropsEl = (Element) compound;
		        	 NodeList compoundProps_ls = compoundPropsEl.getElementsByTagName("PC-Compound_props");		        	 
		        	 Node compoundProps = compoundProps_ls.item(0);
		        	 
		        	 Element compoundPropsArray = (Element) compoundProps;
		        	 NodeList compoundPropsArray_ls = compoundPropsArray.getElementsByTagName("PC-InfoData");
		        	 for(int j=0;j<compoundPropsArray_ls.getLength();j++)
		        	 {
		        		 Node compoundPropsArray_node = compoundPropsArray_ls.item(j);
		        		 
		        		 Element compoundProps_data_urn_el = (Element) compoundPropsArray_node;
		        		 NodeList compoundProps_data_urn_ls = compoundProps_data_urn_el.getElementsByTagName("PC-InfoData_urn");
		        		 Node compoundProps_data_urn = compoundProps_data_urn_ls.item(0);
		        		 System.out.println(compoundProps_data_urn_ls.getLength());
		        		 
		        		 Element compoundProps_urn_el = (Element) compoundProps_data_urn;
		        		 NodeList compoundProps_urn_ls = compoundProps_urn_el.getElementsByTagName("PC-Urn");
		        		 Node compoundProps_urn = compoundProps_urn_ls.item(0);
		        		 
		        		 
		        		 Element compoundProps_urn_label_el = (Element) compoundProps_urn;
		        		 NodeList compoundProps_urn_lbel_ls = compoundProps_urn_label_el.getElementsByTagName("PC-Urn_label");
		        		 System.out.println(compoundProps_urn_label_el.getNodeName());
		        		 Node compoundProps_urn_lbl = compoundProps_urn_lbel_ls.item(0);	
		        		 
		        		 
		        		 
		        		 
		        		 Element urn_labelEl = (Element) compoundProps_urn_lbl;
			        	 NodeList urn_label = urn_labelEl.getChildNodes();
			        	 System.out.println("Urn_label -> "+urn_label.item(0).getNodeValue());
			        	 
			        	 NodeList a = compoundProps_urn_label_el.getElementsByTagName("PC-Urn_name");
			        	 System.out.println(a.getLength());
		        		 Node b = a.item(0);
		        		 Element c = (Element) b;
			        	 NodeList name = c.getChildNodes();
			        	 System.out.println("Urn_label -> "+name.item(0).getNodeValue());
			        	
		        		 
		        		 
		        	 }
		        	 
		         }
	         }
	         
//	         

//	         
//	         for (int temp = 0; temp < nList.getLength(); temp++) {
//	            
//	            
//	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//	               Element eElement = (Element) nNode;
//	               System.out.println("Student roll no : " 
//	                  + eElement.getAttribute("rollno"));
//	               System.out.println("First Name : " 
//	                  + eElement
//	                  .getElementsByTagName("firstname")
//	                  .item(0)
//	                  .getTextContent());
//	               System.out.println("Last Name : " 
//	                  + eElement
//	                  .getElementsByTagName("lastname")
//	                  .item(0)
//	                  .getTextContent());
//	               System.out.println("Nick Name : " 
//	                  + eElement
//	                  .getElementsByTagName("nickname")
//	                  .item(0)
//	                  .getTextContent());
//	               System.out.println("Marks : " 
//	                  + eElement
//	                  .getElementsByTagName("marks")
//	                  .item(0)
//	                  .getTextContent());
//	            }
//	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
}