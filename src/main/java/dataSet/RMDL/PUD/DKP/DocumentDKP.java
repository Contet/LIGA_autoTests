package dataSet.RMDL.PUD.DKP;

import pages.BasePage;

public enum DocumentDKP {

    AUTO(
            new DataDKP(
                "DKP_AUTO_",
                "ОРГАНИЗАЦИЯ -1635872784",
                "DKP_auto_doc_no_",
                null,
                "14-АУК",
                "01022025",
                "Приморский край, г. Владивосток, ул. 1-я Морская, д. 2",
                null,
                null,
                "2501008325",
                "03100643000000012000",
                "40102810545370000012",
                "010507002"
            )
    );

//    PROD(
//            new DataDKP(
//                    "",
//                    "",
//                    "",
//                    ""
//            )
//    );


    // Поле для хранения данных документа
    private final DataDKP dkpData;

    // Конструктор enum
    DocumentDKP(DataDKP dkpData) {
        this.dkpData = dkpData;
    }

    // Метод для получения данных документа
    public DataDKP getDKPdata() {
        return dkpData;
    }
}
