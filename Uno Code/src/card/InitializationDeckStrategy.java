package card;

import java.util.List;

public interface InitializationDeckStrategy {
    void initialize(List<Card> cards, CardFactory cardFactory);
}
