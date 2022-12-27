package it.unipv.po.splash.model.risikogame.move.placement.strategy;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;

public class TerritoryReinforceStrategy implements IReinforceStrategy {
	private Player player;
	
	public TerritoryReinforceStrategy(Player player) {
		super();
		this.player = player;
	}

	@Override
	public void estimateReinforce(Reinforcement r) {
		r.addReinforcements(player.getEstates().size() / 3);
	}

}
