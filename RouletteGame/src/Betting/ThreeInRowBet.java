package Betting;

import Utils.ConsoleReader;
import roulette.Wheel;

public class ThreeInRowBet extends Bet{
    private int myStart;
    private int myRange;

    public ThreeInRowBet ()
    {
        this("Three in a Row", 11, 3);
    }

    public ThreeInRowBet (String description, int payout, int range)
    {
        super(description, payout);
        myRange = range;
    }

    @Override
    public void place ()
    {
        myStart = ConsoleReader.promptRange("Enter first of consecutive numbers",
                1, Wheel.MAX - myRange);
    }

    @Override
    public boolean isMade (int number, String color)
    {
        return (myStart <= number && number < myStart + myRange);
    }
}
