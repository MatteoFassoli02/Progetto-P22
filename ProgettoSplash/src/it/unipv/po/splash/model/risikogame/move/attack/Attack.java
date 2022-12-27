package it.unipv.po.splash.model.risikogame.move.attack;

import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.move.IMove;

public class Attack implements IMove {
	private int numDefender;
	private int numAttacker;
	private int numLost;
	private int numKilled;
	private IAttackStrategy strategy;

	public Attack(int numAttacker, int numDefender) {
		super();
		this.numDefender = numDefender;
		this.numAttacker = numAttacker;
		strategy = new DefaultAttackStrategy();
	}

	public Attack(int numAttacker, int numDefender, IAttackStrategy strategy) {
		super();
		this.numDefender = numDefender;
		this.numAttacker = numAttacker;
		this.strategy = strategy;
	}

	@Override
	public void changeTerritory(Territory attacker, Territory defender) {
		strategy.estimateLostandKilled(this);
		if (defender.getNumArmies() <= numKilled) {
			defender.setOwner(attacker.getOwner());
			defender.setNumArmies(numAttacker);
			attacker.removeArmies(numLost + numAttacker);
		} else {
			defender.removeArmies(numKilled);
			attacker.removeArmies(numLost);
		}
	}

	public int getNumDefender() {
		return numDefender;
	}

	public void setNumDefender(int numDefender) {
		this.numDefender = numDefender;
	}

	public int getNumAttacker() {
		return numAttacker;
	}

	public void setNumAttacker(int numAttacker) {
		this.numAttacker = numAttacker;
	}

	public int getNumLost() {
		return numLost;
	}

	public void setNumLost(int numLost) {
		this.numLost = numLost;
	}

	public int getNumKilled() {
		return numKilled;
	}

	public void setNumKilled(int numKilled) {
		this.numKilled = numKilled;
	}

	public IAttackStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IAttackStrategy strategy) {
		this.strategy = strategy;
	}

}
