package cc.cards.impl;

import cc.cards.BaseEntity;
import cc.cards.Card;
import cc.cards.enums.Rank;
import cc.cards.enums.Suit;

import java.util.Objects;
import java.util.logging.Logger;

public class CardImpl implements Card<Card>, BaseEntity {
    private final Logger LOGGER = getLogger();

    private final Suit suit;
    private final Rank rank;

    public CardImpl(final Suit suit, final Rank rank) {
        super();
        this.suit = suit;
        this.rank = rank;
    }

    public CardImpl(String name) {
        super();
        this.suit = Suit.valueOfName(name.substring(0, 1));
        this.rank = Rank.valueOfName(name.substring(1, name.length()));
    }

    @Override
    public String getName() {
        LOGGER.info("Get name");

        return suit.getSuitName() + rank.getRankName();
    }

    @Override
    public int getValue() {
        LOGGER.info("Get value");

        return rank.getRankPoint();
    }

    @Override
    public Rank getRank() {
        LOGGER.info("Get rank");

        return rank;
    }

    @Override
    public Suit getSuit() {
        LOGGER.info("Get suit");

        return suit;
    }

    @Override
    public boolean equalsRank(Card card) {
        LOGGER.info("Equals Rank ");

        return this.rank.equals(card.getRank());
    }

    @Override
    public boolean equalsSuit(Card card) {
        LOGGER.info("Equals Suit ");

        return this.suit.equals(card.getSuit());
    }

    @Override
    public boolean higherThan(Card card) {
        LOGGER.info("Lower than ");

        return this.getRank().getRankPosition() > card.getRank().getRankPosition();
    }

    @Override
    public boolean lowerThan(Card card) {
        LOGGER.info("Lower than ");

        return this.getRank().getRankPosition() < card.getRank().getRankPosition();
    }

    @Override
    public int compareTo(Object card) {
        LOGGER.info("Card compare to Object : ");

        return this.compareTo((Card) card);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;

        return suit == card.getSuit() && rank == card.getRank();
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }

    /**
     * Compare cards
     *
     * @param card Card for compare
     * @return
     */
    private int compareTo(Card card) {
        LOGGER.info("Compare to card : " + card.toString());
        //compare suit
        if (this.getSuit().getSuitValue() < card.getSuit().getSuitValue()) {
            return -1;
        } else if (this.getSuit().getSuitValue() > card.getSuit().getSuitValue()) {
            return 1;
        } else {
            // suit is identical: compare rank position
            if (this.getRank().getRankPosition() < card.getRank().getRankPosition()) {
                return -1;
            } else if (this.getRank().getRankPosition() > card.getRank().getRankPosition()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

