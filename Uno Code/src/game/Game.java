package game;

import card.Card;
import card.CardDeck;
import card.NumberedCard;
import player.Player;
import player.PlayerRotationIterator;

public abstract class Game {
    protected PlayerRotationIterator playerRotationIterator;
    protected CardDeck cardDeck;
    protected CardPile cardPile;
    protected boolean gameWon;
    public abstract void initialize();
    public abstract void play();
    public abstract void finish();
    protected void dealInitialCards() {
        int numInitialCards = 5; // Number of initial cards to deal

        for (int i = 0; i < numInitialCards; i++) {
            for (Player player : playerRotationIterator.stream().toList()) {
                Card card = cardDeck.drawCard();
                player.addToHandCards(card);
            }
        }
    }
    protected Card drawStartingCard() {
        Card card = cardDeck.drawCard();
        while (!(card instanceof NumberedCard)) {
            cardDeck.addCard(card);
            cardDeck.shuffleDeck();
            card = cardDeck.drawCard();
        }
        return card;
    }
}