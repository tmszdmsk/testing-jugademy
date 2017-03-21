package fizzbuzz.kata.backup;

import fizzbuzz.kata.FizzBuzz;
import fizzbuzz.kata.FizzBuzzCollector;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class _3_FizzBuzzCollectorTest {

/*
 +-------------------+         +----------+
 |                   |         |          |
 | FizzBuzzCollector | +-----> | FizzBuzz |
 |                   |         |          |
 +-------------------+         +----------+

                              +------------+
 @Spy                         |FizzBuzzSpy||
 +-------------------+        +------------|
 |                   |        ||          ||
 | FizzBuzzCollector | +----->-| FizzBuzz ||
 |                   |        ||          ||
 +-------------------+        |------------|
                              +------------+

 @Mock
 +-------------------+         +--------------+
 |                   |         |              |
 | FizzBuzzCollector | +-----> | FizzBuzzMock |
 |                   |         |              |
 +-----------------+-+         +-----+--------+

*/

    @Spy
    FizzBuzz fizzBuzzSpy;
    @Mock
    FizzBuzz fizzBuzzMock;

    @Test
    public void shouldReturn100Elements() {
        //given
        FizzBuzzCollector iterator = new FizzBuzzCollector(fizzBuzzSpy);

        //when
        List<String> result = iterator.takeAll();

        //then
        Assert.assertEquals(100, result.size());
    }

    @Test
    public void shouldCallFizzBuzz100Times() {
        //given
        FizzBuzzCollector collector = new FizzBuzzCollector(fizzBuzzSpy);

        //when
        collector.takeAll();

        //then
        Mockito.verify(fizzBuzzSpy, times(100))
                .calculate(anyInt());
    }

    @Test
    public void shouldReturnAllStringsFromFizzBuzz() {
        String constantValue = "constantValue";
        when(fizzBuzzMock.calculate(anyInt())).thenReturn(constantValue);

        //given
        FizzBuzzCollector collector = new FizzBuzzCollector(fizzBuzzMock);

        //when
        List<String> result = collector.takeAll();

        //then
        assertThat(result)
                .hasSize(100)
                .containsOnlyElementsOf(Arrays.asList(constantValue));
    }
}
