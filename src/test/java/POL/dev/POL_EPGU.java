package POL.dev;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.BasePage;
import pages.EGAIS.POL.Egais_POL_Page;
import pages.EGAIS.autorization.EGAIS_AutorizationPage;
import pages.RMDL.PUD.DKP.DKP;
import pages.RMDL.cartDoc.CartDocPage;
import pages.RMDL.placement.PlacementPage;
import pages.autorization.AutorizationPage;

import java.time.Duration;
import static browser.Config.EXPLICIT_WAIT;

public class POL_EPGU {

    private WebDriver driver;
    private BasePage Base;
    private EGAIS_AutorizationPage AuthEgais;
    private Egais_POL_Page EGAIS;
    private AutorizationPage Auth;
    private CartDocPage CartDoc;

    @BeforeTest
    public void beforeTest() {
        driver = Browser.createDriver();
        Auth = new AutorizationPage(driver);
        Base = new BasePage(driver);
        AuthEgais = new EGAIS_AutorizationPage(driver);
        EGAIS = new Egais_POL_Page(driver);
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void EPGU_POL(){
        Base.get("http://svcdev-beta.test.gosuslugi.ru/632762/1/form");
        AuthEgais.autorization("Orlova");
        EGAIS.POL(1,"in", "Архангельское");

    }
}
