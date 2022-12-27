package it.unipv.po.splash.model.risikogame.move.placement;

import it.unipv.po.splash.model.risikogame.components.board.Territory;
public class Placement implements IPlacement {
	private int placementArmies;

	public Placement(int placementArmies) {
		super();
		this.placementArmies = placementArmies;
	}

	@Override
	public void changeTerritory(Territory t) {
		t.addArmies(placementArmies);
	}

	public int getPlacementArmies() {
		return placementArmies;
	}

	public void setPlacementArmies(int armies) {
		placementArmies = armies;
	}

}
