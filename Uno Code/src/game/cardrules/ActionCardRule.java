package game.cardrules;

import card.Card;
import card.CardDeck;
import card.CardType;
import player.Player;
import player.PlayerRotationIterator;

public class ActionCardRule implements CardPlayedRule{
    @Override
    public boolean isValidCardToPlay(Card topCard, Card playedCard) {
            if (isSameColor(topCard, playedCard)) {
                return true;
            }

            return topCard.getType() == playedCard.getType();
        }

    public void executeTheAction(Card playedCard, CardDeck cardDeck, PlayerRotationIterator playerRotationIterator)
            throws UnsupportedOperationException {
        Player nextPlayer = playerRotationIterator.nextPlayer();

        switch (playedCard.getType()) {
            case DRAW_TWO:
                nextPlayer.addToHandCards(cardDeck.drawCard());
                nextPlayer.addToHandCards(cardDeck.drawCard());
                System.out.println(nextPlayer.getName() + " has drawn two cards.");
                break;
            case SKIP:
                playerRotationIterator.nextPlayer();
                System.out.println("The next player has been skipped.");
                break;
            case REVERSE:
                playerRotationIterator.reverseDirection();
                playerRotationIterator.nextPlayer();
                System.out.println("The direction has been reversed, and the next player is " + nextPlayer.getName());
                break;
            default:
                throw new UnsupportedOperationException("Invalid card type for execution.");
        }
    }

    private boolean isSameColor(Card topCard, Card playedCard) {
            return topCard.getColor() == playedCard.getColor();
        }


    }

