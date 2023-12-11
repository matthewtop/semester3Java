package App.Controller.FunctionControllers;

import App.Model.Dyrektor;
import App.Model.EwidencjaPracownikow;
import App.Model.Handlowiec;
import App.Utils.NameAndSurnameValidator;
import App.Utils.PeselValidator;
import App.View.InputGetters;
import App.View.Menus;
import App.View.Messages.Errors;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DodajPracownikaController {
    private final Scanner scanner;
    private final EwidencjaPracownikow ewidencjaPracownikow;
    private final PeselValidator peselValidator;
    private final HashSet<String> pesels = new HashSet<>();

    public DodajPracownikaController(Scanner scanner, EwidencjaPracownikow ewidencjaPracownikow) {
        this.scanner =scanner;
        this.ewidencjaPracownikow= ewidencjaPracownikow;
        this.peselValidator = new PeselValidator(pesels);
    }

    public void dodajPracownika(){
        Menus.dodajPracownikaMenu();
        String wybor=scanner.nextLine().toLowerCase();
        switch (wybor){
            case "d":
                dodajDyrektora();
                break;
            case "h":
                dodajHandlowca();
                break;
            default:
                Errors.zlyWyborError();
                break;
        }
    }

    public void dodajDyrektora() {
        Menus.przerywnik();
        try {
            String pesel = getPesel();
            String imie = getImie();
            String nazwisko = getNazwisko();
            int wynagrodzenie = getWynagrodzenie();
            String telefonSluzbowy = getTelefonSluzbowy();
            BigDecimal dodatekSluzbowy = getDodatekSluzbowy();
            String kartaSluzbowaNumer = getKartaSluzbowa();
            int limitKosztow = getLimitKosztow();

            Dyrektor dyrektor = new Dyrektor(pesel, imie, nazwisko, wynagrodzenie, telefonSluzbowy, dodatekSluzbowy, kartaSluzbowaNumer, limitKosztow);
            ewidencjaPracownikow.dodajPracownika(dyrektor);
            pesels.add(pesel);
        } catch (Exception e) {
            Errors.zlyPeselError();
        }
        Menus.przerywnik();
    }

    public void dodajHandlowca() {
        Menus.przerywnik();
        try {
            String pesel = getPesel();
            String imie = getImie();
            String nazwisko = getNazwisko();
            int wynagrodzenie = getWynagrodzenie();
            String telefonSluzbowy = getTelefonSluzbowy();
            BigDecimal prowizja = getProwizja();
            int limitProwizji = getLimitProwizji();

            Handlowiec handlowiec = new Handlowiec(pesel, imie, nazwisko, wynagrodzenie, telefonSluzbowy, prowizja, limitProwizji);
            ewidencjaPracownikow.dodajPracownika(handlowiec);
            pesels.add(pesel);
        } catch (Exception e) {
            Errors.zlyPeselError();
        }
        Menus.przerywnik();
    }
    public int getLimitProwizji() {
        InputGetters.getLimitProwizji();
        return scanner.nextInt();
    }

    public String getImie() {
        String imie;
        do {
            InputGetters.getImie();
            imie = scanner.next();
            if (!NameAndSurnameValidator.validateName(imie)) {
                Errors.niepoprawnyFormatError();
            }
        } while (!NameAndSurnameValidator.validateName(imie));
        return imie;
    }

    public String getNazwisko(){
        String nazwisko;
        do{
            InputGetters.getNazwisko();
            nazwisko= scanner.next();
            if(!NameAndSurnameValidator.validateSurname(nazwisko)){
                Errors.niepoprawnyFormatError();
            }
        }while (!NameAndSurnameValidator.validateSurname(nazwisko));
        return nazwisko;
    }

    public String getPesel() {
        String pesel;
        do {
            InputGetters.getPesel();
            pesel = scanner.next();
            if (!peselValidator.validatePesel(pesel)) {
                Errors.zlyPeselError();
            }
        } while (!peselValidator.validatePesel(pesel));
        return pesel;
    }

    public int getWynagrodzenie() {
        try {
            InputGetters.getWynagrodzenie();
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            Errors.zlyFormatDanychError();
            scanner.next();
            return getWynagrodzenie();
        }
    }
    public String getTelefonSluzbowy(){
        try {
            InputGetters.getTelefonSluzbowy();
            return scanner.next();
        } catch (InputMismatchException e) {
            Errors.zlyFormatDanychError();
            scanner.next();
            return getTelefonSluzbowy();
        }
    }
    public BigDecimal getProwizja(){
        try {
            InputGetters.getProwizja();
            return BigDecimal.valueOf(scanner.nextInt());
        } catch (InputMismatchException e) {
            Errors.zlyFormatDanychError();
            scanner.next();
            return BigDecimal.valueOf(scanner.nextInt());
        }
    }
    public BigDecimal getDodatekSluzbowy(){
        try {
            InputGetters.getDodatekSluzbowy();
            return BigDecimal.valueOf(scanner.nextInt());
        } catch (InputMismatchException e) {
            Errors.zlyFormatDanychError();
            scanner.next();
            return BigDecimal.valueOf(scanner.nextInt());
        }
    }
    public String getKartaSluzbowa(){
        try{
            InputGetters.getKartaSluzbowa();
            return scanner.next();
        }catch (InputMismatchException e){
            Errors.zlyFormatDanychError();
            scanner.next();
            return getKartaSluzbowa();
        }
    }
    public int getLimitKosztow(){
        try {
            InputGetters.getLimitKosztow();
            return scanner.nextInt();
        }catch (InputMismatchException e) {
            Errors.zlyFormatDanychError();
            scanner.next();
            return getLimitKosztow();
        }
    }
}
