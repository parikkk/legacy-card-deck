package cc.cards;

import java.util.List;

public interface CardCollection<T extends Card> extends BaseEntity {

    boolean addCard(T o);

    boolean addAllCards(List<T> o);

    void sort(List<T> tList);

    List<T> getCards();

    List<String> getNames();
}
