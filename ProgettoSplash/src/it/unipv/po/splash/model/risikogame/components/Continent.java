package it.unipv.po.splash.model.risikogame.components;

import java.util.ArrayList;
import java.awt.Color;

public class Continent {
	private ArrayList<Territory> territories;
	private Color color;
	private int bonus;
	private String name;

	public Continent(String name, int bonus, Color color) {
		super();
		this.setName(name);
		this.setBonus(bonus);
		territories = new ArrayList<Territory>();
	}

	public boolean addTerritory(Territory t) {
		if (territories.isEmpty()) {
			territories.add(t);
			return true;
		}
		for (Territory s : territories) {
			if (s.isBordering(t)) {
				territories.add(t);
				return true;
			}
		}
		return false;
	}
	
	public boolean isIn(Territory territory) {
		for(Territory t: territories) {
			if (t.getIdTerritory() == territory.getIdTerritory())
				return true;
		}
		return false;
	}

	public void RemoveTerritory(Territory t) {
		territories.remove(t);
	}

	public ArrayList<Territory> getTerritories() {
		return territories;
	}

	public void setTerritories(ArrayList<Territory> territories) {
		this.territories = territories;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
