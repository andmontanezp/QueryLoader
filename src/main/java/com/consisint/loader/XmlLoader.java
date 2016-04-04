package com.consisint.loader;

import com.consisint.loader.Loader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathExpression;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by ANDERSON on 03/04/2016.
 */
public class XmlLoader implements Loader {
    @Override
    public String load(String queryName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File inputFile = new File("queries.xml");
            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();

            NodeList queries = document.getElementsByTagName("query");
            for (int i = 0; i < queries.getLength(); i++) {
                String rootNode =  document.getDocumentElement().getNodeName();
                NodeList queryList = document.getElementsByTagName(rootNode);
                Node result = getElementById(((Element) queryList.item(i)).getElementsByTagName("queries").item(0), queryName);

                if(result != null) {
                    return result.getFirstChild().getNodeValue().trim();
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    private Element getElementById(Node node, String queryName) {
        XPathFactory factor = XPathFactory.newInstance();
        XPath xpath = factor.newXPath();
        javax.xml.xpath.XPathExpression expr = null;
        try {
            expr = xpath.compile("//*[@id = '" + queryName + "']");
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        Element result = null;
        try {
            result = (Element) expr.evaluate(node, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return result;
    }
}
