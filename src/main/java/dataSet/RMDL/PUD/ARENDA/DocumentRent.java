package dataSet.RMDL.PUD.ARENDA;

public enum DocumentRent {

    AUTO(
            new DataRent(
                "Rent_AUTO_",
                "ОРГАНИЗАЦИЯ -1635872784",
                "Rent_auto_doc_no_",
                null
            )
    ),

    PROD(
            new DataRent(
                    "",
                    "",
                    "",
                    ""
            )
    );


    // Поле для хранения данных документа
    private final DataRent rentData;

    // Конструктор enum
    DocumentRent(DataRent rentData) {
        this.rentData = rentData;
    }

    // Метод для получения данных документа
    public DataRent getRentData() {
        return rentData;
    }
}
