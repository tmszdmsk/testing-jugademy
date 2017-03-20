package fizzbuzz.kata;


import com.carrotsearch.randomizedtesting.RandomizedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.carrotsearch.randomizedtesting.RandomizedTest.atLeast;
import static com.carrotsearch.randomizedtesting.RandomizedTest.atMost;
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomIntBetween;

@RunWith(RandomizedRunner.class)
public class _2_FizzBuzzRandomizedTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIf101() {
        //given
        int input = 101;
        //when
        fizzBuzz.calculate(input);
        //then
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIf0() {
        //given
        int input = 0;
        //when
        fizzBuzz.calculate(input);
        //then
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfLargerThan100() {
        //given
        int input = atLeast(101);
        //when
        fizzBuzz.calculate(input);
        //then
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfSmallerThan0() {
        //given
        int input = atMost(0);
        //when
        fizzBuzz.calculate(input);
        //then
    }

}
