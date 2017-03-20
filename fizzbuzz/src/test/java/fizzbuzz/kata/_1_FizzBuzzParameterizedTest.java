package fizzbuzz.kata;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class _1_FizzBuzzParameterizedTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    @Parameters({"1", "2", "4", "7", "8", "23"})
    public void shouldReturnNumberFor(int input) {
        //when
        String output = fizzBuzz.calculate(input);
        //then
        assertEquals(String.valueOf(input), output);
    }


    @Test
    @Parameters({"3", "6", "9", "12", "36", "66"})
    public void shouldReturnFizzFor(int input) {
        //when
        String output = fizzBuzz.calculate(input);
        //then
        assertEquals("Fizz", output);
    }

    @Test
    @Parameters({"5", "10", "20", "100"})
    public void shouldReturnBuzzFor(int input) {
        //when
        String output = fizzBuzz.calculate(input);
        //then
        assertEquals("Buzz", output);
    }
}
