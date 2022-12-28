package it.unipv.po.splash.model.risikogame.components;

import it.unipv.po.splash.model.risikogame.components.board.Board;
import it.unipv.po.splash.model.risikogame.components.board.factory.BoardFactory;
import it.unipv.po.splash.model.risikogame.components.deck.Deck;
import it.unipv.po.splash.model.risikogame.components.deck.factory.DeckFactory;

public class ComponentsFacade {
	private static ComponentsFacade instance;
	
	private ComponentsFacade() {
		super();
	}
	
	public static ComponentsFacade getInstance() {
		if (instance == null) {
			instance = new ComponentsFacade();
		}
		return instance;
	}
	
	public Board createBoard() {
		return BoardFactory.getBoardFactory().createBoard();
	}
	
	public Deck createDeck() {
		return DeckFactory.getDeckFactory().createDeck();
	}
}
