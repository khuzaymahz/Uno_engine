package game.cardrules;

import card.*;
import player.Player;
import player.PlayerRotationIterator;

import java.util.Scanner;

public class WildCardRule implements CardPlayedRule{
    @Override
    public boolean isValidCardToPlay(Card topCard, Card playedCard) {
            return (playedCard).getColor() == null;

    }
    public void executeTheAction(Card playedCard, CardDeck cardDeck, PlayerRotationIterator playerRotationIterator) {
        Player nextPlayer = playerRotationIterator.nextPlayer();
        WildCard wildCard = (WildCard) playedCard;

        switch (playedCard.getType()) {
            case WILD_COLOR:
                handleWildColorCard(nextPlayer, wildCard);
                break;
            case WILD_DRAW_FOUR:
                handleWildDrawFourCard(nextPlayer, cardDeck, wildCard);
                break;
            default:
                throw new UnsupportedOperationException("Invalid card type for execution.");
        }
    }

    private void handleWildColorCard(Player nextPlayer, WildCard wildCard) {
        wildCard.chooseColor(promptForColorSelection());
    }

    private void handleWildDrawFourCard(Player nextPlayer, CardDeck cardDeck, WildCard wildCard) {
        nextPlayer.addToHandCards(cardDeck.drawCard());
        nextPlayer.addToHandCards(cardDeck.drawCard());
        nextPlayer.addToHandCards(cardDeck.drawCard());
        nextPlayer.addToHandCards(cardDeck.drawCard());
        System.out.println(nextPlayer.getName() + " drew four cards!");

        wildCard.chooseColor(promptForColorSelection());
    }

    private CardColor promptForColorSelection() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the color you want to choose (RED, BLUE, GREEN, YELLOW): ");
            String input = scanner.nextLine().trim().toUpperCase();

            try {
                CardColor color = CardColor.valueOf(input);
                return color;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid color. Please enter a valid color.");
            }
        }
    }
}
