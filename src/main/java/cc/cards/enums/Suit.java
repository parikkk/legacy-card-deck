package cc.cards.enums;

public enum Suit {

    HEARTS("H", 0),
    CLUBS("C", 1),
    DIAMONDS("D", 2),
    SPADES("S", 3);

    private String suitName;
    private int suitValue;

    Suit(String suitName, int suitValue){
        this.suitName = suitName;
        this.suitValue = suitValue;
    }

    public static Suit valueOfName(String name){
        for(Suit suit : Suit.values()){
            if(suit.getSuitName().equals(name)){
                return suit;
            }
        }

        return null;
    }

    public int getSuitValue(){
        return suitValue;
    }

    public String getSuitName(){
        return suitName;
    }

}