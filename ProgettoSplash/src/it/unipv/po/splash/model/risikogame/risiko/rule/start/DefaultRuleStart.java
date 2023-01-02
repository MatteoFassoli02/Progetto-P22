package it.unipv.po.splash.model.risikogame.risiko.rule.start;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.Dice;
import it.unipv.po.splash.model.risikogame.components.board.Board;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.risiko.IRisikoGame;
import it.unipv.po.splash.model.risikogame.target.IGameTarget;
import it.unipv.po.splash.model.risikogame.target.TargetInGame;
import it.unipv.po.splash.model.risikogame.target.factory.TargetInGameFactory;

public class DefaultRuleStart implements IRuleStart {
	
	public DefaultRuleStart() {
		super();
	}

	public void giveInitialTerritories(IRisikoGame rg) {
		ArrayList<Territory> territories = new ArrayList<Territory>();
		Dice dice;
		ArrayList<Player> turns = rg.getTurns();
		Board board = rg.getBoard(); 

		territories.addAll(board.getAllTerritory());
		while(!(territories.isEmpty())) {
			for(Player p: turns) {
				if(!(territories.isEmpty())) {
					dice = new Dice(territories.size());

					int n = dice.roll();
					territories.get(n - 1).setOwner(p);
					p.addEstate(territories.get(n - 1));
					p.addScore(territories.get(n - 1).getScore());
					territories.get(n - 1).setNumArmies(4);
					territories.remove(n - 1);
				}
			}
		}
	}
	
	public void giveTarget(IRisikoGame rg) {
		TargetInGame target = TargetInGameFactory.getTargetInGameFactory().getTargetInGame();
		Dice dice;
		ArrayList<Player> turns = rg.getTurns();
		
		for(Player p: turns) {
			dice = new Dice(target.getNumberOfTargets());
			int n = dice.roll();
			IGameTarget gt;
			try {
				gt = (IGameTarget) Class.forName(target.getTargetInGame(n-1)).getDeclaredConstructor().newInstance();
				gt.setOwner(p);
				gt.initialize();
				p.setTarget(gt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
