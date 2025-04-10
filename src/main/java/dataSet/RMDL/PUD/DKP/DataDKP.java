package dataSet.RMDL.PUD.DKP;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class DataDKP {
    private final String name;
    private final String autor;
    private final String number;
    private final String date;

    private final String numberAgreement;
    private final String dateOnAgreement;
    private final String placeOnAgreement;
    private final String dateStartAgreement;
    private final String dateFinalAgreement;

    private final String innSeller;
    private final String calculatedBill;
    private final String correspondentBill;
    private final String bikBill;


//    // Конструктор
//    public DataDKP(String name, String autor, String number, String date) {
//        this.name = name;
//        this.autor = autor;
//        this.number = number;
//        this.date = date;
//    }


//    // Геттеры
//    public String getName() {return name;}
//    public String getAutor() {return autor;}
//    public String getNumber() {return number;}
//    public String getDate() {return date;}

}
