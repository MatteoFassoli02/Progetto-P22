package it.unipv.po.splash.model.risikogame.risiko;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.board.Board;
import it.unipv.po.splash.model.risikogame.components.deck.Deck;

public interface IRisikoGame {
	public void generateTurns();
	public void newGame();
	public void prepareGame();
	public Player playGame();
	
	public void addPlayer(Player p);
	public void removePlayer(Player p);
	
	public ArrayList<Player> getTurns();
	public Board getBoard();
	public Deck getDeck();
}
