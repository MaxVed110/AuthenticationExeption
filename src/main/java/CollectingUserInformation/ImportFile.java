package CollectingUserInformation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class ImportFile {
    public ImportFile() {

    }

    public Document xmlWrite(User user) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("User");
            doc.appendChild(rootElement);

            Element info = doc.createElement("user");
            info.setTextContent(user.toString());
            rootElement.appendChild(info);
            return doc;
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Ошибка парсинга", e);
        }
    }

    public void createXml(User user, Document document) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "Windows-1251");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(user.getFirstName() + ".xml"));

            transformer.transform(source, result);

        } catch (TransformerConfigurationException e) {
            throw new RuntimeException("Ошибка конфигурации", e);
        } catch (TransformerException e) {
            throw new RuntimeException("Системная ошибка", e);
        }
    }

    public Document addInXml(User user, String nameFile) {
        DocumentBuilderFactory newDocumentBuilderF = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder newDocumentBuilder = newDocumentBuilderF.newDocumentBuilder();
            Document newDocument = newDocumentBuilder.parse(nameFile);
            Element root = newDocument.getDocumentElement();

            Element info = newDocument.createElement("user");
            info.setTextContent(user.toString());
            root.appendChild(info);

            return newDocument;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("Ошибка парсинга", e);
        }
    }
}
