package it.unipv.po.splash.model.risikogame.components.board.factory;

import java.io.FileInputStream;
import java.util.Properties;

public class BoardFactory {
	private static IBoardFactory board;
	
	private static String BOARD_PROPERTYNAME = "board.generate.method";
	
	public static IBoardFactory getBoardFactory() {
		String categoryClassName;

		if (board == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(BOARD_PROPERTYNAME);
				
				board = (IBoardFactory) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return board;
	}
}
