import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

    ChromeDriver chromeDriver = new ChromeDriver();

    @Test
    public void shouldGoToSearchPageWhenSearchingForDumbledore() {
        //when
        chromeDriver.get("http://harrypotter.wikia.com");
        WebElement searchInput = chromeDriver.findElementById("searchInput");
        searchInput.sendKeys("Dumbledore");
        searchInput.submit();

        //then
        assertThat(chromeDriver.getCurrentUrl())
                .isEqualTo("http://harrypotter.wikia.com/wiki/Special:Search?query=Dumbledore");
    }

    @After
    public void killBrowser() {
        chromeDriver.quit();
    }
}
