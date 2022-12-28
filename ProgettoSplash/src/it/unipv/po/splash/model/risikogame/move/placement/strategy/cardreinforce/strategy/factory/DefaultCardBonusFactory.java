package it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.strategy.factory;

import it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.strategy.CardBonusStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.strategy.CompositeCardStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.strategy.ITCBonusStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.strategy.TerritoryCardBonusStrategy;

public class DefaultCardBonusFactory implements ICardBonusFactory {

	
	public DefaultCardBonusFactory() {
		super();
	}

	@Override
	public ITCBonusStrategy createStrategyBonus() {
		CompositeCardStrategy comp = new CompositeCardStrategy();
		comp.addStrategy(new CardBonusStrategy());
		comp.addStrategy(new TerritoryCardBonusStrategy());
		return comp;
	}
}
