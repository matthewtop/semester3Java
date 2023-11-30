package App.Model;

import java.math.BigDecimal;

public class Handlowiec extends Pracownik {
    private String telefonSluzbowy;
    private int limitProwizji;
    private  BigDecimal stawkaProwizji;

    public Handlowiec(String pesel, String imie, String nazwisko, int wynagrodzenie,
                      String telefonSluzbowy, BigDecimal stawkaProwizji, int limitProwizji) {
        super(pesel, imie, nazwisko, wynagrodzenie);
        this.telefonSluzbowy = telefonSluzbowy;
        this.stawkaProwizji = stawkaProwizji;
        this.limitProwizji = limitProwizji;
    }
}
