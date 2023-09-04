package game.cardrules;

import card.*;
import player.Player;
import player.PlayerRotationIterator;

public class NumberedCardRule implements CardPlayedRule{
    private boolean isSameColor(Card topCard, Card playedCard) {
        return topCard.getColor() == playedCard.getColor();
    }
    @Override
    public boolean isValidCardToPlay(Card topCard, Card playedCard) {
        if (isSameColor(topCard, playedCard)) {
            return true;
        }

        if (topCard.getType() == CardType.NUMBER) {
            return ((NumberedCard) topCard).getValue() == ((NumberedCard) playedCard).getValue();
        }

        return false;
    }
    public void executeTheAction(Card playedCard , CardDeck cardDeck, PlayerRotationIterator playerRotationIterator) {
        playerRotationIterator.nextPlayer();

    }
}
