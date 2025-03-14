package pages.EGAIS.autorization;

import dataSet.autorization.DataAutoriz;
import dataSet.autorization.DataUsers;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static pages.EGAIS.autorization.xEGAIS_Autorization_Dirt.*;

public class EGAIS_AutorizationPage extends BasePage {

    public EGAIS_AutorizationPage(WebDriver driver){
        super(driver);
        this.Base = new BasePage(driver);
    }

    private BasePage Base;

    public void autorization(String user){
        DataAutoriz userData = DataUsers.valueOf(user.toUpperCase()).getAuthData(); // Поиск по enum users
        send(xFIELD_ESIA_LOGIN, userData.getLogin());
        send(xFIELD_ESIA_PASSWORD, userData.getPassword());
        click(xBUTTON_ESIA_LOGIN);
        click(xBUTTON_EGAIS_TYPE_USER);
    }
}
