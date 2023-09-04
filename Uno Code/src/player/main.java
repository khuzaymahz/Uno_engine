package player;


import card.Card;
import card.CardDeck;

public class main {
    public static void main(String[] args) {
        HandCard cards = new HandCard() ;
        CardDeck cardDeck = new CardDeck();
        cards.addCard(cardDeck.drawCard());
        Player p = new Player("Ahmad");
        PlayerRotationIterator zz = new PlayerRotationIterator(new Player[]{p});
//        for (Card c : p.getCardStream()) {
//            System.out.printf(c);
//        }
    }
}
