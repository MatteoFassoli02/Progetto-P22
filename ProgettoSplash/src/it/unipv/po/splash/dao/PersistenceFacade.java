package it.unipv.po.splash.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import it.unipv.po.splash.dao.factory.*;
import it.unipv.po.splash.model.risikogame.components.board.Continent;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.components.deck.card.Figure;

public class PersistenceFacade {
	private static PersistenceFacade instance;
	
	private PersistenceFacade() {
		super();
	}
	
	public static PersistenceFacade getInstance() {
		if (instance == null) {
			instance = new PersistenceFacade();
		}
		return instance;
	}
	
	public Territory getTerritory() {
		return MoveMapperFactory.getMoveMapper().getTerritory();
	}
	
	public int getArmies() {
		return MoveMapperFactory.getArmiesMapper().getArmies();
	}
	
	
	public ArrayList<Continent> getAllContinents() throws Exception {
		return MapperFactory.getBoardMapper().getAllContinents();
	}

	public ArrayList<Territory> getAllTerritories() throws Exception { 
		return MapperFactory.getBoardMapper().getAllTerritories();
	}
	
	public ArrayList<String> getBordersOf(Territory t) throws Exception {
		return MapperFactory.getBoardMapper().getBordersOf(t);
	}
	
	public ArrayList<String> getTerritoriesOf(Continent c) throws Exception {
		return MapperFactory.getBoardMapper().getTerritoriesOf(c);
	}
	
	public String getNameBoard() throws Exception {
		return MapperFactory.getBoardMapper().getNameBoard();
	}
	
	public Hashtable<String, Figure> getCards() throws Exception {
		return MapperFactory.getDeckMapper().getCards();
	}
	
	public int getNumJolly() throws Exception {
		return MapperFactory.getDeckMapper().getNumJolly();
	}
	
	public ArrayList<Figure> getFigures() {
		return MapperFactory.getDeckMapper().getFigures();
	}

	public boolean getChoice() {
		return MoveMapperFactory.getChoice().getChoice();
	}
}
