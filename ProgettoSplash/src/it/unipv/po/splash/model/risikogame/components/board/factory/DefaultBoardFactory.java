package it.unipv.po.splash.model.risikogame.components.board.factory;

import java.util.ArrayList;

import it.unipv.po.splash.dao.PersistenceFacade;
import it.unipv.po.splash.model.risikogame.components.board.Board;
import it.unipv.po.splash.model.risikogame.components.board.Continent;
import it.unipv.po.splash.model.risikogame.components.board.Territory;

public class DefaultBoardFactory implements IBoardFactory {
	
	public DefaultBoardFactory() {
		super();
	}
	
	@Override
	public Board createBoard() {
		PersistenceFacade data = PersistenceFacade.getInstance();
		Board result = new Board();
		ArrayList<Continent> cont = new ArrayList<Continent>();
		ArrayList<Territory> terr = new ArrayList<Territory>();
		int i = 1;
		try {
			cont = data.getAllContinents();
			terr = data.getAllTerritories();
			
			for(Territory t: terr) {
				for(Territory bord: terr) {
					for(String n : data.getBordersOf(t)) {
						if(n.equalsIgnoreCase(bord.getName())) {
							t.addBorder(bord);
						}
					}
				}
			}
			
			for(Continent c: cont) {
				for(Territory t: terr) {
					for(String n : data.getTerritoriesOf(c)) {
						if(n.equalsIgnoreCase(t.getName())) {
							c.addTerritory(t);
							t.setIdTerritory(i);
							t.setColor(c.getColor());
							i++;
						}
					}
				}
				result.addContinent(c);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
