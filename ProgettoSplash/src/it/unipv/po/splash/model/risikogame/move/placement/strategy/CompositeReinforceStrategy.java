package it.unipv.po.splash.model.risikogame.move.placement.strategy;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;

public class CompositeReinforceStrategy implements IReinforceStrategy {
	private ArrayList<IReinforceStrategy> strategies;

	public CompositeReinforceStrategy() {
		super();
		strategies = new ArrayList<IReinforceStrategy>();
	}

	@Override
	public void estimateReinforce(Reinforcement r) {
		for (IReinforceStrategy strategy : strategies) {
			strategy.estimateReinforce(r);
			System.out.println(r.getReinforcements());
		}
	}

	public void addStrategy(IReinforceStrategy s) {
		strategies.add(s);
	}

	public void removeStrategy(IReinforceStrategy s) {
		strategies.remove(s);
	}

	public ArrayList<IReinforceStrategy> getStrategies() {
		return strategies;
	}

	public void setStrategies(ArrayList<IReinforceStrategy> strategies) {
		this.strategies = strategies;
	}
}
