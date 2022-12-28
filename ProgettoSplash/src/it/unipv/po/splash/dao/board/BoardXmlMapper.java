package it.unipv.po.splash.dao.board;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.Color;

import it.unipv.po.splash.dao.IXmlMapper;
import it.unipv.po.splash.model.risikogame.components.board.Continent;
import it.unipv.po.splash.model.risikogame.components.board.Territory;

public class BoardXmlMapper implements IBoardMapper, IXmlMapper{
	private File file;
	private Document doc;
	
	private static final String PATH_PROPERTYNAME = "board.path";
	
	public BoardXmlMapper() throws Exception {
		super();
		initializeDoc();
	}
	
	
	@Override
	public ArrayList<Continent> getAllContinents(){
		ArrayList<Continent> result = new ArrayList<Continent>();
		String tempName = null;
		int tempBonus = 0;
		Color tempColor = null;
		try {
			NodeList cList = doc.getElementsByTagName("continent");

			for (int i = 0; i < cList.getLength(); i++) {
				Node cNode = cList.item(i);
				if (cNode.getNodeType() == Node.ELEMENT_NODE) {
					Element cElement = (Element) cNode;
					tempName = new String(cElement.getElementsByTagName("name").item(0).getTextContent());
					tempBonus = Integer.parseInt(cElement.getElementsByTagName("bonus").item(0).getTextContent());

					NodeList rgbList = cElement.getElementsByTagName("color");
					for(int j = 0; j < rgbList.getLength(); j++) {
						Node rgbNode = rgbList.item(j);
						if (rgbNode.getNodeType() == Node.ELEMENT_NODE) {
							Element rgbElement = (Element) rgbNode;
							tempColor = new Color(
									Integer.parseInt(rgbElement.getElementsByTagName("r").item(0).getTextContent()),
									Integer.parseInt(rgbElement.getElementsByTagName("g").item(0).getTextContent()),
									Integer.parseInt(rgbElement.getElementsByTagName("b").item(0).getTextContent())
									);
							result.add(new Continent(tempName, tempBonus, tempColor));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		return result;
	}


	@Override
	public ArrayList<Territory> getAllTerritories() {
		ArrayList<Territory> result = new ArrayList<Territory>();
		Territory tempTerr = null;
		try {
			NodeList tList = doc.getElementsByTagName("territory");
			for (int i = 0; i < tList.getLength(); i++) {
				Node tNode = tList.item(i);
				if (tNode.getNodeType() == Node.ELEMENT_NODE) {
					Element tElement = (Element) tNode;
					tempTerr = new Territory(
							0, //Armies
							tElement.getElementsByTagName("name").item(0).getTextContent(), //name
							0, //id
							Integer.parseInt(tElement.getElementsByTagName("score").item(0).getTextContent()) //score
							);
					result.add(tempTerr);
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ArrayList<String> getBordersOf(Territory t) {
		ArrayList<String> result = new ArrayList<String>();
		try {
			NodeList tList = doc.getElementsByTagName("territory");
			for (int i = 0; i < tList.getLength(); i++) {
				Node tNode = tList.item(i);
				if (tNode.getNodeType() == Node.ELEMENT_NODE) {
					Element tElement = (Element) tNode;
					
					if (t.getName().equalsIgnoreCase(tElement.getElementsByTagName("name").item(0).getTextContent())) {
						NodeList bList = tElement.getElementsByTagName("border");
						
						for(int j = 0; j < bList.getLength(); j++) {
							Node bNode = bList.item(j);
							if (bNode.getNodeType() == Node.ELEMENT_NODE) {
								result.add(tElement.getElementsByTagName("border").item(j).getTextContent());
							}
						}
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
	public String getNameBoard() {
		try {
			return doc.getDocumentElement().getAttribute("name");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<String> getTerritoriesOf(Continent c) {
		ArrayList<String> result = new ArrayList<String>();
		try {
			NodeList cList = doc.getElementsByTagName("continent");
			for (int i = 0; i < cList.getLength(); i++) {
				Node cNode = cList.item(i);
				if (cNode.getNodeType() == Node.ELEMENT_NODE) {
					Element cElement = (Element) cNode;
					if(c.getName().equalsIgnoreCase(cElement.getElementsByTagName("name").item(0).getTextContent())) {
						NodeList tList = cElement.getElementsByTagName("territory");
						for(int j = 0; j < tList.getLength(); j++) {
							Node tNode = tList.item(j);
							if (tNode.getNodeType() == Node.ELEMENT_NODE) {
								Element tElement = (Element) tNode;
								result.add(tElement.getElementsByTagName("name").item(0).getTextContent());
							}
						}
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
	public void initializeDoc() throws Exception {
		String path;
		Properties p = new Properties(System.getProperties());
		p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
		path = p.getProperty(PATH_PROPERTYNAME);
		file = new File(path);
		if (!file.exists())
			throw new Exception("non trovato"+ path); 

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		doc = builder.parse(file);
		doc.getDocumentElement().normalize();
	}
}
