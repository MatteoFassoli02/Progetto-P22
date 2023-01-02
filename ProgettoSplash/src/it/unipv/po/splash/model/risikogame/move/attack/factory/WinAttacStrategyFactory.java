package it.unipv.po.splash.model.risikogame.move.attack.factory;

import it.unipv.po.splash.model.risikogame.move.attack.IAttackStrategy;
import it.unipv.po.splash.model.risikogame.move.attack.WinAttackStrategy;

public class WinAttacStrategyFactory implements IAttackStategyFactory {
	public WinAttacStrategyFactory() {
		super();
	}

	@Override
	public IAttackStrategy makeStrategyAttack() {
		return new WinAttackStrategy();
	}

}
