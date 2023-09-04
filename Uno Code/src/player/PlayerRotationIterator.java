package player;

import java.util.Arrays;
import java.util.stream.Stream;

public class PlayerRotationIterator {
    private final Player[] players;
    private int currentPlayer = 0;
    private Direction direction = Direction.CLOCKWISE;

    public PlayerRotationIterator(Player[] players) {
        this.players = players;
    }

    public Stream<Player> stream() {
        return Arrays.stream(players);
    }

    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    public void reverseDirection() {
        direction = Direction.COUNTER_CLOCK_WISE;
    }

    public Player nextPlayer() {
        currentPlayer = getNextIndex();
        return getCurrentPlayer();

    }
    //Calculates the index of the next player in the rotation.
    private int getNextIndex() {
        int increment = (direction == Direction.CLOCKWISE) ? 1 : -1;
        int newIndex = (players.length + currentPlayer + increment) % players.length;
        return newIndex;
    }
}