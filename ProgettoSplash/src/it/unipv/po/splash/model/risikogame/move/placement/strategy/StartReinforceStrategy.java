package it.unipv.po.splash.model.risikogame.move.placement.strategy;

import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;

public class StartReinforceStrategy implements IReinforceStrategy {

	@Override
	public void estimateReinforce(Reinforcement r) {
		// TODO inserire al posto di 3 un qualcosa tipo defaultRisikogame.startArmies
		r.addReinforcements(3);
	}

}
