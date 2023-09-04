package score;

import player.Player;

public interface ScoringStrategy {
    int calculateScore(Player player);
}
