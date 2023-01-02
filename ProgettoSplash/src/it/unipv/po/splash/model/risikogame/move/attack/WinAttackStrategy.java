package it.unipv.po.splash.model.risikogame.move.attack;

public class WinAttackStrategy implements IAttackStrategy {

	public WinAttackStrategy() {
		super();
	}

	@Override
	public void estimateLostandKilled(Attack attack) {
		attack.setNumKilled(3);
		attack.setNumLost(0);
	}

}
