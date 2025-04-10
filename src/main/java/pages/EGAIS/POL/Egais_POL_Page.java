package pages.EGAIS.POL;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.EGAIS.EGAIS_BasePage;

public class Egais_POL_Page extends EGAIS_BasePage {

    public static final String xBUTTON_START_POL = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-info-screen/epgu-cf-ui-screen-container/main/epgu-cf-ui-constructor-screen-pad/epgu-constructor-screen-buttons/div/lib-button/div/button";
    public static final String xBUTTON_MAKE_IN = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-question-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-answer-button[1]/epgu-cf-ui-long-button/button";
    public static final String xBUTTON_MAKE_REG = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-question-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-answer-button[2]/epgu-cf-ui-long-button/button";
    public static final String xBUTTON_TARGET_WOOD_YES = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-question-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-answer-button[1]/epgu-cf-ui-long-button/button/div/div";
    public static final String xBUTTON_GO_TO_DOC = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-info-screen/epgu-cf-ui-screen-container/main/epgu-cf-ui-constructor-screen-pad/epgu-constructor-screen-buttons/div/lib-button/div/button";
    public static final String xBUTTON_ACCEPT_PASSDATA = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-unique-screen/epgu-constructor-unique-resolver/epgu-constructor-confirm-personal-user-data/epgu-constructor-default-unique-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-screen-buttons/div/lib-button/div/button";
    public static final String xBUTTON_ACCEPT_PHONE = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-unique-screen/epgu-constructor-unique-resolver/epgu-constructor-confirm-personal-user-phone-email/epgu-constructor-default-unique-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-screen-buttons/div/lib-button/div/button";
    public static final String xBUTTON_ACCEPT_EMAIL = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-unique-screen/epgu-constructor-unique-resolver/epgu-constructor-confirm-personal-user-phone-email/epgu-constructor-default-unique-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-screen-buttons/div/lib-button/div/button";
    public static final String xBUTTON_ACCEPT_ADDRESS = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-unique-screen/epgu-constructor-unique-resolver/epgu-constructor-confirm-address-screen/epgu-constructor-default-unique-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-screen-buttons/div/lib-button/div/button";
    public static final String xBUTTON_ACCEPT_ADDRESS_FACT = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-question-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-answer-button[1]/epgu-cf-ui-long-button/button";
    public static final String xFIELD_FOREST = "//*[@id=\"c15\"]";
    public static final String xBUTTON_ACCEPT_FOREST = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-repeatable-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-screen-buttons/div/lib-button/div/button";
    public static final String xFIELD_VALIDATION_PERIOD = "//*[@id=\"c8\"]";
    public static final String xBUTTON_CANCEL_CHERNOVIK = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-cf-ui-modal-container/div/epgu-constructor-confirmation-modal/epgu-cf-ui-cta-modal/div[2]/lib-scrollbar/div/div/ng-scrollbar/div/div[1]/div/div/div/lib-button[1]/div/button";
    public static final String xBUTTON_ACCEPT_PERIOD = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-custom-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-screen-buttons/div/lib-button/div/button";
    public static final String xBUTTON_CHOICE_FOREST_AREA_NO = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-question-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-answer-button[2]/epgu-cf-ui-long-button/button/div/div";
    public static final String xFIELD_CHOICE_DOC_TYPE = "//*[@id=\"c10\"]";
    public static final String xFIELD_DATE_DOC = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-custom-screen/epgu-cf-ui-screen-container/main/div[1]/epgu-cf-ui-constructor-screen-pad/epgu-constructor-custom/form/div[2]/epgu-constructor-custom-resolver/epgu-constructor-date-input/epgu-constructor-custom-item/div/div/epgu-constructor-date-picker/lib-date-picker/div/div/div/div[1]/lib-standard-masked-input/div/div/div[1]/input";
    public static final String xFIELD_NUMBER_DOC = "//*[@id=\"c35\"]";
    public static final String xBUTTON_NEXT = "//*[@id=\"print-page\"]/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-custom-screen/epgu-cf-ui-screen-container/main/div[2]/epgu-constructor-screen-buttons/div/lib-button/div/button";
    public static final String xINPUT_XML_DOC = "/html/body/div/div/div/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-unique-screen/epgu-constructor-unique-resolver/epgu-constructor-file-upload-screen/epgu-cf-ui-screen-container/main/div[1]/epgu-constructor-file-upload/epgu-constructor-file-upload-container[1]/epgu-constructor-file-upload-item/div/epgu-constructor-uploader/div[2]/epgu-constructor-uploader-button[2]/input";
    public static final String xINPUT_SIG_DOC = "/html/body/div/div/div/portal-new-sf-player/epgu-constructor-form-player/epgu-cf-ui-main-container/epgu-constructor-screen-resolver/epgu-constructor-unique-screen/epgu-constructor-unique-resolver/epgu-constructor-file-upload-screen/epgu-cf-ui-screen-container/main/div[1]/epgu-constructor-file-upload/epgu-constructor-file-upload-container[2]/epgu-constructor-file-upload-item/div/epgu-constructor-uploader/div[2]/epgu-constructor-uploader-button[2]/input";

    public Egais_POL_Page(WebDriver driver) {
        super(driver);
        this.Base = new EGAIS_BasePage(driver);
    }
    private BasePage Base;

    public void POL(Integer docID, String make, String forest, String period){
//        DataPOL doc = DataPOLdoc; // Поиск по enum

        if(isDisp(xBUTTON_CANCEL_CHERNOVIK)){
            click(xBUTTON_CANCEL_CHERNOVIK);
        }

        click(xBUTTON_START_POL);
        switch (make){
            case "in":
                click(xBUTTON_MAKE_IN);
                break;
            case "reg":
                click(xBUTTON_MAKE_REG);
                break;
        }
        click(xBUTTON_TARGET_WOOD_YES);
        click(xBUTTON_GO_TO_DOC);
        click(xBUTTON_ACCEPT_PASSDATA);
        click(xBUTTON_ACCEPT_PHONE);
        click(xBUTTON_ACCEPT_EMAIL);
        click(xBUTTON_ACCEPT_ADDRESS);
        click(xBUTTON_ACCEPT_ADDRESS_FACT);
        send(xFIELD_FOREST, forest);
        clickDown();
        click(xBUTTON_ACCEPT_FOREST);
        send(xFIELD_VALIDATION_PERIOD, period);
        click(xBUTTON_ACCEPT_PERIOD);
        click(xBUTTON_CHOICE_FOREST_AREA_NO);

        // Нужно будет сделать класс с доками и тянуть данные оттуда, мне лень потом придумаю ( НЕТ )
        send(xFIELD_CHOICE_DOC_TYPE, "аренды");
        clickDown();
        send(xFIELD_DATE_DOC, "01.02.2024");
        send(xFIELD_NUMBER_DOC, "893");
        click(xBUTTON_NEXT);

        // Загрузку дока тоже можно сделать через этот же класс, пути и тд.
        send(xINPUT_XML_DOC, "C:\\Users\\naknyazev\\Documents\\DataAutoTest\\DKP\\Тестовый_ПОЛ_ЛУ_пройдет_проверку_физик.xml");
        send(xINPUT_SIG_DOC, "C:\\Users\\naknyazev\\Documents\\DataAutoTest\\DKP\\Тестовый_ПОЛ_ЛУ_пройдет_проверку_физик.xml.sig");
    }


    public void clickDown(){
        timeOut(1000);
        arrowDown();
        enter();
        timeOut(1000);
    }
}
