package it.unipv.po.splash.model.risikogame.components.card.figure;

public class Figure {
	private EnumFigure figure;
	private int bonus;
	
	public Figure(EnumFigure figure, int bonus) {
		super();
		this.figure = figure;
		this.bonus = bonus;
	}

	public EnumFigure getFigure() {
		return figure;
	}

	public void setFigure(EnumFigure figure) {
		this.figure = figure;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}
