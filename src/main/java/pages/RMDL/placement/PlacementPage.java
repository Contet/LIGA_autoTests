package pages.RMDL.placement;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static pages.RMDL.placement.LinksPlacement.LINK_PLACEMENT_MAIN;
import static pages.RMDL.placement.xPlacement_Dirt.*;

public class PlacementPage extends BasePage {
    public PlacementPage(WebDriver driver) {
        super(driver);
        this.Base = new BasePage(driver);
    }
    private BasePage Base;
    public String cartDocLink;

    public void DKP(){
        String date = Base.dateNow();

//      Выбор типа документа
        get(LINK_PLACEMENT_MAIN.getUrl());
        send(xFIELD_FIND_DOCUMENT, "Договор купли-продажи лесных насаждений");
        timeOut(3000);
        listDown(xFIELD_FIND_DOCUMENT, 1);
        click(xBUTTON_FIND_DOCUMENT);
//      Блок информация о документе
        send(xFIELD_NAME_DOCUMENT, "DKP_AUTO_" + date);
        send(xFIELD_AUTOR_DOCUMENT, "ОРГАНИЗАЦИЯ -1635872784");
        send(xFIELD_NUMBER_DOCUMENT, "DKP_auto_doc_no_" + date);
        sendDate(xDATE_FIELD_DOCUMENT, date);
//      Инпуты документа
        unInvisibalyInput(xHIDDEN_FIELD_INPUT_FILE);
        unInvisibalyInput(xHIDDEN_FIELD_INPUT_FILESIG);
        send(xHIDDEN_FIELD_INPUT_FILE, SYSTEM_PATH_TO_INPUT_FILE);
        send(xHIDDEN_FIELD_INPUT_FILESIG, SYSTEM_PATH_TO_INPUT_FILESIG);
        timeOut(1000);
//      Запись БК
        String bizKey = getText(xTEXT_BIZ_KEY);
        writeTextToFile(bizKey, "log_DKP.txt");
//      Добавление документа ПДФ
        click(xBUTTON_ADD_DOCUMENT);
        click(xBUTTON_ADD_DOCUMENT_SIG);
        timeOut(1000);
        cartDocLink = getUrl(xBUTTON_CLICK_TO_CARTDOC);
        click(xBUTTON_CLICK_TO_CARTDOC);
        timeOut(2000);
    }


}
