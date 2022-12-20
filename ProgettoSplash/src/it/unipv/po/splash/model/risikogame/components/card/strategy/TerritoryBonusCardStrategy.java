package it.unipv.po.splash.model.risikogame.components.card.strategy;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.Territory;
import it.unipv.po.splash.model.risikogame.components.card.TerritoryCard;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.CardReinforceStrategy;

public class TerritoryBonusCardStrategy implements ITCBonusStrategy{
	private Player player;
	
	public TerritoryBonusCardStrategy(Player player) {
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
