package cc.cards.enums;

public enum Rank {

    TWO("2", 0, 0),
    THREE("3", 1, 0),
    FOUR("4", 2, 0),
    FIVE("5", 3, 0),
    SIX("6", 4, 0),
    SEVEN("7", 5, 0),
    EIGHT("8", 6, 0),
    NINE("9", 7, 0),
    JACK("J", 8, 2),
    QUEEN("Q", 9, 3),
    KING("K", 10, 4),
    TEN("10", 11, 10),
    ACE("A", 12, 11);

    private String rankName;
    private int rankPoint;
    private int rankPosition;

    Rank(String rankName, int rankPosition, int rankPoint){
        this.rankName = rankName;
        this.rankPosition = rankPosition;
        this.rankPoint = rankPoint;
    }

    public static Rank valueOfName(String name){
        for(Rank rank : Rank.values()){
            if(rank.getRankName().equals(name)){
                return rank;
            }
        }

        return null;
    }

    public String getRankName(){
        return rankName;
    }

    public int getRankPoint(){
        return rankPoint;
    }

    public int getRankPosition(){
        return rankPosition;
    }

}