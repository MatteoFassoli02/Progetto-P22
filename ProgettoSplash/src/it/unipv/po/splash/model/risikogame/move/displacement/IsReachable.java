package it.unipv.po.splash.model.risikogame.move.displacement;

import java.util.Hashtable;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.board.Territory;

public class IsReachable {
	private Hashtable<Territory, Boolean> flag;
	
	public IsReachable() {
		super();
		flag = new Hashtable<Territory, Boolean>();
	}
	
	public boolean isReachable(Territory t1, Territory t2, Player player) {
		
		if(t1 == t2) {
			return false;
		}
		
	
		flag.put(t1, true);
		for(Territory border: t1.getBorders()) {
			if(flag.get(border) == null) {
				if (border.getOwner().getName().equalsIgnoreCase(player.getName())) {
					if(border.isBordering(t2))
						return true;
					if(t1.isBordering(t2))
						return true;
					return isReachable(border, t2, player);
				}
			}
		}
		return false;
	}
}
