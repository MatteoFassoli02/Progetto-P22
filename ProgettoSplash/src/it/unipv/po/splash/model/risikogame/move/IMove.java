package it.unipv.po.splash.model.risikogame.move;

import it.unipv.po.splash.model.risikogame.components.board.Territory;

public interface IMove {
	public void changeTerritory(Territory t1, Territory t2);
}
