package src;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.transform.stream.StreamSource;
public class XMLReader {
  public static void main(String[] args) {
    try {
      
    SchemaFactory schemaFactory = SchemaFactory.newInstance(
        XMLConstants.W3C_XML_SCHEMA_NS_URI
);
Schema schema = schemaFactory.newSchema(
       new File("xml/products.xsd")
);
Validator validator = schema.newValidator();
try {
    validator.validate(
            new StreamSource(new File("xml/products.xml"))
    );

    System.out.println("XML is valid against the XSD schema!");

} catch (SAXException e) {
    System.out.println("XML validation failed!");
    System.out.println(e.getMessage());
    return;
}
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    File file = new File("xml/products.xml");
    Document document = builder.parse(file);
    Element root = document.getDocumentElement();
   NodeList products = root.getElementsByTagName("product");
    for (int i = 0; i < products.getLength(); i++) {
      Element product = (Element) products.item(i);
      String name = product.getElementsByTagName("productName")
                     .item(0).getTextContent();
                     String brand = product.getElementsByTagName("brand")
                      .item(0).getTextContent();
                      String price = product.getElementsByTagName("price")
                      .item(0).getTextContent();
                      Element priceElement = (Element) product.getElementsByTagName("price").item(0);

String currency = priceElement.getAttribute("currency");
                      System.out.println("Product " + (i + 1));
System.out.println("Name: " + name);
System.out.println("Brand: " + brand);
System.out.println("Price: " + price);
System.out.println("Currency: " + currency);
NodeList dimensionsList = product.getElementsByTagName("dimensions");
if (dimensionsList.getLength() > 0) {
    Element dimensions = (Element) dimensionsList.item(0);
    String width = dimensions.getElementsByTagName("width")
                         .item(0).getTextContent();

String height = dimensions.getElementsByTagName("height")
                          .item(0).getTextContent();

String depth = dimensions.getElementsByTagName("depth")
                         .item(0).getTextContent();
                         System.out.println("Width: " + width + " cm");
System.out.println("Height: " + height + " cm");
System.out.println("Depth: " + depth + " cm");
    System.out.println("Dimensions are available.");
  
} else {
    System.out.println("Dimensions not available.");
}
System.out.println();
}
        
    }
  
  catch (ParserConfigurationException | SAXException | IOException e) {
    System.out.println("Error: " + e.getMessage());
}
} 
}
