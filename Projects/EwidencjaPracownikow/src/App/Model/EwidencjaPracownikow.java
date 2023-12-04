package App.Model;

import java.util.ArrayList;
import java.util.List;

public class EwidencjaPracownikow {
    private final ArrayList<Pracownik> pracownicy = new ArrayList<>();

    @Override
    public String toString() {
        return "EwidencjaPracownikow{" +
                "pracownicy=" + pracownicy +
                '}';
    }
    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }

    public List<Pracownik> pobierzListePracownikow() {
        return pracownicy;
    }



}
