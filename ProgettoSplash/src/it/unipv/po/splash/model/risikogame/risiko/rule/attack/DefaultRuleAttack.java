package it.unipv.po.splash.model.risikogame.risiko.rule.attack;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.board.Territory;
import it.unipv.po.splash.model.risikogame.move.attack.Attack;

public class DefaultRuleAttack implements IRuleAttack{

	public DefaultRuleAttack() {
		super();
		}

	@Override
	public void doAttacks(Player play) {
		Territory attack;
		Territory defence;
		int attackArmies;
		int defenceArmies;
		boolean repeat = true;
		double check;

		check = (double) play.getNumArmies() / (double) play.getEstates().size();
		repeat = play.askRepeatAttack();

		if (check > 1) {
			while(repeat) {

				System.out.println(play.getName() + " con quale territorio vuoi attacare?");
				attack = play.askTerritory();
				while((!play.hasTerritory(attack)) || attack.getNumArmies() <= 1) {
					System.out.println("Deve essere un tuo territorio e ci devono essere almeno due truppe");
					attack = play.askTerritory();
				}

				System.out.println(play.getName() + " quale territorio vuoi conquistare?");
				System.out.println(attack.getBorders());
				defence = play.askTerritory();
				while(!defence.isBordering(attack) || play.hasTerritory(defence)) {
					System.out.println("Il territorio deve essere confinante e non tuo");
					System.out.println(attack.getBorders());
					defence = play.askTerritory();
				}

				System.out.println(play.getName() + " con quante truppe vuoi attacare?");
				attackArmies = play.askArmies();
				while((attackArmies > 3) || (attackArmies > (attack.getNumArmies() - 1))) {
					System.out.println("Puoi usare al massimo tre truppe");
					attackArmies = play.askArmies();
				}

				System.out.println(defence.getOwner().getName() + " con quante truppe vuoi difendere?");
				defenceArmies = defence.getOwner().askArmies();
				while((defenceArmies > 3) || (defenceArmies > defence.getNumArmies())) {
					System.out.println("Puoi usare al massimo tre truppe");
					attackArmies = play.askArmies();
				}

				Attack a = new Attack(attackArmies, defenceArmies);
				a.changeTerritory(attack, defence);

				repeat = play.askRepeatAttack();
			}
		}
	}
}
