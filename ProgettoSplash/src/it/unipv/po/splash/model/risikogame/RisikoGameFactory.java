package it.unipv.po.splash.model.risikogame;

import java.util.ArrayList;
;
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
