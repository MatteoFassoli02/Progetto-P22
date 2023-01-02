package it.unipv.po.splash.model.risikogame.move.placement;

import it.unipv.po.splash.model.risikogame.move.placement.strategy.IReinforceStrategy;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.factory.ReinforceStrategyFactory;

public class Reinforcement implements IReinforcement{
	private IReinforceStrategy strategy;
	private int reinforcements;


	public Reinforcement() {
		super();
		reinforcements = 0;
		this.strategy = ReinforceStrategyFactory.getReinforceStrategy().makeReinforceStrategy();
	}
	
	public int calcolateReinforcements() {
		strategy.estimateReinforce(this);
		return reinforcements;
	}

	public void addReinforcements(int r) {
		setReinforcements(getReinforcements() + r);
	}

	public void removeReinforcements(int r) {
		setReinforcements(getReinforcements() - r);
	}

	public int getReinforcements() {
		return reinforcements;
	}

	public void setReinforcements(int r) {
		reinforcements = r;
	}

	public IReinforceStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IReinforceStrategy strategy) {
		this.strategy = strategy;
	}
	
}
