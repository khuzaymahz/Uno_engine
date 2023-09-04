package card;

import java.util.List;


public class DefaultStrategy implements InitializationDeckStrategy {

    @Override
    public void initialize(List<Card> cards, CardFactory cardFactory) {
        createNumberedCards(cards, cardFactory);
        createActionCards(cards, cardFactory);
        createWildCards(cards, cardFactory);
    }

    private void createNumberedCards(List<Card> cards, CardFactory cardFactory) {
        for (var color : CardColor.values()) {
            cards.add(cardFactory.createCard(color, 0));

            for (var i = 1; i <= 9; i++) {
                cards.add(cardFactory.createCard(color, i));
                cards.add(cardFactory.createCard(color, i));
            }
        }
    }

    private void createActionCards(List<Card> cards, CardFactory cardFactory) {
        for (var color : CardColor.values()) {
            for (var i = 0; i < 2; i++) {
                try {
                    cards.add(cardFactory.createCard(CardType.SKIP, color));
                    cards.add(cardFactory.createCard(CardType.REVERSE, color));
                    cards.add(cardFactory.createCard(CardType.DRAW_TWO, color));
                } catch (IllegalArgumentException e) {
                    System.err.println("Exception occurred while creating action card: " + e.getMessage());
                }
            }
        }
    }

    private void createWildCards(List<Card> cards, CardFactory cardFactory) {
        for (var i = 0; i < 4; i++) {
            try {
                cards.add(cardFactory.createCard(CardType.WILD_COLOR, null));
                cards.add(cardFactory.createCard(CardType.WILD_DRAW_FOUR, null));
            } catch (IllegalArgumentException e) {
                System.err.println("Exception occurred while creating wild card: " + e.getMessage());
            }
        }
    }
}