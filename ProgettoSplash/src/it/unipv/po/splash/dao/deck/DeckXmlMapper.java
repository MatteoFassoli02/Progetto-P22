package it.unipv.po.splash.dao.deck;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.unipv.po.splash.dao.IXmlMapper;
import it.unipv.po.splash.model.risikogame.components.deck.card.Figure;

public class DeckXmlMapper implements IDeckMapper, IXmlMapper{
	private File file;
	private Document doc;
	
	private final static String PATH_PROPERTYNAME = "deck.path";
	
	public DeckXmlMapper() throws Exception {
		super();
		initializeDoc();
	}
	
	public int getBonus(String figure) {
		try {
			NodeList cList = doc.getElementsByTagName(figure);
			for (int i = 0; i < cList.getLength(); i++) {
				Node cNode = cList.item(i);
				if (cNode.getNodeType() == Node.ELEMENT_NODE) {
					Element cElement = (Element) cNode;
					return Integer.parseInt(cElement.getAttribute("bonus"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return -1;
	}
	
	@Override
	public Hashtable<String, Figure> getCards() {
		Hashtable<String, Figure> result = new Hashtable<String, Figure>();
		try {
			NodeList cList = doc.getElementsByTagName("card");
			for (int i = 0; i < cList.getLength(); i++) {
				Node cNode = cList.item(i);
				if (cNode.getNodeType() == Node.ELEMENT_NODE) {
					Element cElement = (Element) cNode;
					if(cElement.getTextContent() != "") {
						result.put(
								cElement.getTextContent(), 
								new Figure(cElement.getAttribute("figure"), getBonus(cElement.getAttribute("figure")))
								);
					} 
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int getNumJolly() {
		int result = 0;
		try {
			NodeList cList = doc.getElementsByTagName("card");
			for (int i = 0; i < cList.getLength(); i++) {
				Node cNode = cList.item(i);
				if (cNode.getNodeType() == Node.ELEMENT_NODE) {
					Element cElement = (Element) cNode;
					if(cElement.getAttribute("figure").equalsIgnoreCase("jolly")) {
						result++;
					} 
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public void initializeDoc() throws Exception {
		String path;
		
		Properties p = new Properties(System.getProperties());
		p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
		path = p.getProperty(PATH_PROPERTYNAME);
		System.out.println(path);
		
		file = new File(path);
		if (!file.exists())
			throw new Exception("non trovato"+ path); 

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.parse(file);
		doc.getDocumentElement().normalize();
	}

	@Override
	public ArrayList<Figure> getFigures() {
		ArrayList<Figure> result = new ArrayList<Figure>();
		return result;
	}
	
}
