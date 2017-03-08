package swComunicacion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

public class TratarXML {
	
	private static HashMap<Integer,ArrayList<String>> results;
	private static ArrayList<String> lista;
	
	public static HashMap<Integer,ArrayList<String>> cargarXml()
	{
	    //Se crea un SAXBuilder para poder parsear el archivo
	    results = new HashMap<Integer,ArrayList<String>>();
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File( "tv.xml" );
	    try
	    {
	    	if(xmlFile.exists()){
	    		
	        //Se crea el documento a traves del archivo
	        Document document = (Document) builder.build( xmlFile );
	 
	        //Se obtiene la raiz 'peliculas'
	        Element rootNode = document.getRootElement();
	 
	        //Se obtiene la lista de hijos de la raiz 'peliculas'
	        List<Element> list = rootNode.getChildren( "peli" );
	
	        //Se recorre la lista de hijos de 'tables'
	        for ( int i = 0; i < list.size(); i++ )
	        {
	            //Se obtiene el elemento 'tabla'
	            Element peli = (Element) list.get(i);
//				Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
//	            String nombreTabla = tabla.getAttributeValue("id");
//	            System.out.println( "Tabla: " + nombreTabla );
	           
	            lista = new ArrayList<String>();
	            
	            lista.add(peli.getChildTextTrim("titulo"));
                
                lista.add(peli.getChildTextTrim("imagen"));
 
                results.put(i, lista);
                //System.out.println( "\t"+titulo+"\t\t"+director+"\t\t"+genero);
	        }
	    	} else {
	    		XMLOutputter xmlOutput = new XMLOutputter();
	    		Document doc = new Document();
				// display nice nice
	    		Element rootNode = new Element("peliculas");
	    		doc.setRootElement(rootNode);
				xmlOutput.setFormat(Format.getPrettyFormat());
				xmlOutput.output(doc, new FileWriter("tv.xml"));
	    	}
	    }catch ( IOException io ) {
	        System.out.println( io.getMessage() );
	    }catch ( JDOMException jdomex ) {
	        System.out.println( jdomex.getMessage() );
	    }
	    return results;
	}
	
	public static boolean escribirXML(String args[]){
		//Si no se hace esto del principio y se crea directamente el elemento, el archivo .xml anterior no se 
		//mantiene y solo se guardaría esto último que estamos metiendolo.
			  try {
				  SAXBuilder builder = new SAXBuilder();
				    File xmlFile = new File( "tv.xml" );
				
				    try
				    {
				        Document document = (Document) builder.build( xmlFile );
				        Element rootNode = document.getRootElement();
				        rootNode.detach(); //Hay que hacer esto para desechar la relación.
				    
				Document doc = new Document();
				doc.setRootElement(rootNode);
		 
				Element peli = new Element("peli");
				peli.addContent(new Element("titulo").setText(args[0]));
				peli.addContent(new Element("imagen").setText(args[1]));
				doc.getRootElement().addContent(peli);
		 
				// new XMLOutputter().output(doc, System.out);
				XMLOutputter xmlOutput = new XMLOutputter();
		 
				// display nice nice
				xmlOutput.setFormat(Format.getPrettyFormat());
				xmlOutput.output(doc, new FileWriter("tv.xml"));
				
				return true;
				
				}catch( JDOMException jdomex ) {
			        System.out.println( jdomex.getMessage() );
			        return false;
			    }
			  } catch (IOException io) {
				System.out.println(io.getMessage());
					return false;
			  }
	}
}
