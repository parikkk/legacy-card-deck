package cc.cards;

import cc.cards.enums.Rank;
import cc.cards.enums.Suit;

public interface Card<T> extends Comparable {

    String getName();

    int getValue();

    Rank getRank();

    Suit getSuit();

    boolean higherThan(T o);

    boolean lowerThan(T o);

    boolean equalsRank(T o);

    boolean equalsSuit(T o);
}
