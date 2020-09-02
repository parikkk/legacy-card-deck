package cc.cards;

import java.util.ArrayList;

public class CardPack extends ArrayList<String> {

    private int cardCount;

    public CardPack(int cardCount){
        super();

        if(cardCount == 20){
            initCards20();
        } else if(cardCount == 36){
            initCards36();
        }
    }

    private void initCards20(){

        this.add("H10");
        this.add("HJ");
        this.add("HQ");
        this.add("HK");
        this.add("HA");

        this.add("C10");
        this.add("CJ");
        this.add("CQ");
        this.add("CK");
        this.add("CA");

        this.add("D10");
        this.add("DJ");
        this.add("DQ");
        this.add("DK");
        this.add("DA");

        this.add("S10");
        this.add("SJ");
        this.add("SQ");
        this.add("SK");
        this.add("SA");
    }

    private void initCards36(){

        this.add("H6");
        this.add("H7");
        this.add("H8");
        this.add("H9");
        this.add("H10");
        this.add("HJ");
        this.add("HQ");
        this.add("HK");
        this.add("HA");

        this.add("C6");
        this.add("C7");
        this.add("C8");
        this.add("C9");
        this.add("C10");
        this.add("CJ");
        this.add("CQ");
        this.add("CK");
        this.add("CA");

        this.add("D6");
        this.add("D7");
        this.add("D8");
        this.add("D9");
        this.add("D10");
        this.add("DJ");
        this.add("DQ");
        this.add("DK");
        this.add("DA");

        this.add("S6");
        this.add("S7");
        this.add("S8");
        this.add("S9");
        this.add("S10");
        this.add("SJ");
        this.add("SQ");
        this.add("SK");
        this.add("SA");
    }

    public String getAndRemove(int index) {
        String card = this.get(index);

        this.remove(index);
        return card;
    }
}
