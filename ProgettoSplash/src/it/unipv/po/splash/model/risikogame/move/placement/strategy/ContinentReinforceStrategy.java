package it.unipv.po.splash.model.risikogame.move.placement.strategy;

import java.io.FileInputStream;
import java.util.Properties;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.RisikoGame;
import it.unipv.po.splash.model.risikogame.components.board.Board;
import it.unipv.po.splash.model.risikogame.components.board.Continent;
import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;

public class ContinentReinforceStrategy implements IReinforceStrategy{
	private Board board;
	private Player player;
	
	private static final String PLAYER_PROPERTYNAME = "player.playing.now";
	
	public ContinentReinforceStrategy() {
		super();
		initialize();
	}

	@Override
	public void estimateReinforce(Reinforcement r) {
		for(Continent c : board.getContinents()) {
			if (player.getEstates().containsAll(c.getTerritories())) {
				r.addReinforcements(c.getBonus());
				System.out.println(c.getBonus() + " da " + c.getName());
			}
		}
	}

	public void initialize() {
		board = RisikoGame.getInstance().getBoard();

		try {
			String categoryClassName;
			Properties p = new Properties(System.getProperties());
			p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
			categoryClassName = p.getProperty(PLAYER_PROPERTYNAME);
			
			player = RisikoGame.getInstance().getTurns().get(Integer.parseInt(categoryClassName));
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
