package it.unipv.po.splash.model.risikogame.target;

import it.unipv.po.splash.model.risikogame.Player;

public interface IGameTarget {
	public Boolean isCompleted();
	public void setOwner(Player p);
	public void initialize();
	public String showTarget();
}
