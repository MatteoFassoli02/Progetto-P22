package it.unipv.po.splash.model.risikogame.move.placement;

import it.unipv.po.splash.model.risikogame.move.placement.strategy.IReinforceStrategy;

public class Reinforcement implements IReinforcement{
	private IReinforceStrategy strategy;
	private int reinforcements;


	public Reinforcement(IReinforceStrategy strategy) {
		super();
		reinforcements = 0;
		this.strategy = strategy;
	}
	
	public void calcolateReinforcements() {
		strategy.estimateReinforce(this);
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
