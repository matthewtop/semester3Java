package EwidencjaPracownikow.Model;

import java.math.BigDecimal;

public class Handlowiec extends Pracownik{
    private  BigDecimal stawkaProwizji;

    public Handlowiec(String imie, String nazwisko, String pesel, int wynagrodzenie, int telSluzbowy, BigDecimal stawkaProwizji){
        super(imie, nazwisko, pesel, wynagrodzenie, telSluzbowy);
        this.stawkaProwizji=stawkaProwizji;
    }
}
