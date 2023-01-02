package it.unipv.po.splash.model.risikogame.components.deck.card;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.board.Territory;

public class TerritoryCard {
	private Territory territory;
	private Figure figure;
	private Player owner;
	
	public TerritoryCard(Territory territory, Figure figure) {
		super();
		this.territory = territory;
		this.figure = figure;
	}

	public int getIdTerritory() {
		return territory.getIdTerritory();
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
	
	public String getNameTerritory() {
		return territory.getName();
	}

	public String getFigure() {
		return figure.getFigure();
	}

	public void setFigure(String figure) {
		this.figure.setFigure(figure);
	}
	
	public int getBonus() {
		return figure.getBonus();
	}

	public void setBonus(int bonus) {
		this.figure.setBonus(bonus);
	}

	@Override
	public String toString() {
		return "TerritoryCard [Territory=" + getNameTerritory() + ", figure=" + figure + "]";
	}
}

