package pages.autorization;

import dataSet.autorization.DataAutoriz;
import dataSet.autorization.DataUsers;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import static pages.autorization.LinksAutorization.*;
import static pages.autorization.xAutorization_Dirt.*;

public class Autorization extends BasePage {
    public Autorization(WebDriver driver) {
        super(driver);
        this.Base = new BasePage(driver);
    }
    private BasePage Base;

    public void login(String cabinet, String user){

        DataAutoriz userData = DataUsers.valueOf(user.toUpperCase()).getAuthData(); // Поиск по enum

        switch (cabinet){
            case "LKL":
                loginLKL(userData);

            case("RMDL"):
                loginRMDL(userData);
        }
    }

    public void loginLKL(DataAutoriz user){
        get(LINK_LKL_MAIN.getUrl());
        click(xBUTTON_LOGIN);
        send(xFIELD_ESIA_LOGIN, user.getLogin());
        send(xFIELD_ESIA_PASSWORD, user.getPassword());
        click(xBUTTON_ESIA_LOGIN);
        timeOut(1000);
        click(xBUTTON_TYPE_USER_LKL);
        timeOut(2000);
        click(xBUTTON_FINAL_LOGIN);
        timeOut(1000);
    }

    public void loginRMDL(DataAutoriz user){
        get(LINK_RMDL_MAIN.getUrl());
        click(xBUTTON_LOGIN);
        send(xFIELD_ESIA_LOGIN, user.getLogin());
        send(xFIELD_ESIA_PASSWORD, user.getPassword());
        click(xBUTTON_ESIA_LOGIN);
        timeOut(1000);
        click(xBUTTON_TYPE_USER_RMDL);
        timeOut(2000);
        click(xBUTTON_FINAL_LOGIN);
        timeOut(1000);
    }
}
