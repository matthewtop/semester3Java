package EwidencjaPracownikow.Model;

import java.util.HashMap;
import java.util.Map;

public class EwidencjaPracownikow {
    private Map<String, Pracownik> pracownicy;

    public EwidencjaPracownikow(){
        this.pracownicy=new HashMap<>();
    }

    public void dodajPracownika(Pracownik pracownik){
        pracownicy.put(pracownik.getPesel(), pracownik);
    }

    public Pracownik znajdzPracownika(String pesel){
        return pracownicy.get(pesel);
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
