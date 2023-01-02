package it.unipv.po.splash.model.risikogame.target;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.Dice;
import it.unipv.po.splash.model.risikogame.components.board.Continent;
import it.unipv.po.splash.model.risikogame.risiko.DefaultRisikoGame;

public class ConquestContinents implements IGameTarget{
	private Player owner;
	private ArrayList<Continent> targets;
	private static final int NUM_CONT = 2;
	
	public ConquestContinents() {
		super();
		targets = new ArrayList<Continent>(); 
	}
	
	@Override
	public Boolean isCompleted() {
		for(Continent c: targets) {
			if(!owner.getEstates().containsAll(c.getTerritories()))
				return false;
		}
		return true;
	}
	
	@Override
	public String showTarget() {
		String result = "Giocatore " + owner.getName() + " devi conquistare ";
		for(Continent c: targets) {
			result += c.getName() + " ";
		}
		return result;
	}
	
	public void initialize() {
		DefaultRisikoGame game = DefaultRisikoGame.getInstance();
		ArrayList<Continent> temp = new ArrayList<Continent>();
		temp.addAll(game.getBoard().getContinents());
		
		Dice dice = new Dice(temp.size());
		for (int i = 0; i < NUM_CONT; i++) {
			dice = new Dice(temp.size());
			int roll = dice.roll() - 1;
			targets.add(temp.get(roll));
			temp.remove(roll);
		}
	}

	@Override
	public void setOwner(Player p) {
		this.owner = p;
	}
}
