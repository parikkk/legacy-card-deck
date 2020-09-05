package cc.cards.impl;

import cc.cards.CardCollection;
import cc.cards.CardPack;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardPackImpl implements CardPack {

    private final static Integer CARD_PACK_COUNT_36 = 36;
    private final static Integer CARD_PACK_COUNT_20 = 20;
    private final Logger LOGGER = getLogger();


    private final List<String> cards20 = Arrays.asList("H10", "HJ", "HQ", "HK", "HA", "C10", "CJ", "CQ", "CK", "CA", "D10", "DJ", "DQ", "DK", "DA", "S10", "SJ", "SQ", "SA");
    private final List<String> cards4 = Arrays.asList("H6", "H7", "H8", "H9", "C6", "C7", "C8", "C9", "D6", "D7", "D8", "D9", "S6", "S7", "S8", "S9");
    private final List<String> cards36 = Stream.of(cards4, cards20).flatMap(Collection::stream).collect(Collectors.toList());


    private final int cardCount;
    private final CardCollection cardCollection;

    public CardPackImpl() {
        super();
        this.cardCount = CARD_PACK_COUNT_36;
        this.cardCollection = new CardCollectionImpl();
        initCards();
    }

    public CardPackImpl(int cardCount) {
        super();
        this.cardCount = cardCount;
        this.cardCollection = new CardCollectionImpl();
        initCards();
    }

    /**
     * Get card count
     *
     * @return int
     */
    @Override
    public int getSize() {
        LOGGER.info("return current size of card pack");

        return this.cardCount;
    }

    /**
     * Get collection of cards
     *
     * @return cardCollection
     */
    @Override
    public CardCollection getCardCollection() {
        LOGGER.info("Get Card Collection");

        return this.cardCollection;
    }

    /**
     * Get and remove card by index
     *
     * @param index of card in collection for remove
     * @return
     */
    @Override
    public String getCardByIndexAndRemove(int index) {
        LOGGER.info("Get and remove card by index " + index);

        return this.cardCollection.getCards().remove(index).toString();
    }

    /**
     * Initialize Card Pack of size 20
     */
    private void initCardsPackOfSize20() {
        LOGGER.info("Initialize cards pack of size 20");

        cardCollection.addAllCards(cards20.stream().map(s -> new CardImpl(s)).collect(Collectors.toList()));
    }

    /**
     * Initialize Card Pack of size 36
     */
    private void initCardsPackOfSize36() {
        LOGGER.info("Initialize cards pack of size 36");

        cardCollection.addAllCards(cards36.stream().map(s -> new CardImpl(s)).collect(Collectors.toList()));
    }

    /**
     * Initialize cards pack of default size
     */
    private void initCards() {
        LOGGER.info("Initialize cards pack of default size ");

        if (this.cardCount == CARD_PACK_COUNT_20) {
            this.initCardsPackOfSize20();
        }
        this.initCardsPackOfSize36();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardPackImpl)) return false;
        CardPackImpl cardPack = (CardPackImpl) o;
        return cardCount == cardPack.cardCount &&
                getCardCollection().equals(cardPack.getCardCollection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardCount, getCardCollection());
    }
}
