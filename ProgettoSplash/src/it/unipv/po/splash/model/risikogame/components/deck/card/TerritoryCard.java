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

	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	@Override
	public String toString() {
		return "TerritoryCard [Territory=" + getNameTerritory() + ", figure=" + figure + "]";
	}
	
	

}
