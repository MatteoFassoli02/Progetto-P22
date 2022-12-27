package it.unipv.po.splash.model.risikogame.components.deck.card;

import java.util.ArrayList;

import it.unipv.po.splash.dao.PersistenceFacade;

public class FigureInGame {
	private static FigureInGame instance;
	private ArrayList<Figure> figures;

	private FigureInGame() {
		super();
		initialize();
	}

	public static FigureInGame getInstance() {
		if (instance == null) {
			instance = new FigureInGame();
		}
		return instance;
	}
	
	public void initialize() {
		PersistenceFacade data = PersistenceFacade.getInstance();
		setFigures(data.getFigures());
	}
	
	public int getBonusOf(String name) {
		for(Figure f: figures) {
			if(name.equalsIgnoreCase(f.getFigure()))
				return f.getBonus();
		}
		return -1;
	}


	public ArrayList<Figure> getFigures() {
		return figures;
	}

	public void setFigures(ArrayList<Figure> figures) {
		this.figures = figures;
	}
	
	public void addFigure(Figure f) {
		figures.add(f);
	}
	
	public void removeFigure(Figure f) {
		figures.remove(f);
	}
}
