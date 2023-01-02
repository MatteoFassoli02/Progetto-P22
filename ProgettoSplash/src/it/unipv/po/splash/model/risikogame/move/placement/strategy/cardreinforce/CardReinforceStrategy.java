package it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.deck.card.TerritoryCard;
import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.IReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.strategy.ITCBonusStrategy;
import it.unipv.po.splash.model.risikogame.risiko.DefaultRisikoGame;

public class CardReinforceStrategy implements IReinforceStrategy {
	private ArrayList<TerritoryCard> cards;
	private int reinforce;
	private ITCBonusStrategy strategy;
	private Player player;
	
	private static final String PLAYER_PROPERTYNAME = "player.playing.now";
	
	public CardReinforceStrategy(ITCBonusStrategy strategy) {
		super();
		reinforce = 0;
		this.strategy = strategy;
		cards = new ArrayList<TerritoryCard>();
		initialize();
	}
	
	public void initialize() {
		try {
			String categoryClassName;
			Properties p = new Properties(System.getProperties());
			p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
			categoryClassName = p.getProperty(PLAYER_PROPERTYNAME);
			
			player = DefaultRisikoGame.getInstance().getTurns().get(Integer.parseInt(categoryClassName));
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < 3; i++) {
			cards.add(player.askCard());
		}
	}
	
	@Override
	public void estimateReinforce(Reinforcement r) {
		strategy.getCardBonus(this);
		r.addReinforcements(reinforce);
	}

	public ArrayList<TerritoryCard> getCards() {
		return cards;
	}

	public void setCards(ArrayList<TerritoryCard> cards) {
		this.cards = cards;
	}

	public int getReinforce() {
		return reinforce;
	}

	public void setReinforce(int placement) {
		this.reinforce = placement;
	}

	public ITCBonusStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(ITCBonusStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void addReinforce(int r) {
		setReinforce(getReinforce() + r);
	}
	
	public void removeReinforce(int r) {
		setReinforce(getReinforce() - r);
	}
}
