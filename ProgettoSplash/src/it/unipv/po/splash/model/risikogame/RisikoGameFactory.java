package it.unipv.po.splash.model.risikogame;

import java.awt.Color;
import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.components.ComponentsFacade;
import it.unipv.po.splash.model.risikogame.components.board.Board;
import it.unipv.po.splash.model.risikogame.components.deck.Deck;

public class RisikoGameFactory {
	private static RisikoGameFactory instance;
	private ArrayList<Player> p;
	
	private RisikoGameFactory() {
		super();
		p = new ArrayList<Player>();
	}
	
	public static RisikoGameFactory getInstance() {
		if (instance == null) {
			instance = new RisikoGameFactory();
		}
		return instance;
	}
	
	
	
	public void addPlayer(Player p) {
		this.p.add(p);
	}
	
	public void removePlayer(Player p) {
		this.p.remove(p);
	}
	

	
}
