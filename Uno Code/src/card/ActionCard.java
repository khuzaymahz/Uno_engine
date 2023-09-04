package card;

import java.util.Objects;

public class ActionCard implements Card{
    private final CardType TYPE ;
    private final CardColor COLOR;

    protected ActionCard(CardType type, CardColor color ) {
        CardValidator.validateActionType(type);
        CardValidator.validateColor(color);
        this.TYPE = type;
        this.COLOR = color;


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
        ActionCard that = (ActionCard) o;
        return getType() == that.getType() && getColor() == that.getColor();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getType(), getColor());
    }

    @Override
    public String toString() {
        return "ActionCard :" +
                getType() + ", " + getColor() ;
    }
}
