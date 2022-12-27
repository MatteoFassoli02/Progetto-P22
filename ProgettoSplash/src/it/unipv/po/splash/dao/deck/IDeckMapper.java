package it.unipv.po.splash.dao.deck;

import java.util.ArrayList;
import java.util.Hashtable;

import it.unipv.po.splash.model.risikogame.components.deck.card.Figure;

public interface IDeckMapper {
	public Hashtable<String, Figure> getCards();
	public int getNumJolly();
	public ArrayList<Figure> getFigures();
}
