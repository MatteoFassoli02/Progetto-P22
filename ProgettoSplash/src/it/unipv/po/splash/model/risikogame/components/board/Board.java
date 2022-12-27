package it.unipv.po.splash.model.risikogame.components.board;

import java.util.ArrayList;

public class Board {
	private ArrayList<Continent> continents;
	private String name;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Territory> getAllTerritory(){
		ArrayList<Territory> result = new ArrayList<Territory>();
		for(Continent c: getContinents()) {
			for (Territory t: c.getTerritories()) {
				result.add(t);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Board [continents=" + continents + ", name=" + name + "]";
	}
	
	


}
