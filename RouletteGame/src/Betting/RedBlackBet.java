package Betting;

import Utils.ConsoleReader;
import roulette.Wheel;

import java.util.Set;

public class RedBlackBet extends Bet {

    private String myChoice;


    public RedBlackBet ()
    {
        this("Red or Black", 1);
    }

    public RedBlackBet (String description, int payout)
    {
        super(description, payout);
    }

    @Override
    public void place ()
    {
        myChoice = ConsoleReader.promptOneOf("Please bet", Set.of(Wheel.BLACK, Wheel.RED));
    }

    @Override
    public boolean isMade (int number, String color)
    {
        return color.equals(myChoice);
    }
}
