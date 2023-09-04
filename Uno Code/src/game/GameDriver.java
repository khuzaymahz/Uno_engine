package game;

import player.HandCard;
import player.Player;

import java.util.Scanner;
public class GameDriver {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        UnoGame unoGame = new UnoGame(new Player[]{player1, player2});
        unoGame.play();

    }
}