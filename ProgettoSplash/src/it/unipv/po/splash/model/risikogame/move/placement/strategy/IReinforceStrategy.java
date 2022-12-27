package it.unipv.po.splash.model.risikogame.move.placement.strategy;

import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;

public interface IReinforceStrategy {
	public void estimateReinforce(Reinforcement r);
}
