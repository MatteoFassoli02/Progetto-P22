package it.unipv.po.splash.model.risikogame.components.deck.card.strategy;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.components.deck.card.Figure;
import it.unipv.po.splash.model.risikogame.components.deck.card.TerritoryCard;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.CardReinforceStrategy;

public class CardBonusStrategy implements ITCBonusStrategy {
	private ArrayList<TerritoryCard> cards; 
	
	public CardBonusStrategy() {
		super();
		cards = new ArrayList<TerritoryCard>();
	}

	@Override
	public void getCardBonus(CardReinforceStrategy cps) {
		cards.addAll(cps.getCards());
		
		//TODO voglio che in futuro questo sia un metodo statico di una classe tipo
		// RisikoGameDefault
	}
	
}
