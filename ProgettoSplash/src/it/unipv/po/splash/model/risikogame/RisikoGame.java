package it.unipv.po.splash.model.risikogame;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.components.Dice;
import it.unipv.po.splash.model.risikogame.components.board.Board;

public class RisikoGame {
	private ArrayList<Player> players;
	private ArrayList<Player> turns;
	private boolean preparatory;
	private Board board;

	private String name;
	private int idGame;

	public RisikoGame(String name) {
		this.name = name;
		players = new ArrayList<Player>();
		turns = new ArrayList<Player>();
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public void removePlayer(Player p) {
		players.remove(p);
	}

	public void generateTurns() {
		Dice dice;
		while (!(players.isEmpty())) {
			dice = new Dice(players.size());
			int n = dice.roll();
			turns.add(players.get(n - 1));
			removePlayer(players.get(n - 1));
		}
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public ArrayList<Player> getTurns() {
		return turns;
	}

	public void setTurns(ArrayList<Player> turns) {
		this.turns = turns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public int getIdGame() {
		return idGame;
	}
	
	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public boolean isPreparatory() {
		return preparatory;
	}

	public void setPreparatory(boolean preparatory) {
		this.preparatory = preparatory;
	}
}
