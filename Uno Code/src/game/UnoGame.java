package game;

import card.*;
import game.cardrules.*;
import player.Player;
import player.PlayerRotationIterator;

import java.util.Scanner;

class UnoGame extends Game {

    public UnoGame(Player[] players) {
        this.playerRotationIterator = new PlayerRotationIterator(players);
        this.cardDeck = new CardDeck();
        this.cardPile = new CardPile();
        this.gameWon = false;
    }

    @Override
    public void initialize() {
        dealInitialCards();
        Card startingCard = drawStartingCard();
        cardPile.addCard(startingCard);
    }

    @Override
    public void play() {
        initialize();

        Scanner scanner = new Scanner(System.in);
        int drawTimes = 0;

        while (!gameWon) {
            Player currentPlayer = playerRotationIterator.getCurrentPlayer();
            System.out.println("\nCurrent player: " + currentPlayer.getName());
            System.out.println("Current card: " + cardPile.getTopCard());
            System.out.println(currentPlayer.getName() + "'s hand cards: " + currentPlayer.getHandCards());

            if (hasValidCardToPlay(currentPlayer)) {
                Card playedCard = getValidCardToPlay(scanner, currentPlayer);
                currentPlayer.removePlayedCard(playedCard);
                cardPile.addCard(playedCard);
                CardRule.doRightAction(playedCard, cardDeck, playerRotationIterator);

                if (currentPlayer.getHandCards().size() == 0) {
                    gameWon = true;
                    System.out.println(currentPlayer.getName() + " has won the game!");
                }
            } else {
                handleNoValidCardToPlay(drawTimes, currentPlayer);
                drawTimes = (drawTimes + 1) % 2;
            }
        }

        finish();
    }

    @Override
    public void finish() {
        System.out.println("Game finished. Thank you for playing Uno!");
    }

    private boolean hasValidCardToPlay(Player player) {
        return player.getHandCards().getCardStream().anyMatch(card -> CardRule.isValidCardToPlay(cardPile.getTopCard(), card));
    }

    private Card getValidCardToPlay(Scanner scanner, Player currentPlayer) {
        while (true) {
            System.out.print("Enter the card you want to play: ");
            String input = scanner.nextLine();

            Card playedCard = currentPlayer.getHandCards().getCardStream()
                    .filter(card -> card.toString().equalsIgnoreCase(input))
                    .findFirst()
                    .orElse(null);

            if (playedCard != null && CardRule.isValidCardToPlay(cardPile.getTopCard(), playedCard)) {
                System.out.println(currentPlayer.getName() + " played " + playedCard);
                return playedCard;
            }

            System.out.println("Invalid card. Please try again.");
        }
    }

    private void handleNoValidCardToPlay(int drawTimes, Player currentPlayer) {
        System.out.println(currentPlayer.getName() + " does not have a playable card.");

        if (drawTimes == 0) {
            System.out.println("Drawing a card.");
            Card drawnCard = cardDeck.drawCard();
            currentPlayer.addToHandCards(drawnCard);
        } else {
            playerRotationIterator.nextPlayer();
        }
    }




}