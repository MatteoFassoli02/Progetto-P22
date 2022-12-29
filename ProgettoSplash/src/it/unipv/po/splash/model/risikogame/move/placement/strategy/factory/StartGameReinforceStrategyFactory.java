package it.unipv.po.splash.model.risikogame.move.placement.strategy.factory;

import it.unipv.po.splash.model.risikogame.move.placement.strategy.IReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.StartGameReinforceStrategy;

public class StartGameReinforceStrategyFactory implements IReinforceStrategyFactory {

	public StartGameReinforceStrategyFactory() {
		super();
	}

	@Override
	public IReinforceStrategy makeReinforceStrategy() {
		return new StartGameReinforceStrategy();
	}

}
