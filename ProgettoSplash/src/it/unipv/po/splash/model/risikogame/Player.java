package it.unipv.po.splash.model.risikogame;

import java.util.ArrayList;
import java.awt.Color;

import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.components.deck.card.AbstractCard;
import it.unipv.po.splash.model.risikogame.target.KillPlayerTarget;

public class Player {
	private String name;
	private int score;
	private Color colorArmies;
	private KillPlayerTarget target;
	private ArrayList<AbstractCard> cards;
	private ArrayList<Territory> estates;
	private Player killedBy;
	private boolean dead;


	public Player(String name, Color colorArmies) {
		super();
		this.name = name;
		this.colorArmies = colorArmies;
		score = 0;
		dead = false;
		cards = new ArrayList<AbstractCard>();
		estates = new ArrayList<Territory>();
	}

	public boolean isDead() {
		return dead;
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
	
	public void addScore(int i) {
		setScore(getScore() + i);
	}
	
	public void removeScore(int i) {
		setScore(getScore() - i);
	}
	
	public Color getColorArmies() {
		return colorArmies;
	}

	public void setColorArmies(Color colorArmies) {
		this.colorArmies = colorArmies;
	}

	public ArrayList<AbstractCard> getCards() {
		return cards;
	}

	public void setCards(ArrayList<AbstractCard> cards) {
		this.cards = cards;
	}

	public void addCard(AbstractCard card) {
		cards.add(card);
	}

	public void removeCard(AbstractCard card) {
		cards.remove(card);
	}

	public ArrayList<Territory> getEstates() {
		return estates;
	}

	public void setEstates(ArrayList<Territory> estates) {
		this.estates = estates;
	}
	
	public void addEstate(Territory t) {
		estates.add(t);
	}

	public void removeEstate(Territory t) {
		estates.remove(t);
	}
	
	public KillPlayerTarget getTarget() {
		return target;
	}
	
	public void setTarget(KillPlayerTarget target) {
		this.target = target;
	}
	

	@Override
	public String toString() {
		String s = "-- Player information: " + getName() + " --\nTerritori Posseduti:\n";
		for (Territory t:  estates) {
			s += t.getName() + ": [" + t.getNumArmies() + "]\n";			
		}
		
		s += "Carte Possedute:\n";
		for (AbstractCard c:  cards) {
			s += c.toString() + "\n";			
		}
		s += "Punteggio: " + getScore() +"\n";
		return s;
	}

	public Player killedBy() {
		return killedBy;
	}

	public void isKilledBy(Player killedBy) {
		this.dead = true;
		this.killedBy = killedBy;
	}

}
