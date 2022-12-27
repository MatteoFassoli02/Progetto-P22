package it.unipv.po.splash.model.risikogame.move.placement.strategy;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.board.Board;
import it.unipv.po.splash.model.risikogame.components.board.Continent;
import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;

public class ContinentReinforceStrategy implements IReinforceStrategy{
	private Board board;
	private Player player;
	
	public ContinentReinforceStrategy(Board board, Player player) {
		super();
		this.board = board;
		this.player = player;
	}

	@Override
	public void estimateReinforce(Reinforcement r) {
		for(Continent c : board.getContinents()) {
			if (player.getEstates().containsAll(c.getTerritories())) {
				r.addReinforcements(c.getBonus());
				System.out.println(c.getBonus() + " da " + c.getName());
			}
		}
	}
}
