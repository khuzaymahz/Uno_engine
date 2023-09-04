package card;

import java.util.Objects;

public class NumberedCard implements Card {
    private final CardType TYPE = CardType.NUMBER;
    private final CardColor COLOR;
    private final int VALUE;

    protected NumberedCard(CardColor color, int value ) {
        CardValidator.validateColor(color);
        CardValidator.validateNumber(value);
        this.COLOR = color;
        this.VALUE = value;

    }

    public int getValue() {
        return VALUE;
    }
    @Override
    public CardColor getColor() {
        return COLOR;
    }
    public CardType getType() {
        return TYPE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberedCard that = (NumberedCard) o;
        return VALUE == that.VALUE && getColor() == that.getColor();
    }
    @Override
    public int hashCode() {
        return Objects.hash(VALUE, getColor());
    }

    @Override
    public String toString() {
        return "NumberCard :" +
                VALUE + ", " + getColor() ;
    }
}
