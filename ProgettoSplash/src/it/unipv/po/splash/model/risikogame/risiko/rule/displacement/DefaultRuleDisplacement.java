package it.unipv.po.splash.model.risikogame.risiko.rule.displacement;

import java.util.HashSet;
import java.util.Hashtable;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.move.displacement.Displacement;
import it.unipv.po.splash.model.risikogame.move.displacement.IsReachable;

public class DefaultRuleDisplacement implements IRuleDisplacement{
	
	public DefaultRuleDisplacement() {
		super();
	}

	@Override
	public void doDisplacements(Player play) {
		Territory start = null;
		Territory end = null;
		int armies = 0;
		
		boolean permitted = false;
		Hashtable <Territory, Territory> disp = new Hashtable<Territory, Territory>();

		double check;

		check = (double) play.getNumArmies() / (double) play.getEstates().size();
		
		if(check > 1) {

			for(Territory t1: play.getEstates()) {
				for(Territory t2: play.getEstates()) {
					IsReachable is = new IsReachable();
					if(is.isReachable(t1, t2, play)) {
						permitted = true;
						disp.put(t1, t2);
						}
				}
			}
			System.out.println(disp);

			while (permitted) {
				start = play.askTerritory();
				while (!play.hasTerritory(start)) {
					start = play.askTerritory();
				}


				end = play.askTerritory();
				while (!play.hasTerritory(end)) {
					end = play.askTerritory();
				}
				IsReachable is = new IsReachable();
				if (is.isReachable(start, end, play)) {
					permitted = false;
				}

				armies = play.askArmies();
				while(armies > (start.getNumArmies()-1)) {
					armies = play.askArmies();
				}
			}

			if(start != null && end != null) {
				Displacement d = new Displacement(armies);
				d.changeTerritory(start, end);
			}
		}
	}
}
