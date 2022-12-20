package it.unipv.po.splash.model.risikogame.components;

import java.util.ArrayList;

public class Board {
	private ArrayList<Continent> continents;
	
	public Board() {
		super();
		continents = new ArrayList<Continent>();
	}
	
	public void addContinent(Continent c) {
		continents.add(c);
	}
	
	public void removeContinent(Continent c) {
		continents.remove(c);
	}

	public ArrayList<Continent> getContinents() {
		return continents;
	}

	public void setContinents(ArrayList<Continent> continents) {
		this.continents = continents;
	}

}
