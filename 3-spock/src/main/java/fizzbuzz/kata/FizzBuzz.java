package fizzbuzz.kata;

public class FizzBuzz {
    public String calculate(int input) {
        if (input > 100 || input < 1) {
            throw new IllegalArgumentException();
        }
        if ((input % 15) == 0) {
            return "FizzBuzz";
        } else if ((input % 3) == 0) {
            return "Fizz";
        } else if ((input % 5) == 0) {
            return "Buzz";
        } else {
            return Integer.toString(input);
        }
    }
}
