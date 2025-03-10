package PUD.DKP.dev;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.PUD.DKP;
import pages.autorization.Autorization;

import java.time.Duration;
import static browser.Config.EXPLICIT_WAIT;

public class DKP_POM {

    private WebDriver driver;
    private DKP DKP;
    private Autorization Auth;

    @BeforeTest
    public void beforeTest() {
        driver = Browser.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EXPLICIT_WAIT));
        DKP = new DKP(driver);
        Auth = new Autorization(driver);
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void full_DKP(){
        Auth.login("LKL", "Orlova");

    }
}
