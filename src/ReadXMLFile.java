import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;

public class ReadXMLFile {
    private LinkedList<String> cities = new LinkedList<>();

    public LinkedList<String> getCities() {
        return cities;
    }

    public ReadXMLFile(){

        try {

            File fXmlFile = new File("C:\\Users\\trzew\\Desktop\\SIMC.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("row");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                Element eElement = (Element) nNode;
                cities.add(eElement.getElementsByTagName("NAZWA").item(1).getTextContent());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
