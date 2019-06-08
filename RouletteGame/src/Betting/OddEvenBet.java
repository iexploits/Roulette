package Betting;

import Utils.ConsoleReader;

import java.util.Set;

public class OddEvenBet extends Bet{
    private String myChoice;


    public OddEvenBet()
    {
        this("Odd or Even", 1);
    }

    public OddEvenBet (String description, int payout)
    {
        super(description, payout);
    }

    @Override
    public void place ()
    {
        myChoice = ConsoleReader.promptOneOf("Please bet", Set.of("even", "odd"));
    }

    @Override
    public boolean isMade (int number, String color)
    {
        return (number % 2 == 0 && myChoice.equals("even")) ||
                (number % 2 == 1 && myChoice.equals("odd"));
    }
}
