package Betting;

public abstract class Bet {

    private String myDescription;
    private int myPayout;

    public Bet(String description, int payout) {
        myDescription = description;
        myPayout = payout;
    }

    public int getPayout() { return myPayout; }

    public String getDescription() { return myDescription; }

    public abstract void place ();

    public abstract boolean isMade (int whichBet, String betChoice);
}

