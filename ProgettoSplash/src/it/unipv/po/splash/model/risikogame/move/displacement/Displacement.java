package it.unipv.po.splash.model.risikogame.move.displacement;

import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.move.IMove;

public class Displacement implements IMove {
	private int deploy;

	public Displacement(int deploy) {
		super();
		this.deploy = deploy;
	}

	@Override
	public void changeTerritory(Territory t1, Territory t2) {
		t1.removeArmies(deploy);
		t2.addArmies(deploy);
	}

	public int getDeploy() {
		return deploy;
	}

	public void setDeploy(int deploy) {
		this.deploy = deploy;
	}

}
