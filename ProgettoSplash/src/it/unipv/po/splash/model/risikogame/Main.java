package it.unipv.po.splash.model.risikogame;

import java.awt.Color;

import it.unipv.po.splash.model.risikogame.components.Board;
import it.unipv.po.splash.model.risikogame.components.Continent;
import it.unipv.po.splash.model.risikogame.components.Deck;
import it.unipv.po.splash.model.risikogame.components.Territory;
import it.unipv.po.splash.model.risikogame.components.card.TerritoryCard;
import it.unipv.po.splash.model.risikogame.components.card.figure.EnumFigure;
import it.unipv.po.splash.model.risikogame.components.card.figure.Figure;
import it.unipv.po.splash.model.risikogame.components.card.strategy.BonusCardStrategy;
import it.unipv.po.splash.model.risikogame.components.card.strategy.CompositeCardStrategy;
import it.unipv.po.splash.model.risikogame.components.card.strategy.TerritoryBonusCardStrategy;
import it.unipv.po.splash.model.risikogame.move.Displacement;
import it.unipv.po.splash.model.risikogame.move.attack.Attack;
import it.unipv.po.splash.model.risikogame.move.placement.Placement;
import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.CardReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.CompositeReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.ContinentReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.StartReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.TerritoryReinforceStrategy;

public class Main {
	public static void main(String[] args) {
		Player p1 = new Player("Alberto", new Color(0, 0, 0, 0));
		Player p2 = new Player("Piani", new Color(100, 10, 10, 0));
		Board board = new Board();
		
		Continent sud = new Continent("sud", 7, new Color(0,100,0));
		Continent nord = new Continent("nord", 5, new Color(0,100,0,100));
		
		Territory t1 = new Territory(10, "EmiliaRomagna", 1, 0);
		t1.setOwner(p1);
		p1.addEstate(t1);
		Territory t2 = new Territory(10, "Lombardia", 2, 10);
		Territory t3 = new Territory(1, "Veneto", 3, 20);
		t3.setOwner(p1);
		p1.addEstate(t3);
		Territory t4 = new Territory(1, "Piemonte", 4, 30);
		t4.setOwner(p1);
		p1.addEstate(t4);
		
		nord.addTerritory(t1);
		nord.addTerritory(t2);
		nord.addTerritory(t3);
		nord.addTerritory(t4);
		
		Territory t5 = new Territory(1, "Lazio", 5, 0);
		Territory t6 = new Territory(1, "Sicilia", 6, 10);
		Territory t7 = new Territory(1, "Campania", 7, 20);
		Territory t8 = new Territory(1, "Puglia", 8, 30);
		
		sud.addTerritory(t5);
		sud.addTerritory(t6);
		sud.addTerritory(t7);
		sud.addTerritory(t8);
		
		board.addContinent(nord);
		board.addContinent(sud);

		Figure knight = new Figure(EnumFigure.KNIGHT, 8);
		Figure cannon = new Figure(EnumFigure.CANNON, 6);
		Figure jack = new Figure(EnumFigure.JACK, 4);
		Figure jolly = new Figure(EnumFigure.JOLLY, 0);
		
		TerritoryCard tc1 = new TerritoryCard(t1, knight);
		TerritoryCard tc2 = new TerritoryCard(t2, cannon);
		TerritoryCard tc3 = new TerritoryCard(t3, cannon);
		TerritoryCard tc4 = new TerritoryCard(t4, jolly);
		
		Deck deck = new Deck();
		deck.addCard(tc1);
		deck.addCard(tc2);
		deck.addCard(tc3);
		deck.addCard(tc4);
		System.out.println(deck.toString());
		
		deck.drawCard(p1);
		deck.drawCard(p1);
		deck.drawCard(p1);
		System.out.println(deck.toString());
		System.out.println(p1.toString());
		
		System.out.println(t1.getNumArmies());
		
		CompositeReinforceStrategy cps = new CompositeReinforceStrategy();
			cps.addStrategy(new StartReinforceStrategy()); 
			CompositeCardStrategy ccs =new CompositeCardStrategy();
				ccs.addStrategy(new BonusCardStrategy());
				ccs.addStrategy(new TerritoryBonusCardStrategy(p1));
			CardReinforceStrategy cpbs = new CardReinforceStrategy(ccs);
			cpbs.use(tc4, tc2, tc3); 
			cps.addStrategy(cpbs);
			cps.addStrategy(new TerritoryReinforceStrategy(p1)); 
			cps.addStrategy(new ContinentReinforceStrategy(board, p1));
		Reinforcement place = new Reinforcement(cps);
		System.out.println("inizio: " + place.getReinforcements());
		place.calcolateReinforcements();
		System.out.println("fine: " + place.getReinforcements());
		System.out.println(t1.getNumArmies());
		Placement pl = new Placement(3);
		pl.changeTerritory(t1);
		System.out.println("attacco prima: " + t1.getNumArmies());
		
		Attack name = new Attack(3,3);
		name.changeTerritory(t1, t2);
		System.out.println("attacco: " + t1.getNumArmies());
		System.out.println("difesa: " + t2.getNumArmies());
		
		Displacement jjj = new Displacement(5);
		jjj.changeTerritory(t1, t3);
		System.out.println("start: " + t1.getNumArmies());
		System.out.println("end: " + t3.getNumArmies());
	}
}
