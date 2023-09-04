package game;

import card.Card;
import java.util.Stack;

class CardPile {
    private Stack<Card> cards  = new Stack<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getTopCard() {
        return cards.peek();
    }

}