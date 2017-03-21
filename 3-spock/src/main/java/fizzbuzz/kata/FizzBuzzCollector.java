package fizzbuzz.kata;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class FizzBuzzCollector {
    private FizzBuzz fizzBuzz;

    public FizzBuzzCollector(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    public List<String> takeAll() {
        return IntStream.rangeClosed(1, 100)
                .mapToObj(fizzBuzz::calculate)
                .collect(toList());
    }
}
