package App.Model;

import App.View.Errors;

import java.util.ArrayList;

public class EwidencjaPracownikow {
    private ArrayList<Pracownik> pracownicy = new ArrayList<>();
    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }

    public Pracownik znajdzPracownika(String pesel) {
        for (Pracownik pracownik : pracownicy) {
            if (pracownik.getPesel().equals(pesel)) {
                return pracownik;
            }
            else {
                Errors.pracownikNieIstniejeError();
            }
        }
        return null;
    }

    public void usunPracownika(String pesel){
        pracownicy.remove(pesel);
    }

    public void zapiszDoPliku(String plik){
        //todo

    }

    public void odczytajPlik(String plik){
        //todo
    }
}
