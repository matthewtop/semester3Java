package App.Controller.FunctionControllers;


import App.Model.Dyrektor;
import App.Model.EwidencjaPracownikow;
import App.Model.Handlowiec;
import App.View.Errors;
import App.View.InputGetters;
import App.View.Menus;

import javax.swing.text.View;
import java.math.BigDecimal;
import java.util.Scanner;

public class DodajPracownikaController {
    private final Scanner scanner;
    private final EwidencjaPracownikow ewidencjaPracownikow;

    public DodajPracownikaController(Scanner scanner, EwidencjaPracownikow ewidencjaPracownikow) {
        this.scanner =scanner;
        this.ewidencjaPracownikow= ewidencjaPracownikow;
    }

    public void dodajPracownika(){
        Menus.dodajPracownikaMenu();
        String wybor=scanner.next();
        switch (wybor){
            case "d", "D":
                dodajDyrektora();
                break;
            case "h", "H":
                dodajHandlowca();
                break;
            default:
                Errors.zlyWyborError();
                break;
        }
    }

    public void dodajDyrektora(){
        Menus.przerywnik();
        String pesel = getPesel();
        String imie = getImie();
        String nazwisko = getNazwisko();
        int wynagrodzenie = getWynagrodzernie();
        String telefonSluzbowy = getTelefonSluzbowy();
        BigDecimal dodatekSluzbowy =getDodatekSluzbowy();
        String kartaSluzbowaNumer = getKartaSluzbowa();
        int limitKosztow = getLimitKosztow();
        Dyrektor dyrektor = new Dyrektor(pesel, imie, nazwisko, wynagrodzenie, telefonSluzbowy, dodatekSluzbowy, kartaSluzbowaNumer, limitKosztow);
        ewidencjaPracownikow.dodajPracownika(dyrektor);
    }

    public void dodajHandlowca(){
        Menus.przerywnik();
        String pesel = getPesel();
        String imie = getImie();
        String nazwisko = getNazwisko();
        int wynagrodzenie = getWynagrodzernie();
        String telefonSluzbowy = getTelefonSluzbowy();
        BigDecimal prowizja = getProwizja();
        int limitProwizji= getLimitProwizji();
        Handlowiec handlowiec = new Handlowiec(pesel, imie, nazwisko, wynagrodzenie, telefonSluzbowy, prowizja, limitProwizji);
        ewidencjaPracownikow.dodajPracownika(handlowiec);
    }
    public int getLimitProwizji() {
        InputGetters.getLimitProwizji();
        return scanner.nextInt();
    }

    public String getImie(){
        InputGetters.getImie();
        return scanner.next();
    }

    public String getNazwisko(){
        InputGetters.getNazwisko();
        return scanner.next();
    }

    public String getPesel(){
        InputGetters.getPesel();
        return scanner.next();
    }

    public int getWynagrodzernie(){
        InputGetters.getWynagrodzenie();
        return scanner.nextInt();
    }

    public String getTelefonSluzbowy(){
        InputGetters.getTelefonSluzbowy();
        return scanner.next();
    }
    public BigDecimal getProwizja(){
        InputGetters.getProwizja();
        return BigDecimal.valueOf(scanner.nextInt());
    }

    public BigDecimal getDodatekSluzbowy(){
        InputGetters.getDodatekSluzbowy();
        return scanner.nextBigDecimal();
    }

    public String getKartaSluzbowa(){
        InputGetters.getKartaSluzbowa();
        return scanner.next();
    }

    public int getLimitKosztow(){
        InputGetters.getLimitKosztow();
        return scanner.nextInt();
    }


}
