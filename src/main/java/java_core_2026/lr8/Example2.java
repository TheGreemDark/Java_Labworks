package java_core_2026.lr8;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Example2 {
     public static void main(String[] args) {
        try {
            File inputFile = new File("src/main/java/java_core_2026/lr8/example.xml");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    System.out.println("Текущий элемент: " + node.getNodeName());

                    System.out.println("Название книги: " 
                        + element.getElementsByTagName("title").item(0).getTextContent());

                    System.out.println("Автор: " 
                        + element.getElementsByTagName("author").item(0).getTextContent());

                    System.out.println("Год издания: " 
                        + element.getElementsByTagName("year").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
