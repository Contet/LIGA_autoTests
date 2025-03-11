package dataSet.RMDL.PUD.DKP;

public class DataDKP {
    private final String name;
    private final String autor;
    private final String number;
    private final String date;


    // Конструктор
    public DataDKP(String name, String autor, String number, String date) {
        this.name = name;
        this.autor = autor;
        this.number = number;
        this.date = date;
    }


    // Геттеры
    public String getName() {return name;}
    public String getAutor() {return autor;}
    public String getNumber() {return number;}
    public String getDate() {return date;}

}
