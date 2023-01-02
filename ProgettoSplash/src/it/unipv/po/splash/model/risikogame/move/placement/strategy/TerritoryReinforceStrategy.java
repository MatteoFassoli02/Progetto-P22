package it.unipv.po.splash.model.risikogame.move.placement.strategy;

import java.io.FileInputStream;
import java.util.Properties;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;
import it.unipv.po.splash.model.risikogame.risiko.DefaultRisikoGame;

public class TerritoryReinforceStrategy implements IReinforceStrategy {
	private Player player;
	
	private static final String PLAYER_PROPERTYNAME = "player.playing.now";
	
	public TerritoryReinforceStrategy() {
		super();
		initialize();
	}

	@Override
	public void estimateReinforce(Reinforcement r) {
		r.addReinforcements(player.getEstates().size() / 3);
	}
	
	public void initialize() {
		
		try {
			String categoryClassName;
			Properties p = new Properties(System.getProperties());
			p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
			categoryClassName = p.getProperty(PLAYER_PROPERTYNAME);
			
			player = DefaultRisikoGame.getInstance().getTurns().get(Integer.parseInt(categoryClassName));
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
