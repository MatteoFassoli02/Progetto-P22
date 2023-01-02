package it.unipv.po.splash.model.risikogame.target.factory;

import java.io.FileInputStream;
import java.util.Properties;


public class TargetInGameFactory {
	private static ITargetInGameFactory targets;
	
	private static String TARGETS_PROPERTYNAME = "target.generate.method";
	
	public static ITargetInGameFactory getTargetInGameFactory() {
		String categoryClassName;

		if (targets == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(TARGETS_PROPERTYNAME);
				
				targets = (ITargetInGameFactory) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return targets;
	}
}
