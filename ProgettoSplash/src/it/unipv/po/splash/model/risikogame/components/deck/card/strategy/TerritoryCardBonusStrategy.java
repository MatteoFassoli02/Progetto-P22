package it.unipv.po.splash.model.risikogame.components.deck.card.strategy;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.components.deck.card.TerritoryCard;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.CardReinforceStrategy;

public class TerritoryCardBonusStrategy implements ITCBonusStrategy{
	private Player player;
	
	public TerritoryCardBonusStrategy(Player player) {
		super();
		this.player = player;
	}

	@Override
	public void getCardBonus(CardReinforceStrategy cps) {
		for(TerritoryCard card : cps.getCards()) {
			for(Territory territory: player.getEstates()) {
				if (card.getIdTerritory() == territory.getIdTerritory()) {
					cps.addReinforce(2);
				}
			}
		}
	}
}
