package game.cardrules;

import card.*;
import player.Player;
import player.PlayerRotationIterator;


public interface CardPlayedRule {
    boolean isValidCardToPlay(Card topCard, Card playedCard);
    void executeTheAction(Card playedCard, CardDeck cardDeck, PlayerRotationIterator playerRotationIterator);
}
