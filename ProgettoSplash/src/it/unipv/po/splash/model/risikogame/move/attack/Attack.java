package it.unipv.po.splash.model.risikogame.move.attack;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.move.IMove;
import it.unipv.po.splash.model.risikogame.move.attack.factory.AttackStrategyFactory;

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
		strategy = AttackStrategyFactory.getAttackStrategy().makeStrategyAttack();
	}

	@Override
	public void changeTerritory(Territory attacker, Territory defender) {
		System.out.println("Attacco da: " + attacker.getName() + " [" + attacker.getIdTerritory() + "]");
		System.out.println("Difesa in: " + defender.getName() + " [" + defender.getIdTerritory() + "]" + " di " + defender.getOwner().getName());
		Player d = defender.getOwner();
		Player a = attacker.getOwner();
		strategy.estimateLostandKilled(this);
		System.out.println("Attacco perde: " + numLost);
		System.out.println("Difesa perde: " + numKilled);
		defender.removeArmies(numKilled);
		
		if (defender.getNumArmies() <= 0) {
			defender.setOwner(attacker.getOwner());
			d.removeEstate(defender);
			a.addEstate(defender);
			defender.setNumArmies(numAttacker);
			attacker.removeArmies(numLost + numAttacker);
			
			if (d.getEstates().isEmpty()) {
				d.isKilledBy(a);
			}
		} else {
			attacker.removeArmies(numLost);
		}
		System.out.println("Risultato dell'attacco");
		System.out.println(attacker.showInformation());
		System.out.println(defender.showInformation());
	}
	
	public void showAttack() {
		
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
