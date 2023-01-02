package it.unipv.po.splash.model.risikogame.risiko.rule;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.risiko.IRisikoGame;

public class RuleFacade {
	private static RuleFacade instance;

	private RuleFacade() {
		super();
	}

	public static RuleFacade getInstance() {
		if (instance == null) {
			instance = new RuleFacade();
		}
		return instance;
	}
	
	public void doAttacks(Player play) {
		RuleFactory.getRuleAttack().doAttacks(play);
	}
	
	public void doDisplacements(Player play) {
		RuleFactory.getRuleDisplacement().doDisplacements(play);

	}
	
	public void doPlacements(Player play) {
		RuleFactory.getRulePlacement().doPlacements(play);;

	}
	
	public void giveInitialTerritories(IRisikoGame rg) {
		RuleFactory.getRuleStart().giveInitialTerritories(rg);

	}
	
	public void giveTarget(IRisikoGame rg) {
		RuleFactory.getRuleStart().giveTarget(rg);
	}
}
