package it.unipv.po.splash.model.risikogame.risiko;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Properties;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.ComponentsFacade;
import it.unipv.po.splash.model.risikogame.components.Dice;
import it.unipv.po.splash.model.risikogame.components.board.Board;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.components.deck.Deck;
import it.unipv.po.splash.model.risikogame.move.attack.Attack;
import it.unipv.po.splash.model.risikogame.move.displacement.Displacement;
import it.unipv.po.splash.model.risikogame.move.displacement.IsReachable;
import it.unipv.po.splash.model.risikogame.move.placement.Placement;
import it.unipv.po.splash.model.risikogame.move.placement.Reinforcement;
import it.unipv.po.splash.model.risikogame.move.placement.strategy.factory.ReinforceStrategyFactory;
import it.unipv.po.splash.model.risikogame.risiko.rule.RuleFacade;
import it.unipv.po.splash.model.risikogame.target.IGameTarget;
import it.unipv.po.splash.model.risikogame.target.TargetInGame;
import it.unipv.po.splash.model.risikogame.target.factory.TargetInGameFactory;

public class DefaultRisikoGame implements IRisikoGame {
	private ArrayList<Player> players;
	private ArrayList<Player> turns;
	private boolean preparatory;
	private Board board;
	private Deck deck;
	private static DefaultRisikoGame instance;
	
	private String name;
	private int idGame;
	
	private static final String PLAYER_PROPERTYNAME = "player.playing.now";
	private static final String STRATEGY_PROPERTYNAME = "reinforce.strategy";
	private static final String STCB_STRATEGY = 
			"it.unipv.po.splash.model.risikogame.move.placement.strategy.factory.STCBReinforceStrategyFactory";
	private static final String START_STRATEGY = 
			"it.unipv.po.splash.model.risikogame.move.placement.strategy.factory.StartTurnReinforceStrategyFactory";

	private DefaultRisikoGame() {
		preparatory = true;
		players = new ArrayList<Player>();
		turns = new ArrayList<Player>();
	}
	
	
	public static DefaultRisikoGame getInstance() {
		if (instance == null) {
            instance = new DefaultRisikoGame();
        }
        return instance;
	}
	
	@Override
	public void generateTurns() {
		Dice dice;
		while (!(players.isEmpty())) {
			dice = new Dice(players.size());
			int n = dice.roll();
			turns.add(players.get(n - 1));
			removePlayer(players.get(n - 1));
		}
	}
	
	@Override
	public void newGame() {
		setBoard(ComponentsFacade.getInstance().createBoard());
		setDeck(ComponentsFacade.getInstance().createDeck());
		setPreparatory(true);
	}

	@Override
	public void prepareGame() {
		RuleFacade.getInstance().giveInitialTerritories(this);
		RuleFacade.getInstance().giveTarget(this);
	}

	
	@Override
	public Player playGame() {
		//int startArmies = 20 + (6 - turns.size()) * 3;
		int startArmies = 0;
		int numTerr;
		preparatory = true;
		
		while (preparatory) {
			for (Player play: turns) {
				System.out.println("turno di " + play.getName());
				RuleFacade.getInstance().doPlacements(play);
			}
			if(turns.get(0).getNumArmies() > startArmies)
				preparatory = false;
		}
		
		System.out.println("Finita la fase preparatoria");
		//controller.notify()
		for(Player play: turns) {
			setTurn(play);
			if(play.getTarget().isCompleted())
				return play;
        
			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
				if (play.getCards().size() > 3) {
					if (play.askAction()) {
						p.setProperty(STRATEGY_PROPERTYNAME, STCB_STRATEGY);	
					} 
				} else {
					p.setProperty(STRATEGY_PROPERTYNAME, START_STRATEGY);
					System.out.println(p.getProperty(STRATEGY_PROPERTYNAME));
					System.out.println(
							ReinforceStrategyFactory.getReinforceStrategy().makeReinforceStrategy().getClass().getName());
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			numTerr = play.getEstates().size();
			System.out.println("turno di " + play.getName());
			RuleFacade.getInstance().doPlacements(play);
			RuleFacade.getInstance().doAttacks(play);
			
			if (play.getEstates().size() > numTerr) {
				deck.drawCard(play);
			}

			RuleFacade.getInstance().doDisplacements(play);
			System.out.println(play);
			
		}
		return null;
	}
	
	private void setTurn(Player play) {
		try {
			String turn = Integer.toString(turns.indexOf(play));
			Properties p = new Properties(System.getProperties());
			p.load(new FileInputStream("../ProgettoSplash/sources/properties.txt"));
			p.setProperty(PLAYER_PROPERTYNAME, turn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	@Override
	public void removePlayer(Player p) {
		players.remove(p);
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

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
}
