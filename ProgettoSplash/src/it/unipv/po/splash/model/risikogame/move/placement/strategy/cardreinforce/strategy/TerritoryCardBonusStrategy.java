package it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.strategy;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.components.deck.card.TerritoryCard;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.CardReinforceStrategy;

public class TerritoryCardBonusStrategy implements ITCBonusStrategy{
	public TerritoryCardBonusStrategy() {
		super();
	}

	@Override
	public void getCardBonus(CardReinforceStrategy cps) {
		Player player = cps.getCards().get(0).getOwner();
	
		for(TerritoryCard card : cps.getCards()) {
			for(Territory territory: player.getEstates()) {
				if (card.getIdTerritory() == territory.getIdTerritory()) {
					cps.addReinforce(2);
				}
			}
		}
	}
}
