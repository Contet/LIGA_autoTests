package dataSet.autorization;

public class DataAutoriz {
    private final String login;
    private final String password;


    // Конструктор
    public DataAutoriz(String login, String password) {
        this.login = login;
        this.password = password;
    }


    // Геттеры
    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }

}
