package it.unipv.po.splash.dao.factory;

import java.io.FileInputStream;
import java.util.Properties;

import it.unipv.po.splash.dao.board.IBoardMapper;
import it.unipv.po.splash.dao.deck.IDeckMapper;

public class MapperFactory {
	private static IDeckMapper deck;
	private static IBoardMapper board;
	
	private static final String DECK_PROPERTYNAME = "deck.class.name";
	private static final String BOARD_PROPERTYNAME = "board.class.name";
	
	public MapperFactory() {
		super();
	}
	
	public static IDeckMapper getDeckMapper() {
		String categoryClassName;

		if (deck == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(DECK_PROPERTYNAME);
				
				deck = (IDeckMapper) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return deck;
	}
	
	public static IBoardMapper getBoardMapper() {
		String categoryClassName;

		if (board == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(BOARD_PROPERTYNAME);
				
				board = (IBoardMapper) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return board;
	}
}
