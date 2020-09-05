package cc.cards.impl;

import cc.cards.BaseEntity;
import cc.cards.Card;
import cc.cards.CardCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CardCollectionImpl implements CardCollection<Card>, BaseEntity {

    private final Logger LOGGER = getLogger();
    private final List<Card> cards;

    public CardCollectionImpl() {
        super();
        this.cards = new ArrayList<>();
    }

    public CardCollectionImpl(Card card) {
        this();
        this.cards.add(card);
    }

    public CardCollectionImpl(List<Card> cards) {
        super();
        this.cards = cards;
    }

    public CardCollectionImpl(Collection<String> cards) {
        super();
        this.cards = cards.stream().map(s -> new CardImpl(s)).collect(Collectors.toList());
    }

    /**
     * Get list of cards
     *
     * @return
     */
    @Override
    public List<Card> getCards() {
        LOGGER.info("Get cards list");

        return cards;
    }

    /**
     * Get list of cards names
     *
     * @return List<String>
     */
    @Override
    public List<String> getNames() {
        LOGGER.info("Get list of cards names");

        return getNames(false);
    }

    /**
     * Sorting list of cards
     *
     * @param cardList list of cards for sort
     */
    @Override
    public void sort(List<Card> cardList) {
        LOGGER.info("Sort list of cards");

        Collections.sort(cardList, (o1, o2) -> o1.compareTo(o2));
    }

    /**
     * Add card to list
     *
     * @param card to add
     * @return boolean
     */
    @Override
    public boolean addCard(Card card) {
        LOGGER.info("Add card");

        return this.getCards().add(card);
    }

    /**
     * Add list of cards to this card collection
     *
     * @param cards to add
     * @return boolean
     */
    @Override
    public boolean addAllCards(List<Card> cards) {
        LOGGER.info("Add list of cards");

        return this.getCards().addAll(cards);
    }

    private List<String> getNames(boolean closed) {
        LOGGER.info("Get list of card names ");

        return this.cards.stream()
                .map(card -> {
                    return closed ? "" : card.getName();
                }).collect(Collectors.toList());
    }
}
