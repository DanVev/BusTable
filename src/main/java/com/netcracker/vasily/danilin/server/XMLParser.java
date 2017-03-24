package com.netcracker.vasily.danilin.server;

import com.google.gwt.user.client.Window;
import com.netcracker.vasily.danilin.shared.TableRow;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vasily Danilin on 22.03.2017.
 */
public class XMLParser {
    public XMLParser() {
    }

    public static List<TableRow> getData() {
        List<TableRow> result = new ArrayList<>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String path = XMLParser.class.getResource("timetable.xml").getFile();
            File file = new File(path.replaceAll("%20", " "));
            Document document = documentBuilder.parse(file);
            Node root = document.getDocumentElement();
            Node node = root.getFirstChild();

            if (node == null) return result;
            do {
                if (node.getNodeName().equals("route")) {
                    TableRow resultItem = new TableRow();

                    NamedNodeMap map = node.getAttributes();
                    resultItem.setRoute((map.getNamedItem("number")).getNodeValue());
                    resultItem.setStart((map.getNamedItem("start")).getNodeValue());
                    resultItem.setDestination((map.getNamedItem("destination")).getNodeValue());
                    resultItem.setTime((map.getNamedItem("time")).getNodeValue());
                    result.add(resultItem);
                    System.out.println(resultItem.toString());
                }
                node = node.getNextSibling();
            } while (node != null);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
