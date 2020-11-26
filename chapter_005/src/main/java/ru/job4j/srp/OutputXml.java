package ru.job4j.srp;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class OutputXml implements Output{

    public final Document document;

    public OutputXml(Document document) {
        this.document = document;
    }

    public void write(String fileName) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(this.document);
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            StreamResult streamResult = new StreamResult(fileOutputStream);
            transformer.transform(domSource, streamResult);
        } catch (FileNotFoundException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
