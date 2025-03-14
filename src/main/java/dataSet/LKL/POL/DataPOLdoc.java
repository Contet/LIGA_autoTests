package dataSet.LKL.POL;

public enum DataPOLdoc {

    www(
            new DataPOL(
                    1,
                    "12",
                    "Договор аренды"
            )
    );
    // Поле для хранения данных авторизации
    private final DataPOL document;

    // Конструктор enum
    DataPOLdoc(DataPOL document) {
        this.document = document;
    }

}
