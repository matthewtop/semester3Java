package EwidencjaPracownikow.Model;

import java.math.BigDecimal;

public class Dyrektor extends Pracownik{
    private BigDecimal dodatekSluzbowy;

    public Dyrektor(String imie, String nazwisko, String pesel, int wynagrodzenie, int telSluzbowy) {
        super(imie, nazwisko, pesel, wynagrodzenie, telSluzbowy);
    }

    public void setDodatekSluzbowy(BigDecimal kwota){
        this.dodatekSluzbowy=kwota;
    }
}
