package cc.cards;

import java.util.Comparator;

public class Card{

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Card(String name){
        this.suit = Suit.valueOfName(name.substring(0, 1));
        this.rank = Rank.valueOfName(name.substring(1, name.length()));
    }

    public String getName(){
        return suit.getSuitName()+rank.getRankName();
    }

    public int getValue(){
        return rank.getRankPoint();
    }

    public Rank getRank(){
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean equalsRank(Card card){
        return this.rank.equals(card.getRank());
    }

    public boolean equalsSuit(Card card) { return this.suit.equals(card.getSuit()); }

    public boolean higherThan(Card card){
        return getRank().getRankPosition() > card.getRank().getRankPosition();
    }

    public boolean lowerThan(Card card){
        return getRank().getRankPosition() < card.getRank().getRankPosition();
    }

    @Override
    public boolean equals(Object o){

        if( !(o instanceof Card) )
            return false;

        return getName().equals(((Card)o).getName());
    }
}

class CardComparator implements Comparator<Card> {

    private Card trump;

    public CardComparator(Card trump) {
        this.trump = trump;
    }

    @Override
    public int compare(Card card1, Card card2) {

        if(card1.equalsSuit(card2)){
            if(card1.getRank().getRankPosition() < card2.getRank().getRankPosition()){
                return -1;
            }

            return 1;
        }

        if(card1.equalsSuit(trump)){
           return 1;
        }

        if(card2.equalsSuit(trump)){
            return -1;
        }

        if(card1.getSuit().getSuitValue() < card2.getSuit().getSuitValue()){
            return -1;
        }

        return 1;
    }
}