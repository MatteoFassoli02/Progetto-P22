package it.unipv.po.splash.model.risikogame.move.placement.strategy.factory;

import it.unipv.po.splash.model.risikogame.move.placement.strategy.CompositeReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.ContinentReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.IReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.TerritoryReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.CardReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.cardreinforce.strategy.factory.CardBonusStrategyFactory;

//STCBReinforceStrategyFactory = StartTurn(and)CardBonusReinforceStrategyFactory
public class STCBReinforceStrategyFactory implements  IReinforceStrategyFactory{

	@Override
	public IReinforceStrategy makeReinforceStrategy() {
		CompositeReinforceStrategy crs = new CompositeReinforceStrategy();
		crs.addStrategy(new ContinentReinforceStrategy());
		crs.addStrategy(new TerritoryReinforceStrategy());
		CardReinforceStrategy card = 
				new CardReinforceStrategy(CardBonusStrategyFactory.getCardBonusStrategy().createStrategyBonus());

		crs.addStrategy(card);
		
		return crs;
	}

}
