package it.unipv.po.splash.model.risikogame.components.deck.card;

import it.unipv.po.splash.model.risikogame.components.board.Territory;

public class TerritoryCard extends AbstractCard {
	private Territory territory;
	private Figure figure;
	
	public TerritoryCard(Territory territory, Figure figure) {
		this.territory = territory;
		this.figure = figure;
	}

	public int getIdTerritory() {
		return territory.getIdTerritory();
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
