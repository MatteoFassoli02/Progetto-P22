package it.unipv.po.splash.model.risikogame.components.card;

import it.unipv.po.splash.model.risikogame.Player;

public abstract class AbstractCard {
	private Player owner;

	public AbstractCard() {
		super();
	}

	public void discard(Player p) {
		p.removeCard(this);
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
