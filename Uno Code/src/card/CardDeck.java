package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public  class CardDeck {
    private List<Card> cards;
    private CardFactory cardFactory;
    private InitializationDeckStrategy initializationDeckStrategy ;

    public CardDeck(InitializationDeckStrategy strategy ) {
        cards = new ArrayList<>() ;
        cardFactory = new CardFactory();
        initializationDeckStrategy = strategy;
        initializeDeck();
        shuffleDeck();
    }
    public CardDeck() {
        this(new DefaultStrategy());
    }


    private void initializeDeck() {
        initializationDeckStrategy.initialize(cards, cardFactory);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        throw new IllegalStateException("No cards left in the deck");
    }

    public int getDeckSize() {
        return cards.size();
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card card : cards) {
            stringBuilder.append(card.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
