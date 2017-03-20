package fizzbuzz.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    /**
     * Napisz algorytm, który dla liczb z zakresu <1, 100> zwróci liczbę na wejściu
     * lub napis Fizz jeśli liczba jest podzielna przez 3
     * lub napis Buzz jeśli liczba jest podzielna przez 5
     * lub napis FizzBuzz jeśli liczba jest podzielna przez 3 i przez 5
     * Dla liczb spoza zakresu, wyrzucony zostanie wyjątek IllegalArgumentException
     */

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void shouldReturn1For1() {
        //given
        int input = 1;
        //when
        String output = fizzBuzz.calculate(input);
        //then
        assertEquals("1", output);
    }

    @Test
    public void shouldReturnFizzFor3() {
        //given
        int input = 3;
        //when
        String output = fizzBuzz.calculate(input);
        //then
        assertEquals("Fizz", output);
    }

    @Test
    public void shouldReturnBuzzFor5() {
        //given
        int input = 5;
        //when
        String output = fizzBuzz.calculate(input);
        //then
        assertEquals("Buzz", output);
    }

    @Test
    public void shouldReturnFizzBuzzFor15() {
        //given
        int input = 15;
        //when
        String output = fizzBuzz.calculate(input);
        //then
        assertEquals("FizzBuzz", output);
    }
}
