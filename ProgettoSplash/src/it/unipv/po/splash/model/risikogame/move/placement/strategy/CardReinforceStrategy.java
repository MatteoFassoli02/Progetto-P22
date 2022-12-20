package it.unipv.po.splash.model.risikogame.move.placement.strategy;


import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.components.card.TerritoryCard;
import it.unipv.po.splash.model.risikogame.components.card.strategy.ITCBonusStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;

public class CardReinforceStrategy implements IReinforceStrategy {
	private ArrayList<TerritoryCard> cards;
	private int reinforce;
	private ITCBonusStrategy strategy;
	
	public CardReinforceStrategy(ITCBonusStrategy strategy) {
		super();
		reinforce = 0;
		this.strategy = strategy;
		cards = new ArrayList<TerritoryCard>();
	}
	
	public void use(TerritoryCard t1, TerritoryCard t2, TerritoryCard t3) {
		cards.add(t1);
		cards.add(t2);
		cards.add(t3);
		t1.discard(t1.getOwner());
		t2.discard(t2.getOwner());
		t3.discard(t3.getOwner());
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
