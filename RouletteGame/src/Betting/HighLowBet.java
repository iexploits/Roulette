package Betting;

import Utils.ConsoleReader;
import roulette.Wheel;

import java.util.Set;

public class HighLowBet extends Bet {
    private String myChoice;

    public HighLowBet ()
    {
        this("High or Low", 1);
    }

    public HighLowBet (String description, int payout)
    {
        super(description, payout);
    }

    @Override
    public void place ()
    {
        myChoice = ConsoleReader.promptOneOf("Please bet", Set.of("high", "low"));
    }

    @Override
    public boolean isMade (int number, String Color)
    {
        int half = (Wheel.MAX + 1) / 2;
        // 1~ 절반 or 절반 ~ MAX 인지에 따라 결과 반환
        return (1 <= number && number < half && myChoice.equals("low")) ||
                (half <= number && number <= Wheel.MAX && myChoice.equals("high"));
    }
}
