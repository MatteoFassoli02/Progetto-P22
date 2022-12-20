package it.unipv.po.splash.model.risikogame.components.card;

import it.unipv.po.splash.model.risikogame.components.Territory;
import it.unipv.po.splash.model.risikogame.components.card.figure.Figure;

public class TerritoryCard extends AbstractCard {
	private int idTerritory;
	private Figure figure;

	public TerritoryCard(int idTerritory, Figure figure) {
		this.idTerritory = idTerritory;
		this.figure = figure;
	}

	public TerritoryCard(Territory territory, Figure figure) {
		this.idTerritory = territory.getIdTerritory();
		this.figure = figure;
	}

	public int getIdTerritory() {
		return idTerritory;
	}

	public void setIdTerritory(int idTerritory) {
		this.idTerritory = idTerritory;
	}

	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}

}
