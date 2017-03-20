package fizzbuzz.kata;

public class FizzBuzz {
    public String calculate(int input) {
        if(input==3){
            return "Fizz";
        } else if(input==5){
            return "Buzz";
        } else if(input==15){
            return "FizzBuzz";
        }
        return ""+input;

    }
}
