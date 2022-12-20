package it.unipv.po.splash.model.risikogame.components;

import java.util.HashSet;

import it.unipv.po.splash.model.risikogame.Player;

public class Territory {
	private int numArmies;
	private String name;
	private int score;
	private int idTerritory;
	private HashSet<Territory> borders;
	private Player owner;

	public Territory(int numArmies, String name, int idTerritory, int score) {
		super();
		this.numArmies = numArmies;
		this.name = name;
		this.idTerritory = idTerritory;
		this.score = score;
		borders = new HashSet<Territory>();
	}

	public boolean isBordering(Territory bordering) {
		for (Territory t : borders) {
			if (t.getIdTerritory() == bordering.getIdTerritory())
				return true;
		}
		return false;
	}

	public void addArmies(int armies) {
		setNumArmies(getNumArmies() + armies);
	}

	public void removeArmies(int armies) {
		setNumArmies(getNumArmies() - armies);
	}

	public int getNumArmies() {
		return numArmies;
	}

	public void setNumArmies(int numArmies) {
		this.numArmies = numArmies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getIdTerritory() {
		return idTerritory;
	}

	public void setIdTerritory(int idTerritory) {
		this.idTerritory = idTerritory;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
