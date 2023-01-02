package it.unipv.po.splash.model;

import java.awt.Color;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.move.attack.Attack;
import it.unipv.po.splash.model.risikogame.move.placement.Placement;
import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;
import it.unipv.po.splash.model.risikogame.risiko.DefaultRisikoGame;
import it.unipv.po.splash.model.risikogame.risiko.IRisikoGame;

public class Main {
	
		public static void main(String[] args) {
			Player p1 = new Player("P1", new Color(0,0,255));
			Player p2 = new Player("P2", new Color(0,255,0));
			Player p3 = new Player("P3", new Color(255,0,0));
			Player p4 = new Player("P4", new Color(255,255,0));
			Player p5 = new Player("P5", new Color(255,0,255));
			Player p6 = new Player("P6", new Color(0,0,0));
			
			
			try {
				DefaultRisikoGame game = DefaultRisikoGame.getInstance();
				game.addPlayer(p1);
				game.addPlayer(p2);
				game.addPlayer(p3);
				DefaultRisikoGame game1 = DefaultRisikoGame.getInstance();
				/*game.addPlayer(p4);
				game.addPlayer(p5);
				game.addPlayer(p6);*/
				game.newGame();
				game.generateTurns();
				game.prepareGame();
				System.out.println(p1.getTarget().showTarget());
				System.out.println(p1.toString());
				System.out.println(p2.getTarget().showTarget());
				System.out.println(p2.toString());
				System.out.println(p3.getTarget().showTarget());
				System.out.println(p3.toString());
				/*System.out.println(p4.getTarget().showTarget());
				System.out.println(p4.toString());
				System.out.println(p5.getTarget().showTarget());
				System.out.println(p5.toString());
				System.out.println(p6.getTarget().showTarget());
				System.out.println(p6.toString());*/
				game.playGame();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		    
	
}
