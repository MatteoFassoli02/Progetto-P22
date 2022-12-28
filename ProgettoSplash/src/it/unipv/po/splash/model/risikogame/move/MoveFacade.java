package it.unipv.po.splash.model.risikogame.move;

import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.move.placement.IPlacement;
import it.unipv.po.splash.model.risikogame.move.placement.IReinforcement;

public class MoveFacade  {
	private static MoveFacade instance;

	private MoveFacade() {
		super();
	}

	public static MoveFacade getInstance() {
		if (instance == null) {
			instance = new MoveFacade();
		}
		return instance;
	}

	
	public void calcolateReinforcements() {
		
	}


	public void changeTerritory(Territory t) {
		// TODO Auto-generated method stub
		
	}

	public void changeTerritory(Territory t1, Territory t2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
