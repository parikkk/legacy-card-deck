package cc.cards;

public interface Deck extends BaseEntity {
    <T extends CardCollection> T deal(int count);

    <T extends Card> T dealOne();
}
