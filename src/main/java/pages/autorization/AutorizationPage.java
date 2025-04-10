package pages.autorization;

import dataSet.autorization.DataAutoriz;
import dataSet.autorization.DataUsers;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.EGAIS.autorization.EGAIS_AutorizationPage;

import static pages.autorization.LinksAutorization.*;
import static pages.autorization.xAutorization_Dirt.*;

public class AutorizationPage extends BasePage {
    public AutorizationPage(WebDriver driver) {
        super(driver);
        this.Base = new BasePage(driver);
        this.EGAIS = new EGAIS_AutorizationPage(driver);

    }
    private BasePage Base;
    private EGAIS_AutorizationPage EGAIS;

    public void login(String cabinet, String user, String type){

        if (type == null){
            type = "ОРГАНИЗАЦИЯ -1635872784";
        }

//        DataAutoriz userData = DataUsers.valueOf(user.toUpperCase()).getAuthData(); // Поиск по enum users

        switch (cabinet){
            case "LKL":
                loginLKL(user, type);
                break;

            case "RMDL":
                loginRMDL(user, type);
                break;

            default:
                throw new IllegalArgumentException("Некорректный тип кабинета: " + cabinet);
        }
    }

    public void loginLKL(String user, String type){
        get(LINK_LKL_MAIN.getUrl());
        click(xBUTTON_LOGIN);
        EGAIS.autorization(user);
        timeOut(1000);
        click(xBUTTON_TYPE_USER + type + "')]");
        timeOut(3000);
        click(xBUTTON_FINAL_LOGIN);
        timeOut(3000);
    }

    public void loginRMDL(String user, String type){
        get(LINK_RMDL_MAIN.getUrl());
        click(xBUTTON_LOGIN);
        EGAIS.autorization(user);
        timeOut(1000);
//        System.out.println(xBUTTON_TYPE_USER + type + "']");
//        click(xBUTTON_TYPE_USER + type + "']");
        click(xBUTTON_TYPE_USER + type + "')]");
        timeOut(3000);
        click(xBUTTON_FINAL_LOGIN);
        timeOut(3000);
    }
}
