package PUD.ARENDA.dev;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RMDL.PUD.DKP.DKP;
import pages.RMDL.cartDoc.CartDocPage;
import pages.RMDL.placement.PlacementPage;
import pages.autorization.AutorizationPage;

public class Rent_POM {

    private WebDriver driver;
    private PlacementPage Placement;
    private pages.RMDL.PUD.DKP.DKP DKP;
    private AutorizationPage Auth;
    private CartDocPage CartDoc;

    @BeforeTest
    public void beforeTest() {
        driver = Browser.createDriver();
        DKP = new DKP(driver);
        Auth = new AutorizationPage(driver);
        Placement = new PlacementPage(driver);
        CartDoc = new CartDocPage(driver);
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void full_DKP(){
        Auth.login("RMDL", "Zazubenko", "ОРГАНИЗАЦИЯ 1181280564");
        Placement.rent("Auto");
        CartDoc.waitTaskFirst();

    }
}
