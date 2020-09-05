package cc.cards.impl;

import cc.cards.Card;
import cc.cards.CardCollection;
import cc.cards.CardPack;
import cc.cards.Deck;
import org.apache.commons.math3.random.MersenneTwister;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.logging.Logger;

public class DeckImpl implements Deck {
    private final Logger LOGGER = getLogger();
    private final Deque<String> deckDeque;

    public DeckImpl() {
        super();
        this.deckDeque = new ArrayDeque<String>();
    }

    public DeckImpl(int cardCount) {
        this();
        initDeque(cardCount);
    }

    public DeckImpl(List<String> cards) {
        this();
        this.deckDeque.addAll(cards);
    }

    /**
     * Get one card and remove this card from deck
     *
     * @return
     */
    @Override
    public Card dealOne() {
        LOGGER.info("Get and remove one card");

        return new CardImpl(deal());
    }

    /**
     * Get card collection and remove them from deck
     *
     * @param count cards count
     * @return dealCards
     */
    @Override
    public CardCollection deal(int count) {
        LOGGER.info("Get " + count + " cards  and remove them from pack");
        CardCollection dealCards = new CardCollectionImpl();
        for (int i = 0; i < count; i++) {
            dealCards.addCard(new CardImpl(deal()));
        }

        return dealCards;
    }

    /**
     * Initialize deck
     *
     * @param cardCount
     */
    private void initDeque(int cardCount) {
        LOGGER.info("Init deck");

        MersenneTwister twister = new MersenneTwister();
        CardPack cardPack = new CardPackImpl(cardCount);
        for (int i = 0; i < cardCount; i++) {
            Integer number = Math.abs(twister.nextInt()) % cardPack.getSize();
            this.deckDeque.add(cardPack.getCardByIndexAndRemove(number));
        }
    }

    /**
     * Get and remove first card from deck
     *
     * @return
     */
    private String deal() {
        LOGGER.info("Poll first card from deck");

        return this.deckDeque.pollFirst();
    }
}

