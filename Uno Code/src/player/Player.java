package player;

import card.*;

public class Player {
    private final String playerName;
    private HandCard handCards ;
    public Player(String name){
        this.playerName = name;
        this.handCards = new HandCard();

    }
    public String getName() {
        return playerName;
    }
    public void addToHandCards(Card card){
        handCards.addCard(card);
    }
    public boolean removePlayedCard(Card card) {
        return handCards.removeCard(card);
    }
    public boolean hasHandCard(Card card) {
        return this.handCards.hasCard(card);
    }

    public HandCard getHandCards() {
        return handCards;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player: ").append(playerName).append(", Hand Cards:\n");
        for (Card card : handCards.getCardStream().toList()) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }
}
