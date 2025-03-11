package dataSet.RMDL.PUD.DKP;

public enum Document {

    AUTO(
            new DataDKP(
                "DKP_AUTO_",
                "ОРГАНИЗАЦИЯ -1635872784",
                "DKP_auto_doc_no_",
                null
            )
    ),

    PROD(
            new DataDKP(
                    "",
                    "",
                    "",
                    ""
            )
    );


    // Поле для хранения данных документа
    private final DataDKP dkpData;

    // Конструктор enum
    Document(DataDKP dkpData) {
        this.dkpData = dkpData;
    }

    // Метод для получения данных документа
    public DataDKP getDKPdata() {
        return dkpData;
    }
}
