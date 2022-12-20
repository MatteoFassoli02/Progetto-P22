package it.unipv.po.splash.model.risikogame.components.card.strategy;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.move.placement.strategy.CardReinforceStrategy;

public class CompositeCardStrategy implements ITCBonusStrategy {
	private ArrayList<ITCBonusStrategy> strategies;

	public CompositeCardStrategy() {
		super();
		strategies = new ArrayList<ITCBonusStrategy>();
	}

	@Override
	public void getCardBonus(CardReinforceStrategy cps) {
		for (ITCBonusStrategy strategy : strategies) {
			strategy.getCardBonus(cps);
			System.out.println(cps.getReinforce() + " bonus dalle carte");
		}
	}

	public void addStrategy(ITCBonusStrategy s) {
		strategies.add(s);
	}

	public void removeStrategy(ITCBonusStrategy s) {
		strategies.remove(s);
	}

	public ArrayList<ITCBonusStrategy> getStrategies() {
		return strategies;
	}

	public void setStrategies(ArrayList<ITCBonusStrategy> strategies) {
		this.strategies = strategies;
	}
	
}
