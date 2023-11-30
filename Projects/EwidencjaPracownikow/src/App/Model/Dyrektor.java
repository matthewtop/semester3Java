package App.Model;

import java.math.BigDecimal;

public class Dyrektor extends Pracownik{
    private String telefonSluzbowy;
    private BigDecimal dodatekSluzbowy;
    private String kartaSluzbowaNumer;
    private int limitKosztow;


    public Dyrektor(String pesel, String imie, String nazwisko, int wynagrodzenie,
                    String telefonSluzbowy, BigDecimal dodatekSluzbowy, String kartaSluzbowaNumer, int limitKosztow) {
        super(pesel, imie, nazwisko, wynagrodzenie);
        this.telefonSluzbowy = telefonSluzbowy;
        this.dodatekSluzbowy = dodatekSluzbowy;
        this.kartaSluzbowaNumer = kartaSluzbowaNumer;
        this.limitKosztow = limitKosztow;
    }


    public void setDodatekSluzbowy(BigDecimal kwota){
        this.dodatekSluzbowy=kwota;
    }
}
