import fizzbuzz.kata.FizzBuzz
import fizzbuzz.kata.FizzBuzzCollector
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class FizzBuzzSpec extends Specification {

    def fizzBuzz = new FizzBuzz()

    def "result from collector should contain 3"() {
        setup:
        def collector = new FizzBuzzCollector(fizzBuzz)

        when:
        def result = collector.takeAll()

        then:
        result.contains("3")
    }


    def "should throw exception for #number"(number) {
        setup:

        given:

        when:
        fizzBuzz.calculate(number)

        then:
        thrown(IllegalArgumentException)

        where:
        number << [-1, 0, 101]
    }
}

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//def "should return #expected for #number"(number, expected) {
//    expect:
//    fizzBuzz.calculate(number) == expected
//
//    where:
//    number | expected
//    1      | "12"
//    3      | "Fizz"
//    5      | "Buzz"
//    15     | "FizzBuzz"
//}