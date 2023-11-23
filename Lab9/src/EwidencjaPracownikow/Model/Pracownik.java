package EwidencjaPracownikow.Model;

import java.io.Serializable;

public abstract class Pracownik implements Serializable {
    private String imie;
    private String nazwisko;
    private String pesel;
    private int wynagrodzenie;
    private int telSluzbowy;
    private int prowizja;
    private int limitProwizji;

    public Pracownik(String imie, String nazwisko, String pesel, int wynagrodzenie, int telSluzbowy) {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.pesel=pesel;
        this.wynagrodzenie=wynagrodzenie;
        this.telSluzbowy=telSluzbowy;
    }


    public String getImie(){return imie;}

    public String getNazwisko(){return nazwisko;}
    public String getPesel(){return pesel;}
    public int getWynagrodzenie(){return wynagrodzenie;}

    public int getTelSluzbowy(){return telSluzbowy;}

    public int getProwizja(){return prowizja;}
    public int getLimitProwizji(){return limitProwizji;}

    public void setImie(String newImie){this.imie=newImie;}
    public void setNazwisko(String newNazwisko){this.nazwisko=newNazwisko;}
    public void setWynagrodzenie(int newWynagrodzenie){this.wynagrodzenie=newWynagrodzenie;}
    public void setTelSluzbowy(int newTel){this.telSluzbowy=newTel;}
    public void setProwizja(int prowizja){this.prowizja=prowizja;}
    public void setLimitProwizji(int limitProwizji){this.limitProwizji=limitProwizji;}
    public void setPesel(String newPesel){this.pesel=newPesel;}


}
