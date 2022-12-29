package it.unipv.po.splash.model.risikogame.move.placement.strategy.factory;

import it.unipv.po.splash.model.risikogame.move.placement.strategy.CompositeReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.ContinentReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.IReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.TerritoryReinforceStrategy;

public class StartTurnReinforceStrategyFactory implements IReinforceStrategyFactory{

	public StartTurnReinforceStrategyFactory() {
		super();
	}

	@Override
	public IReinforceStrategy makeReinforceStrategy() {
		CompositeReinforceStrategy crs = new CompositeReinforceStrategy();
		crs.addStrategy(new ContinentReinforceStrategy());
		crs.addStrategy(new TerritoryReinforceStrategy());
		return crs;
	}
	
}
