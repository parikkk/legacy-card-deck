package cc.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CardCollection extends ArrayList<Card> {

    public CardCollection(){

    }

    public CardCollection(Card card){
        this.add(card);
    }

    public CardCollection(List<String> cards){
        cards.forEach(card -> this.add(new Card(card)));
    }

    public CardCollection(Collection<String> cards){
        cards.forEach(card -> this.add(new Card(card)));
    }

    public List<String> getNames(){
        return getNames(false);
    }

    public List<String> getNames(boolean closed){

        List<String> names = new ArrayList<>();

        this.forEach(card -> names.add(closed ? "" : card.getName()));

        return names;

    }

    public void sort(Card trump){
        Collections.sort(this, new CardComparator(trump));
    }

    @Override
    public String toString(){

        String cardNames = this.stream()
                .map(Card::getName)
                .collect(Collectors.joining(", "));

        return cardNames;
    }
}
