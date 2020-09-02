package cc.cards;

import org.apache.commons.math3.random.MersenneTwister;

import java.util.ArrayDeque;
import java.util.List;

public class Deck extends ArrayDeque<String> {

    public Deck(int cardCount) {
        super();

        MersenneTwister twister = new MersenneTwister();

        CardPack cardPack = new CardPack( cardCount );

        for(int i = 0; i < cardCount; i++) {
            Integer number = Math.abs(twister.nextInt()) % cardPack.size();
            this.add(cardPack.getAndRemove(number));
        }
    }

    public Deck(List<String> cards){
        this.addAll(cards);
    }

    public String deal() {
        String card = this.pollFirst();
        return card;
    }

    public Card dealOne(){
        return new Card(deal());
    }

    public CardCollection deal(int count){

        CardCollection dealCards = new CardCollection();

        for(int i = 0; i < count; i++){
            dealCards.add(new Card(deal()));
        }

        return dealCards;
    }
}

