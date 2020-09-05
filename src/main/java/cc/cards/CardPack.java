package cc.cards;

public interface CardPack extends BaseEntity {

    int getSize();

    <T extends CardCollection> T getCardCollection();

    String getCardByIndexAndRemove(int index);
}
