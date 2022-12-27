package it.unipv.po.splash.dao.board;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.components.board.Continent;
import it.unipv.po.splash.model.risikogame.components.board.Territory;

public interface IBoardMapper {
	public ArrayList<Continent> getAllContinents();
	public ArrayList<Territory> getAllTerritories();
	public ArrayList<String> getBordersOf(Territory t);
	public ArrayList<String> getTerritoriesOf(Continent c);
	public String getNameBoard();
}
