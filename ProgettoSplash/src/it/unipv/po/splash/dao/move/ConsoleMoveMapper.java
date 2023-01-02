package it.unipv.po.splash.dao.move;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import it.unipv.po.splash.model.risikogame.components.board.Board;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.risiko.DefaultRisikoGame;

public class ConsoleMoveMapper  implements IMoveMapper{

	public ConsoleMoveMapper() {
		super();
	}

	@Override
	public Territory getTerritory() {
		Board board = DefaultRisikoGame.getInstance().getBoard();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				String s = br.readLine();
				for (Territory t: board.getAllTerritory()) {
					if (s.equalsIgnoreCase(t.getName())) {
						return t;
					}
				}
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
