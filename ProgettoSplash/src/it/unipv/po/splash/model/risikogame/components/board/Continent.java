package it.unipv.po.splash.model.risikogame.components.board;

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
		this.setColor(color);
		territories = new ArrayList<Territory>();
	}
	
	public void addTerritory(Territory t) {
		territories.add(t);
	}
	
	public void RemoveTerritory(Territory t) {
		territories.remove(t);
	}
	
	public boolean isIn(Territory territory) {
		for(Territory t: territories) {
			if (t.getIdTerritory() == territory.getIdTerritory())
				return true;
		}
		return false;
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

	@Override
	public String toString() {
		String result = "";
		result += "Continent: " + getName() + "\n";
		result += "	Bonus: " + getBonus() + "\n";
		result += "	Color: " + getColor() + "\n";
		result += "	Territories:\n";
		
		for (Territory t: getTerritories()) {
			result += "		" + t.getName() + "\n";
		}
		
		return result;
	}
	
	

}
