package it.unipv.po.splash.model.risikogame;

import java.util.ArrayList;
import java.awt.Color;

import it.unipv.po.splash.dao.PersistenceFacade;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.components.deck.card.TerritoryCard;
import it.unipv.po.splash.model.risikogame.target.IGameTarget;

public class Player {
	private String name;
	private int score;
	private Color colorArmies;
	private ArrayList<TerritoryCard> cards;
	private IGameTarget target;
	private ArrayList<Territory> estates;
	
	private Player killedBy;
	private boolean dead;


	public Player(String name, Color colorArmies) {
		super();
		this.name = name;
		this.colorArmies = colorArmies;
		score = 0;
		dead = false;
		cards = new ArrayList<TerritoryCard>();
		estates = new ArrayList<Territory>();
	}
	
	public Territory askTerritory() {
		return PersistenceFacade.getInstance().getTerritory();
	}
	
	public int askArmies() {
		return PersistenceFacade.getInstance().getArmies();
	}
	
	public boolean askRepeatAttack() {
		return PersistenceFacade.getInstance().getChoice();
	}
	
	public boolean askAction() {
		return PersistenceFacade.getInstance().getChoice();
	}
	
	public TerritoryCard askCard() {
		int num = PersistenceFacade.getInstance().getArmies();
		return cards.get(num);
	}
	
	public boolean hasTerritory(Territory t) {
		for(Territory t1: estates) {
			if(t.getName().equalsIgnoreCase(t1.getName()))
				return true;
		}
		return false;
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

	public ArrayList<TerritoryCard> getCards() {
		return cards;
	}

	public void setCards(ArrayList<TerritoryCard> cards) {
		this.cards = cards;
	}

	public void addCard(TerritoryCard card) {
		cards.add(card);
	}

	public void removeCard(TerritoryCard card) {
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
	
	public IGameTarget getTarget() {
		return target;
	}
	
	public void setTarget(IGameTarget target) {
		this.target = target;
	}
	
	public int getNumArmies() {
		int result = 0;
		for(Territory t: estates) {
			result += t.getNumArmies();
		}
		return result;
	}

	@Override
	public String toString() {
		String s = "-- Player information: " + getName() + " --\nTerritori Posseduti:\n";
		for (Territory t:  estates) {
			s += t.getName() + ": [" + t.getNumArmies() + "]\n";			
		}
		
		s += "Carte Possedute:\n";
		for (TerritoryCard c:  cards) {
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
