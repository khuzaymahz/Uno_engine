package game.cardrules;

import card.*;
import player.PlayerRotationIterator;

public class CardRule {
    private static final CardPlayedRule numberedCardRule = new NumberedCardRule();
    private static final CardPlayedRule actionCardRule = new ActionCardRule();
    private static final CardPlayedRule wildCardRule = new WildCardRule();

    private CardRule() {
        throw new IllegalStateException("Utility class");
    }
    public static boolean isValidCardToPlay(Card topCard, Card playedCard) {
        if (playedCard instanceof NumberedCard) {
            return numberedCardRule.isValidCardToPlay(topCard, (NumberedCard) playedCard);
        } else if (playedCard instanceof ActionCard) {
            return actionCardRule.isValidCardToPlay(topCard, (ActionCard) playedCard);
        } else if (playedCard instanceof WildCard) {
            return wildCardRule.isValidCardToPlay(topCard, (WildCard) playedCard);
        }

        return false; // Invalid card type
    }
    public static void doRightAction(Card playedCard , CardDeck cardDeck, PlayerRotationIterator playerRotationIterator) {
        if (playedCard instanceof ActionCard) {
            actionCardRule.executeTheAction(playedCard , cardDeck,playerRotationIterator);
        } else if (playedCard instanceof WildCard) {
            wildCardRule.executeTheAction(playedCard , cardDeck,playerRotationIterator);
        }else if (playedCard instanceof NumberedCard) {
            numberedCardRule.executeTheAction(playedCard , cardDeck,playerRotationIterator);
        }

    }

}
