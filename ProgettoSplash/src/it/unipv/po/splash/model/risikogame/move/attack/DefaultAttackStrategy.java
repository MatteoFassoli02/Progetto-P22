package it.unipv.po.splash.model.risikogame.move.attack;

import java.util.ArrayList;
import java.util.Comparator;

import it.unipv.po.splash.model.risikogame.components.Dice;

public class DefaultAttackStrategy implements IAttackStrategy {
	private ArrayList<Integer> resultAttack;
	private ArrayList<Integer> resultDefense;

	public DefaultAttackStrategy() {
		super();
		resultAttack = new ArrayList<Integer>();
		resultDefense = new ArrayList<Integer>();
	}

	@Override
	public void estimateLostandKilled(Attack attack) {
		rollDices(attack.getNumAttacker(), attack.getNumDefender());
		try {
			for (int i = 0;; i++) {
				if (resultAttack.get(i) <= resultDefense.get(i)) {
					attack.setNumLost(attack.getNumLost() + 1);
				} else {
					attack.setNumKilled(attack.getNumKilled() + 1);
				}

			}
		} catch (IndexOutOfBoundsException e) {
			return;
		}
	}

	private void rollDices(int numAttacker, int numDefender) {
		// TODO sostituire il 6 con RisikoGame.DEFAULTDICE
		Dice dice = new Dice(6);
		for (int i = 0; i < numAttacker; i++) {
			resultAttack.add(dice.roll());
		}
		resultAttack.sort(new DefaultAttackComparator<Integer>());
		System.out.println("attacco: " + resultAttack);

		for (int i = 0; i < numDefender; i++) {
			resultDefense.add(dice.roll());
		}
		resultDefense.sort(new DefaultAttackComparator<Integer>());
		System.out.println("difesa: " + resultDefense);

	}

	private class DefaultAttackComparator<T> implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 > o2)
				return -1;
			if (o1 < o2)
				return 1;
			return 0;
		}
	}
}
