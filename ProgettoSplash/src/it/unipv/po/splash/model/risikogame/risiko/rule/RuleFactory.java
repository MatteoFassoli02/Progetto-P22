package it.unipv.po.splash.model.risikogame.risiko.rule;

import java.io.FileInputStream;
import java.util.Properties;

import it.unipv.po.splash.model.risikogame.risiko.rule.attack.IRuleAttack;
import it.unipv.po.splash.model.risikogame.risiko.rule.displacement.IRuleDisplacement;
import it.unipv.po.splash.model.risikogame.risiko.rule.placement.IRulePlacements;
import it.unipv.po.splash.model.risikogame.risiko.rule.start.IRuleStart;

public class RuleFactory {
	private static IRuleAttack attack;
	private static IRuleStart start;
	private static IRulePlacements place;
	private static IRuleDisplacement displace;


	private static final String DIS_PROPERTYNAME = "displacement.rule.factory.class";
	private static final String PLACE_PROPERTYNAME = "placement.rule.factory.class";
	private static final String START_PROPERTYNAME = "start.rule.factory.class";
	private static final String ATTACK_PROPERTYNAME = "attack.rule.factory.class";
	
	public RuleFactory() {
		super();
	}
	
	public static IRuleDisplacement getRuleDisplacement() {
		String categoryClassName;

		if (displace == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(DIS_PROPERTYNAME);
				
				displace = (IRuleDisplacement) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return displace;
	}
	
	public static IRulePlacements getRulePlacement() {
		String categoryClassName;

		if (place == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(PLACE_PROPERTYNAME);
				
				place = (IRulePlacements) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return place;
	}
	
	public static IRuleStart getRuleStart() {
		String categoryClassName;

		if (start == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(START_PROPERTYNAME);
				
				start = (IRuleStart) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return start;
	}
	
	public static IRuleAttack getRuleAttack() {
		String categoryClassName;

		if (attack == null) {
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				categoryClassName = p.getProperty(ATTACK_PROPERTYNAME);
				
				attack = (IRuleAttack) Class.forName(categoryClassName).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return attack;
	}
}
