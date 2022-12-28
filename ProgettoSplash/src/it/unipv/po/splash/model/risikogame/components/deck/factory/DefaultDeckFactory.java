package it.unipv.po.splash.model.risikogame.components.deck.factory;

import it.unipv.po.splash.dao.PersistenceFacade;
import it.unipv.po.splash.model.risikogame.components.board.Board;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.components.board.factory.BoardFactory;
import it.unipv.po.splash.model.risikogame.components.deck.Deck;
import it.unipv.po.splash.model.risikogame.components.deck.card.TerritoryCard;

public class DefaultDeckFactory implements IDeckFactory{
	private Board board;
	
	public DefaultDeckFactory() {
		super();
		initialize();
	}
	
	public void initialize() {
		this.board = 
		BoardFactory.getBoardFactory().createBoard();
	}

	@Override
	public Deck createDeck() {
		PersistenceFacade data = PersistenceFacade.getInstance();
		Deck result = new Deck();

		try {
			for(Territory t: board.getAllTerritory()) {
				data.getCards().get(t.getName());
				result.addCard(new TerritoryCard(t, data.getCards().get(t.getName())));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
