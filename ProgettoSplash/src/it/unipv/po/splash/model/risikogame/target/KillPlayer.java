package it.unipv.po.splash.model.risikogame.target;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.Dice;
import it.unipv.po.splash.model.risikogame.risiko.DefaultRisikoGame;

public class KillPlayer implements IGameTarget{
	private boolean completed = false;
	private Player owner;
	private Player target;
	
	public KillPlayer() {
		super();
	}

	@Override
	public Boolean isCompleted() {
		if(target.killedBy() != null) {
			if(target.killedBy().getName().equalsIgnoreCase(owner.getName())) { 
				completed = true;
			} else {
				owner.setTarget(new ConquestTerritory(16)); //TODO
				return owner.getTarget().isCompleted();
			}
		}
		return completed;
	}

	@Override
	public String showTarget() {
		
		return "Giocatore " + owner.getName() + " devi uccidere " + target.getName();
	}
	
	public void initialize() {
		DefaultRisikoGame game = DefaultRisikoGame.getInstance();
		ArrayList<Player> temp = new ArrayList<Player>();
		temp.addAll(game.getTurns());
		temp.remove(owner);
		Dice dice = new Dice(temp.size());
		setTarget(temp.get(dice.roll() - 1));
	}
	
	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Player getTarget() {
		return target;
	}

	public void setTarget(Player target) {
		this.target = target;
	}
	

}
