package App.Model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Handlowiec extends Pracownik implements Serializable {
    private final int limitProwizji;
    private final String telefonSluzbowy;
    private final BigDecimal stawkaProwizji;


    public Handlowiec(String pesel, String imie, String nazwisko, int wynagrodzenie,
                      String telefonSluzbowy, BigDecimal stawkaProwizji, int limitProwizji) {
        super(pesel, imie, nazwisko, wynagrodzenie);
        this.limitProwizji = limitProwizji;
        this.telefonSluzbowy= telefonSluzbowy;
        this.stawkaProwizji= stawkaProwizji;
    }

    public String getTelefonSluzbowy() {
        return telefonSluzbowy;
    }

    public BigDecimal getProwizja() {
        return stawkaProwizji;
    }
    public int getLimitProwizji() {
        return limitProwizji;
    }

}
