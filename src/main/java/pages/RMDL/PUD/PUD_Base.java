package pages.RMDL.PUD;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class PUD_Base extends BasePage {
    public PUD_Base(WebDriver driver) {
        super(driver);
    }


    public void findModal(String type, String value){
        switch (type){
            case "inn":
                send("//*[@id=\":r3d:\"]", value);
                click("/html/body/div[3]/div[3]/div/div[1]/form/div/div[2]/button");
                timeOut(2000);
                click("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/div/div/div[1]/span");
                timeOut(1000);
                click("/html/body/div[3]/div[3]/div/div[2]/div/button[2]");
                timeOut(1000);
                break;
            case "name":
                send("//*[@id=\":r3e:\"]", value);
                click("/html/body/div[3]/div[3]/div/div[1]/form/div/div[2]/button");
                timeOut(2000);
                click("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div[2]/div/div/div/div/div[1]/span");
                timeOut(1000);
                click("/html/body/div[3]/div[3]/div/div[2]/div/button[2]");
                timeOut(1000);
                break;
        }
    }


}
