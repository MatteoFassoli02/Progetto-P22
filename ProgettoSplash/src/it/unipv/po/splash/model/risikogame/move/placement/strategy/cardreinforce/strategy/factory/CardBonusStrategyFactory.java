package it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.strategy.factory;

import java.io.FileInputStream;
import java.util.Properties;


public class CardBonusStrategyFactory {
	private static ICardBonusFactory cardBonus;
	
	private static final String CARDBONUS_PROPERTYNAME = "card.bonus.strategy";
	
	public static ICardBonusFactory getCardBonusStrategy() {
		String categoryClassName;

		if (cardBonus == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(CARDBONUS_PROPERTYNAME);
				
				cardBonus = (ICardBonusFactory) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return cardBonus;
		}
		return null;
	}
}
