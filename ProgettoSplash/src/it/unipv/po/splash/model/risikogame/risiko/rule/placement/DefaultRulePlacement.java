package it.unipv.po.splash.model.risikogame.risiko.rule.placement;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.move.placement.Placement;
import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;

public class DefaultRulePlacement implements IRulePlacements{
	
	public DefaultRulePlacement() {
		super();
	}

	@Override
	public void doPlacements(Player play) {
		Reinforcement r;
		int reinforce;
		int placeArmies;
		Territory territory;
		Placement placement;

		r = new Reinforcement();
		reinforce = r.calcolateReinforcements();
		System.out.println(play.getName() + " hai a disposizione " + reinforce + " truppe da piazzare");

		while (reinforce != 0) {
			System.out.println("seleziona il territorio");
			territory = play.askTerritory();
			while(!play.hasTerritory(territory)) {
				territory = play.askTerritory();
			}
			
			System.out.println("seleziona il num truppe");
			placeArmies = play.askArmies();
			while (placeArmies > reinforce) {
				System.out.println("qua");
				placeArmies = play.askArmies();
			}

			placement = new Placement(placeArmies);
			placement.changeTerritory(territory);

			reinforce -= placeArmies;
		}
	}
}
