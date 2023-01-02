package it.unipv.po.splash.model.risikogame.components.deck;

import java.util.ArrayList;

import it.unipv.po.splash.model.risikogame.Player;
import it.unipv.po.splash.model.risikogame.components.deck.card.TerritoryCard;

public class Deck {
	private ArrayList<TerritoryCard> cards;

	public Deck() {
		cards = new ArrayList<TerritoryCard>();
	}

	public void drawCard(Player player) {
		cards.get(cards.size()-1).setOwner(player);
		player.addCard(cards.get(cards.size() - 1));
		removeCard(cards.get(cards.size() - 1));
	}

	public void addCard(TerritoryCard card) {
		cards.add(card);
	}

	public void removeCard(TerritoryCard card) {
		cards.remove(card);
	}

	public ArrayList<TerritoryCard> getCards() {
		return cards;
	}

	public void setCards(ArrayList<TerritoryCard> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		String result = "";
		for(TerritoryCard c : cards) {
			result += c.toString() + "\n";
		}
		return result;
	}
	
	

}
