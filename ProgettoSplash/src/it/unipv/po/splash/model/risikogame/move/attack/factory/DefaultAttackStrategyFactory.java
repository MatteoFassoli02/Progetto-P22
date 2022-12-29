package it.unipv.po.splash.model.risikogame.move.attack.factory;

import it.unipv.po.splash.model.risikogame.move.attack.DefaultAttackStrategy;
import it.unipv.po.splash.model.risikogame.move.attack.IAttackStrategy;

public class DefaultAttackStrategyFactory implements IAttackStategyFactory{ 
	
	public DefaultAttackStrategyFactory() {
		super();
	}

	@Override
	public IAttackStrategy makeStrategyAttack() {
		return new DefaultAttackStrategy();
	}

}
