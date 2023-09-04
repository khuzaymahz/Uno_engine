package card;

public class CardFactory {
    public static Card createCard(CardType type, CardColor color) {
    switch (type) {
        case SKIP:
        case REVERSE:
        case DRAW_TWO:
            return new ActionCard(type, color);
        case WILD_COLOR:
        case WILD_DRAW_FOUR:
            return new WildCard(type);
        default:
            throw new IllegalArgumentException("Invalid card type: " + type);
    }
}
    public static Card createCard(CardColor color, int value) {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("Invalid card value: " + value);
        }
        return new NumberedCard(color, value);
    }
}