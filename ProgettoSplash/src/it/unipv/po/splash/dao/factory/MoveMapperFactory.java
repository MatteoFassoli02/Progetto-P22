package it.unipv.po.splash.dao.factory;

import java.io.FileInputStream;
import java.util.Properties;

import it.unipv.po.splash.dao.move.IArmiesMapper;
import it.unipv.po.splash.dao.move.IMoveMapper;
import it.unipv.po.splash.dao.move.IChoiceMapper;

public class MoveMapperFactory {
	private static IMoveMapper move;
	private static IArmiesMapper armies;
	private static IChoiceMapper repeat;

	
	private static final String MOVE_PROPERTYNAME = "move.factory.class";
	private static final String ARMIES_PROPERTYNAME = "armies.factory.class";
	private static final String CHOICE_PROPERTYNAME = "choice.factory.class";
	
	public static IArmiesMapper getArmiesMapper() {
		String categoryClassName;

		if (armies == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(ARMIES_PROPERTYNAME);
				
				armies = (IArmiesMapper) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return armies;
	}
	
	public static IMoveMapper getMoveMapper() {
		String categoryClassName;

		if (move == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(MOVE_PROPERTYNAME);
				
				move = (IMoveMapper) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return move;
	}
	
	public static IChoiceMapper getChoice() {
		String categoryClassName;

		if (repeat == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(CHOICE_PROPERTYNAME);
				
				repeat = (IChoiceMapper) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return repeat;
	}
}
