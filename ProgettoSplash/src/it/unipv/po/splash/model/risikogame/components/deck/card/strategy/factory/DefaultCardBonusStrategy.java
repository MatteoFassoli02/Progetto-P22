package it.unipv.po.splash.model.risikogame.components.deck.card.strategy.factory;

import it.unipv.po.splash.model.risikogame.components.deck.card.strategy.CardBonusStrategy;
import it.unipv.po.splash.model.risikogame.components.deck.card.strategy.CompositeCardStrategy;
import it.unipv.po.splash.model.risikogame.components.deck.card.strategy.ITCBonusStrategy;
import it.unipv.po.splash.model.risikogame.components.deck.card.strategy.TerritoryCardBonusStrategy;

public class DefaultCardBonusStrategy implements IFactoryBonusCard {

	@Override
	public ITCBonusStrategy createStrategyBonus() {
		CompositeCardStrategy comp = new CompositeCardStrategy();
		comp.addStrategy(new CardBonusStrategy());
		//comp.addStrategy(new TerritoryCardBonusStrategy());
		return null;
	}

}
