package it.unipv.po.splash.model.risikogame.move.placement.strategy.factory;

import java.io.FileInputStream;
import java.util.Properties;

import it.unipv.po.splash.model.risikogame.move.attack.factory.IAttackStategyFactory;

public class ReinforceStrategyFactory {
	private static IReinforceStrategyFactory reinforceStrategy;

	private static final String REINFORCE_PROPERTYNAME = "reinforce.strategy";

	public static IReinforceStrategyFactory getReinforceStrategy() {
		String categoryClassName;
		
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(REINFORCE_PROPERTYNAME);

				reinforceStrategy = (IReinforceStrategyFactory) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return reinforceStrategy;	
		}
}
