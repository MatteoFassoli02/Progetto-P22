package it.unipv.po.splash.model.risikogame.target;

import it.unipv.po.splash.model.risikogame.Player;

public class ConquestTerritory implements IGameTarget{
	private Player owner;
	private int numberTerritory;
	
	public ConquestTerritory(int i) {
		super();
		numberTerritory = i;
	}
	
	public ConquestTerritory() {
		super();
	}
	
	@Override
	public Boolean isCompleted() {
		if(owner.getEstates().size() > numberTerritory)
			return true;
		return false;
	}

	@Override
	public String showTarget() {
		// TODO Auto-generated method stub
		return "Giocatore "+owner.getName()+" devi conquistare " + numberTerritory+ " territori";
	}

	@Override
	public void setOwner(Player p) {
		this.owner = p;
	}
	
	@Override
	public void initialize() {
		numberTerritory = 16;
	}

}
