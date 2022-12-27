package it.unipv.po.splash.model.risikogame.components.board;

public class SearchTerritory {
	private static SearchTerritory instance;
	private Board board;

	private SearchTerritory() {
		super();
	}

	public static SearchTerritory getInstance() {
		if (instance == null) {
			instance = new SearchTerritory();
		}
		return instance;
	}

	public Territory getTerritory(int id) {
		for(Continent c: board.getContinents()) {
			for(Territory t: c.getTerritories()) {
				if(t.getIdTerritory() == id)
					return t; 
			}
		}
		return null;
	}

	public Territory getTerritory(String name) {
		for(Continent c: board.getContinents()) {
			for(Territory t: c.getTerritories()) {
				if(name.equalsIgnoreCase(t.getName()))
					return t; 
			}
		}
		return null;
	}
}
