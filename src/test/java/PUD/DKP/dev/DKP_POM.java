package PUD.DKP.dev;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.RMDL.PUD.DKP.DKP;
import pages.RMDL.placement.PlacementPage;
import pages.autorization.AutorizationPage;

import java.time.Duration;
import static browser.Config.EXPLICIT_WAIT;

public class DKP_POM {

    private WebDriver driver;
    private PlacementPage Placement;
    private DKP DKP;
    private AutorizationPage Auth;

    @BeforeTest
    public void beforeTest() {
        driver = Browser.createDriver();
        DKP = new DKP(driver);
        Auth = new AutorizationPage(driver);
        Placement = new PlacementPage(driver);
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void full_DKP(){
        Auth.login("RMDL", "Zazubenko");
        Placement.DKP("Auto");

    }
}
