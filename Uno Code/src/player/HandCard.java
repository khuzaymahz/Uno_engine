package player;

import card.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HandCard {
    private  List<Card> handCards = new ArrayList<>();

    public void addCard(Card newCard) {
        handCards.add(newCard);
    }
    public boolean removeCard(Card card) {
        Card cardToRemove;
        if (CardValidator.isWildCard(card)) {
            cardToRemove = findCardOfType(card.getType());
        } else {
            cardToRemove = card;
        }
        return handCards.remove(cardToRemove);
    }

    private Card findCardOfType(CardType type) {
        for (var card : handCards) {
            if (card.getType() == type) {
                return card;
            }
        }
        return null;
    }

    public Stream<Card> getCardStream() {
        return handCards.stream();
    }

    public boolean hasCard(Card card) {
        if (CardValidator.isWildCard(card)) {
            return getCardStream().anyMatch(c -> c.getType() == card.getType());
        } else {
            return getCardStream().anyMatch(c -> c.equals(card));
        }
    }

    public int size() {
        return handCards.size();
    }
    public String toString() {
        return handCards.toString();
    }
}
