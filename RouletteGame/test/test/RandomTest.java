package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Betting.Bet;
import Betting.OddEvenBet;
import org.junit.jupiter.api.Test;
import roulette.Wheel;

public class RandomTest {

    @Test
    public void test_IsRandomWheelResultIntegerInRange()
    {
        // Wheel 객체는 spin() 시마다 랜덤한 정수를 뱉어야한다.
        // 그러므로 막대한 양의 반복과 함께 각 반복 시 마다 범위 내의 값 , Type 을 가지는지 확인하면 랜덤한 값에 대해서도 테스팅이 가능할 것이다.

        Wheel w = new Wheel();
        int res;

        for(int i=0;i<1000000000;i++)
        {
            w.spin();
            res = w.getNumber();
            assertTrue(Integer.class.isInstance(res));
            assertTrue(res>=1 || res<37);
        }
    }

}
