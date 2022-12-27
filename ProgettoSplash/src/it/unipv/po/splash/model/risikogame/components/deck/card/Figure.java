package it.unipv.po.splash.model.risikogame.components.deck.card;

public class Figure {
	private String figure;
	private int bonus;
	
	public Figure(String figure, int bonus) {
		super();
		this.figure = figure;
		this.bonus = bonus;
	}

	public void setFigure(String figure) {
		this.figure = figure;
	}
	
	public String getFigure() {
		return this.figure;
	}
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Figure [figure=" + figure + ", bonus=" + bonus + "]";
	}

}
