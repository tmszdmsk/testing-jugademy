package fizzbuzz.kata.backup;

import fizzbuzz.kata.FizzBuzz;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.stream.IntStream;

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

    public Object[] multiplesOf3ButNot5() {
        return IntStream.rangeClosed(1, 100)
                .filter(i -> i % 3 == 0)
                .filter(i -> i % 5 != 0)
                .mapToObj(Integer::valueOf)
                .toArray();
    }

    @Test
    @Parameters(method = "multiplesOf3ButNot5")
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

    @Test
    @Parameters({"15", "30", "45", "60", "75", "90"})
    public void shouldReturnFizzBuzzFor(int input) {
        //when
        String output = fizzBuzz.calculate(input);
        //then
        assertEquals("FizzBuzz", output);
    }
}
