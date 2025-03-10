package dataSet.autorization;

public enum DataUsers {

    ORLOVA(
            new DataAutoriz(
                    "+79055681305",
                    "Fcs2Dcx@^"
                            )
            ),

    ZAZUBENKO(
            new DataAutoriz(
                    "+79524945159",
                    "Dy2-6bn3WU"
                            )
            ),

    SEMENOV(
            new DataAutoriz(
                    "89858820345",
                    "V&h5dJJM!123"
                            )
            );

    // Поле для хранения данных авторизации
    private final DataAutoriz authData;

    // Конструктор enum
    DataUsers(DataAutoriz authData) {
        this.authData = authData;
    }

    // Метод для получения данных авторизации
    public DataAutoriz getAuthData() {
        return authData;
    }
}
