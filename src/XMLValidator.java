package src;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.transform.stream.StreamSource;

public class XMLValidator {

    public static void main(String[] args) {

        try {
            SchemaFactory factory = SchemaFactory.newInstance(
                    XMLConstants.W3C_XML_SCHEMA_NS_URI
            );

            Schema schema = factory.newSchema(
                  new File("xml/products.xsd")
            );

            Validator validator = schema.newValidator();

            validator.validate(
                    new StreamSource(new File("xml/products.xml"))
            );

            System.out.println("XML is valid against the XSD schema!");

        } catch (Exception e) {
            System.out.println("XML validation failed!");
            System.out.println(e.getMessage());
        }
    }
}

