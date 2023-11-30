package App.Model;

import java.io.Serializable;

public abstract class Pracownik implements Serializable {
    private String imie;
    private String nazwisko;
    private String pesel;
    private int wynagrodzenie;

    public Pracownik(String pesel, String imie, String nazwisko, int wynagrodzenie) {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wynagrodzenie = wynagrodzenie;
    }


    public String getImie(){return imie;}

    public String getNazwisko(){return nazwisko;}
    public String getPesel(){return pesel;}
    public int getWynagrodzenie(){return wynagrodzenie;}

    public void setImie(String newImie){this.imie=newImie;}
    public void setNazwisko(String newNazwisko){this.nazwisko=newNazwisko;}
    public void setWynagrodzenie(int newWynagrodzenie){this.wynagrodzenie=newWynagrodzenie;}

    public void setPesel(String newPesel){this.pesel=newPesel;}


    public void dodajPesel(String pesel){
        //todo
    }




}
