package it.unipv.po.splash.model.risikogame.components.deck.factory;

import java.io.FileInputStream;
import java.util.Properties;

public class DeckFactory {
private static IDeckFactory deck;
	
	private static String DECK_PROPERTYNAME="deck.generate.method";
	
	public static IDeckFactory getDeckFactory() {
		String categoryClassName;

		if (deck == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(DECK_PROPERTYNAME);
				
				deck = (IDeckFactory) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return deck;
	}
}
