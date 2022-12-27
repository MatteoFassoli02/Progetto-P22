package it.unipv.po.splash.model.risikogame.components.deck;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.deck.card.AbstractCard;

public class Deck {
	private ArrayList<AbstractCard> cards;

	public Deck() {
		cards = new ArrayList<AbstractCard>();
	}

	public void drawCard(Player player) {
		cards.get(cards.size()-1).setOwner(player);
		player.addCard(cards.get(cards.size() - 1));
		removeCard(cards.get(cards.size() - 1));
	}

	public void addCard(AbstractCard card) {
		cards.add(card);
	}

	public void removeCard(AbstractCard card) {
		cards.remove(card);
	}

	public ArrayList<AbstractCard> getCards() {
		return cards;
	}

	public void setCards(ArrayList<AbstractCard> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		String result = "";
		for(AbstractCard c : cards) {
			result += c.toString() + "\n";
		}
		return result;
	}
	
	

}
