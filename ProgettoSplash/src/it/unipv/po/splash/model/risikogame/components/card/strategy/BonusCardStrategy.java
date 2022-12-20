package it.unipv.po.splash.model.risikogame.components.card.strategy;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.components.card.TerritoryCard;
import it.unipv.po.splash.model.risikogame.components.card.figure.EnumFigure;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.CardReinforceStrategy;

public class BonusCardStrategy implements ITCBonusStrategy {
	private ArrayList<TerritoryCard> cards; 
	
	public BonusCardStrategy() {
		super();
		cards = new ArrayList<TerritoryCard>();
	}

	@Override
	public void getCardBonus(CardReinforceStrategy cps) {
		cards.addAll(cps.getCards());
		
		//TODO voglio che in futuro questo sia un metodo statico di una classe tipo
		// RisikoGameDefault
		
		if (cards.get(0).getFigure().getFigure() == cards.get(1).getFigure().getFigure() &&
				cards.get(0).getFigure().getFigure() == cards.get(2).getFigure().getFigure()) {
			cps.addReinforce(cards.get(0).getFigure().getBonus());
			return;		
		}
		
		
		if ((cards.get(0).getFigure().getFigure() == EnumFigure.JOLLY) ||
				(cards.get(1).getFigure().getFigure() == EnumFigure.JOLLY) ||
					(cards.get(2).getFigure().getFigure() == EnumFigure.JOLLY))  {
			if (cards.get(0).getFigure().getFigure() == cards.get(1).getFigure().getFigure() ||
					cards.get(0).getFigure().getFigure() == cards.get(2).getFigure().getFigure() ||
						cards.get(1).getFigure().getFigure() == cards.get(2).getFigure().getFigure()) {
				cps.addReinforce(12);
				return;
			}
		}
		
		if ((cards.get(0).getFigure().getFigure() != EnumFigure.JOLLY) &&
				(cards.get(1).getFigure().getFigure() != EnumFigure.JOLLY) &&
					(cards.get(2).getFigure().getFigure() != EnumFigure.JOLLY))  {
			if (cards.get(0).getFigure().getFigure() != cards.get(1).getFigure().getFigure() && 
					cards.get(0).getFigure().getFigure() != cards.get(2).getFigure().getFigure() &&
						cards.get(1).getFigure().getFigure() != cards.get(2).getFigure().getFigure()) {
				cps.addReinforce(10);
				return;
			}
		}
	}
}
