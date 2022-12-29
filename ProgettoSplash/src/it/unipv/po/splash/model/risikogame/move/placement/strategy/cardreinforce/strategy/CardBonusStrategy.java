package it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.strategy;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.components.deck.card.TerritoryCard;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.CardReinforceStrategy;

public class CardBonusStrategy implements ITCBonusStrategy {
	
	public CardBonusStrategy() {
		super();
	}

	@Override
	public void getCardBonus(CardReinforceStrategy cps) {
		ArrayList<TerritoryCard> cards = new ArrayList<TerritoryCard>();
		cards.addAll(cps.getCards());
		
		if (areCardsEqual(cards)) cps.addReinforce(cards.get(0).getBonus());
		if (areCardsNotEqual(cards)) cps.addReinforce(10);
		if (areCardsJolly(cards)) cps.addReinforce(12);
	}
	
	
	private boolean areCardsEqual(ArrayList<TerritoryCard> cards) {
		for(int i = 0; i < cards.size(); i++) 
			for(int j = 1; j < cards.size(); j++)
				if(!cards.get(i).getFigure().equalsIgnoreCase(cards.get(i+1).getFigure()))
					return false;
		return true;
	}
	
	private boolean areCardsNotEqual(ArrayList<TerritoryCard> cards) {
		for(int i = 0; i < cards.size(); i++) 
			for(int j = 1; j < cards.size(); j++)
				if(cards.get(i).getFigure().equalsIgnoreCase(cards.get(i+1).getFigure()))
					return false;
		return true;
	}
	
	private boolean areCardsJolly(ArrayList<TerritoryCard> cards) {
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).getFigure().equalsIgnoreCase("jolly")) {
				cards.remove(cards.get(i));
				if(areCardsEqual(cards)) return true;	
			}
		}
		return false;
	}
}
