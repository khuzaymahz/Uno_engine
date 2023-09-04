package card;

import java.util.Objects;

public class WildCard implements Card {
    private final CardType TYPE ;
    private CardColor COLOR ;

    public WildCard(CardType type) {
        this.TYPE = type;
        this.COLOR = null;
    }
    public WildCard(CardType type, CardColor color) {
        CardValidator.validateColor(color);
        this.TYPE = type;
        this.COLOR = color;
    }
    public void chooseColor(CardColor color) {
        CardValidator.validateColor(color);
        this.COLOR = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WildCard wildCard = (WildCard) o;
        return getType() == wildCard.getType() && getColor() == wildCard.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getColor());
    }

    @Override
    public String toString() {
        return "WildCard :" +
                getType() + ", " + getColor() ;
    }
    @Override
    public CardType getType() {
        return TYPE;
    }

    @Override
    public CardColor getColor() {
        return COLOR;
    }

}
