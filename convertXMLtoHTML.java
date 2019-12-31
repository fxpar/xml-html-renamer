



package MyPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
public class DomParserExample {
 
     public static void main(String[] args) throws ParserConfigurationException,
          SAXException, IOException {
 
    	//Get Document Builder
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
          DocumentBuilder builder = factory.newDocumentBuilder();
 
          // Load the input XML document, parse it and return an instance of the
          // Document class.
          Document document = builder.parse(new File("Romeo_and_Juliet.xml"));
 
          //List<Employee> employees = new ArrayList<Employee>();
          NodeList nodeList = document.getDocumentElement().getElementsByTagName("*");
          for (int i = 0; i < nodeList.getLength(); i++) {
               Node node = nodeList.item(i);
 
               if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
						
						System.out.println(elem.getTagName());
						elem.setAttribute("class", elem.getTagName());
						
						if (elem.getElementsByTagName("*").getLength() > 0) {
							document.renameNode(elem, null, "div");
						}else{
							document.renameNode(elem, null, "p");
						}
						System.out.println(elem.toString());
						
						
						// output DOM XML to console 
						 try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 

            //DOMSource source = new DOMSource(document);
            //StreamResult console = new StreamResult(System.out);
            //transformer.transform(source, console);
			
			 //Write XML to file
			FileOutputStream outStream = new FileOutputStream(new File("result.xml")); 
			
			transformer.transform(new DOMSource(document), new StreamResult(outStream));
			
			 } 
    catch (TransformerException e) 
    {
        e.printStackTrace();
    }
    catch (Exception e) 
    {
        e.printStackTrace();
    }
			
			
/*			
File thatFile = new File("C:/Users/fxp33/Documents/PortableApps/UwAmp/www/testJava/result.xml");
    if (thatFile.exists()) {
        FileOutputStream f = new FileOutputStream(thatFile);
        ObjectOutputStream fOUT = new ObjectOutputStream(f);
        fOUT.writeObject(document);  
            f.close();
    }
*/

			
                    /*
					// Get the value of the ID attribute.
                    String ID = node.getAttributes().getNamedItem("ID").getNodeValue();
 
                    // Get the value of all sub-elements.
                    String firstname = elem.getElementsByTagName("Firstname")
                                        .item(0).getChildNodes().item(0).getNodeValue();
 
                    String lastname = elem.getElementsByTagName("Lastname").item(0)
                                        .getChildNodes().item(0).getNodeValue();
 
                    Integer age = Integer.parseInt(elem.getElementsByTagName("Age")
                                        .item(0).getChildNodes().item(0).getNodeValue());
 
                    Double salary = Double.parseDouble(elem.getElementsByTagName("Salary")
                                        .item(0).getChildNodes().item(0).getNodeValue());
 
                    employees.add(new Employee(ID, firstname, lastname, age, salary));
					*/
               }
          }
 
          // Print all employees.
          //for (Employee empl: employees)
           //    System.out.println(empl.toString());
     }
}