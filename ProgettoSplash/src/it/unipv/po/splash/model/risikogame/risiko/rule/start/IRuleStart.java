package it.unipv.po.splash.model.risikogame.risiko.rule.start;

import it.unipv.po.splash.model.risikogame.risiko.IRisikoGame;

public interface IRuleStart {
	public void giveInitialTerritories(IRisikoGame rg);
	public void giveTarget(IRisikoGame rg);
}
