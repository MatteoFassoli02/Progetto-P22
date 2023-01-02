package it.unipv.po.splash.model.risikogame.move.attack.factory;

import java.io.FileInputStream;
import java.util.Properties;

public class AttackStrategyFactory {
	private static IAttackStategyFactory attackStrategy;
	
	private static final String ATTACKS_PROPERTYNAME = "attack.strategy";
	
	public static IAttackStategyFactory getAttackStrategy() {
		String categoryClassName;

		if (attackStrategy == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(ATTACKS_PROPERTYNAME);
				
				attackStrategy = (IAttackStategyFactory) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return attackStrategy;
	}
}
