package it.unipv.po.splash.model.risikogame;

import java.awt.Color;
import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.components.ComponentsFacade;
import it.unipv.po.splash.model.risikogame.components.Dice;
import it.unipv.po.splash.model.risikogame.components.board.Board;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.components.deck.Deck;

public class RisikoGame {
	private ArrayList<Player> players;
	private ArrayList<Player> turns;
	private boolean preparatory;
	private Board board;
	private Deck deck;
	private static RisikoGame instance;
	private String name;
	private int idGame;

	private RisikoGame() {
		preparatory = true;
		players = new ArrayList<Player>();
		turns = new ArrayList<Player>();
	}
	
	public static RisikoGame getInstance() {
		if (instance == null) {
            instance = new RisikoGame();
        }
        return instance;
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
	
	public void newGame() {
		setBoard(ComponentsFacade.getInstance().createBoard());
		setDeck(ComponentsFacade.getInstance().createDeck());
		setPreparatory(true);
	}
	
	public void giveInitialTerritories() {
		ArrayList<Territory> territories = new ArrayList<Territory>();
		Dice dice;

		territories.addAll(board.getAllTerritory());
		while(!(territories.isEmpty())) {
			for(Player p: turns) {
				if(!(territories.isEmpty())) {
					dice = new Dice(territories.size());

					int n = dice.roll();
					territories.get(n - 1).setOwner(p);
					p.addEstate(territories.get(n - 1));
					p.addScore(territories.get(n - 1).getScore());
					territories.get(n - 1).setNumArmies(1);
					territories.remove(n - 1);
				}
			}
		}
	}
	
	public void playGame() {
		while (preparatory) {
			for(Player p: turns) {
				//chiedi su quale territorio vuoi mettere le truppe (con id)
				//verifica se possibile
				//chiedi quante truppe vuoi mettere (con un max)
				//continua a fare questo giochino finchè truppe = 0
			}
			preparatory = false;
		}
		
		while(true) {
			for(Player p: turns) {
				//verifica se l'obbiettivo di inizio turno è stato compiuto
				
				//chiedi al giocatore se vuole usare delle carte
				
				//chiedi su quale territorio vuoi mettere le truppe (con id)
				//verifica se possibile
				//chiedi quante truppe vuoi mettere (con un max)
				//continua a fare questo giochino finchè truppe = 0
				
				//chiedi quale attacco si vuole fare
				//verifica se è possibile
				//chiedi con quante truppe (max 3)
				//verifca se possibile
				//continua fino a che un giocatore non vuole smettere di attaccare
								
				//verifica se l'obbiettivo di fine turno è stato compiuto
				
				//verifica se il giocatore ha conquistato un territorio 
				//fai pescare una carta dal mazzo 
			}
		}
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	public void removePlayer(Player p) {
		players.remove(p);
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

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
}
