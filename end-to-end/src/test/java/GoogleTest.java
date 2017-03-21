import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

  ChromeDriver chromeDriver = new ChromeDriver();

  @Test
  public void shouldLogin() {
    chromeDriver.get("http://community.wikia.com");

    WebElement myAccount = chromeDriver.findElement(By.className("wds-global-navigation__account-menu"));
    myAccount.click();
    WebElement singInButton = chromeDriver.findElement(By.id("global-navigation-anon-sign-in"));
    singInButton.click();

    System.out.println(chromeDriver.getWindowHandles());

    System.out.println(chromeDriver.getCurrentUrl());
  }

  @After
  public void killBrowser() {
    chromeDriver.quit();
  }
}
