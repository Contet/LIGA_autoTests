package pages.RMDL.PUD.DKP;

import dataSet.RMDL.PUD.DKP.DataDKP;
import dataSet.RMDL.PUD.DKP.DocumentDKP;
import org.openqa.selenium.WebDriver;
import pages.RMDL.PUD.PUD_Base;

public class DKP extends PUD_Base {

    // xpath вынести потом в отдельный класс
    public static final String xFIELD_NUMBER_AGREEMENT = "//*[@id=\":r2:\"]";
    public static final String xFIELD_DATE_ON_AGREEMENT = "//*[@id=\":r3:\"]";
    public static final String xFIELD_PLACE_ON_AGREEMENT = "//*[@id=\":r5:\"]";
    public static final String xFIELD_DATE_START_AGREEMENT = "//*[@id=\":r6:\"]";
    public static final String xFIELD_DATE_FINAL_AGREEMENT = "//*[@id=\":r8:\"]";
    public static final String xBUTTON_FIND_MODAL_SELLER = "//*[@id=\"app\"]/div[3]/main/div[1]/div[2]/div[1]/div/div/form/div/div/div[1]/div[8]/div[2]/div/button";
    public static final String xFIELD_PLACE_ON_AGREEMENT_BANK = "//*[@id=\":r20:\"]";
    public static final String xFIELD_CALCULATED_BILL = "//*[@id=\":r21:\"]";
    public static final String xFIELD_CORRES_BILL = "//*[@id=\":r22:\"]";
    public static final String xFIELD_BIK_BILL = "//*[@id=\":r23:\"]";
    public static final String xFIELD_SELLER_FAMILY = "//*[@id=\":r24:\"]";
    public static final String xFIELD_SELLER_NAME = "//*[@id=\":r25:\"]";
    public static final String xFIELD_SELLER_SURNAME = "//*[@id=\":r26:\"]";
    public static final String xFIELD_SELLER_POSTION = "//*[@id=\":r27:\"]";
    public static final String xFIELD_SELLER_BASIS_AUTHORITY = "//*[@id=\":r28:\"]";
    public static final String xFIELD_SELLER_BASIS_DOC_NO = "//*[@id=\":r29:\"]";
    public static final String xFIELD_SELLER_PHONE = "//*[@id=\":r2c:\"]";
    public static final String xFIELD_SELLER_ORGANIZATION = "//*[@id=\":r2f:\"]";
    public static final String xFIELD_DATE_SELLER_BASIS_DOC = "//*[@id=\":r2a:\"]";
    public static final String xFIELD_DATE_SELLER_BASIS_DOC_SIG = "//*[@id=\":r2d:\"]";

    public DKP(WebDriver driver) {
        super(driver);
    }



    public void fill(String docName){
        DataDKP doc = DocumentDKP.valueOf(docName.toUpperCase()).getDKPdata();
        timeOut(3000);
        refresh();

        // Шапка
        send(xFIELD_NUMBER_AGREEMENT, doc.getNumberAgreement());
        sendDate(xFIELD_DATE_ON_AGREEMENT, doc.getDateOnAgreement());
        send(xFIELD_PLACE_ON_AGREEMENT, doc.getPlaceOnAgreement());
        sendDate(xFIELD_DATE_START_AGREEMENT, dateNow());
        sendDate(xFIELD_DATE_FINAL_AGREEMENT, randomDateToday());

        // Сведения о продавце
        click(xBUTTON_FIND_MODAL_SELLER);
        findModal("inn", doc.getInnSeller());

        // Банковские реквизиты
        send(xFIELD_PLACE_ON_AGREEMENT_BANK, doc.getPlaceOnAgreement());
        send(xFIELD_CALCULATED_BILL, doc.getCalculatedBill());
        send(xFIELD_CORRES_BILL, doc.getCorrespondentBill());
        send(xFIELD_BIK_BILL, doc.getBikBill());

        // Данные сотрудника
//        send(xFIELD_SELLER_FAMILY, );
//        send(xFIELD_SELLER_NAME, );
//        send(xFIELD_SELLER_SURNAME, );
//        send(xFIELD_SELLER_POSTION, );
//        send(xFIELD_SELLER_BASIS_AUTHORITY, );
//        send(xFIELD_SELLER_BASIS_DOC_NO, );
//        send(xFIELD_SELLER_PHONE, );
//        send(xFIELD_SELLER_ORGANIZATION, );
//        sendDate(xFIELD_DATE_SELLER_BASIS_DOC, );
//        sendDate(xFIELD_DATE_SELLER_BASIS_DOC_SIG, );



    }
}
