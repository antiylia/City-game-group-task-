package by.htp.citygame.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class InputCities {	
	
	// TODO: Юля READY
	/**
	 * Method, which provides reading data (Cities' names) from file
	 * and returns list with cities, which begin with different letters
	 * 
	 * from XML
	 */
	
	public List<String> readCities() {
		List <String> listAllCities = new ArrayList<String>();
		  String letterKey = "";
		    try {        	
				DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = documentBuilder.parse("resources\\Cities.xml");
				
	            Node root = document.getDocumentElement();                            
	            NodeList letters = root.getChildNodes(); // Letters
	                                            
	            for (int i = 0; i < letters.getLength(); i++) {
	                Node letter = letters.item(i);
	                letterKey = letter.getNodeName();               
	                                                                  
	               if (letter.getNodeType() != Node.TEXT_NODE) {
	            	  NodeList specifiedCities = letter.getChildNodes();
	            	  
	            	   for(int j = 0; j < specifiedCities.getLength(); j++) {          	   
	            		   NodeList citiesLetter = specifiedCities.item(j).getChildNodes();
	            		     
	            		   for (int q=0; q<citiesLetter.getLength(); q++) { 
	            			   Node city = citiesLetter.item(q);
	            			   String nameCity = city.getTextContent().trim();
	            		       if (!nameCity.isEmpty()) {
	            		          listAllCities.add(nameCity);
	               		       }
	            		     }            	     
	            	      }          	
	                  } 
	            }	            
	                        
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}  catch (SAXException e)  {
				e.printStackTrace();
			} catch (IOException ex) {
	            ex.printStackTrace(System.out);
	        }	
		   return listAllCities;  
		}
	
}
