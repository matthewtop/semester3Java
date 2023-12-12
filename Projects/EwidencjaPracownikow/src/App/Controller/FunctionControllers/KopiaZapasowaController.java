package App.Controller.FunctionControllers;

import App.Model.EwidencjaPracownikow;
import App.View.InputGetters;
import App.View.Menus;
import App.View.Messages.Errors;
import App.View.Messages.Infos;

import java.io.*;
import java.util.Scanner;
import java.util.zip.*;

import static App.View.Menus.kopiaZapasowaMenu;
import static App.View.Menus.przerywnik;

public class KopiaZapasowaController {
    private final Scanner scanner;
    private final EwidencjaPracownikow ewidencjaPracownikow;

    public KopiaZapasowaController(Scanner scanner, EwidencjaPracownikow ewidencjaPracownikow) {
        this.scanner = scanner;
        this.ewidencjaPracownikow = ewidencjaPracownikow;
    }

    public void kopiaZapasowaZachowajOdtworz() {
        kopiaZapasowaMenu();
        String wybor = scanner.next();
        switch (wybor.toLowerCase()) {
            case "z":
                przerywnik();
                wyborKopiaZapasowa();
                break;
            case "o":
                przerywnik();
                wyborOdczyt();
                break;
            default:
                Errors.zlyWyborError();
                break;
        }
    }

    public void wyborKopiaZapasowa() {
        Menus.wyborKompresji();
        String wybor = scanner.next();
        switch (wybor.toLowerCase()) {
            case "g":
                przerywnik();
                kopiaGzip(InputGetters.getNazwaPliku()+".gz");
                break;
            case "z":
                przerywnik();
                kopiaZip(InputGetters.getNazwaPliku()+".zip");
                break;
            default:
                Errors.zlyWyborError();
                break;
        }
    }

    public void kopiaZip(String nazwaPliku) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(nazwaPliku))) {
            ZipEntry entry = new ZipEntry(nazwaPliku + ".ser");
            zos.putNextEntry(entry);

            try (ObjectOutputStream oos = new ObjectOutputStream(zos)) {
                oos.writeObject(ewidencjaPracownikow);
                Infos.kopiaZapisanaInfo(nazwaPliku);
            }
        } catch (IOException e) {
            Errors.cosPoszloNieTakError();
        }
    }

    public void kopiaGzip(String nazwaPliku) {
        try (GZIPOutputStream gzos = new GZIPOutputStream(new FileOutputStream(nazwaPliku));
             ObjectOutputStream oos = new ObjectOutputStream(gzos)) {

            oos.writeObject(ewidencjaPracownikow);
            Infos.kopiaZapisanaInfo(nazwaPliku);

        } catch (IOException e) {
            Errors.cosPoszloNieTakError();
        }
    }
    public void wyborOdczyt(){
        Menus.wyborKompresji();
        String wybor = scanner.next();
        switch (wybor.toLowerCase()){
            case "g":
                odczytajKopieGzip(InputGetters.getNazwaPliku()+".gz");
                przerywnik();
                break;
            case "z":
                przerywnik();
                odczytajKopieZip(InputGetters.getNazwaPliku()+".zip");
                break;
            default:
                Errors.zlyWyborError();
                break;
        }
    }


    public void odczytajKopieZip(String nazwaPlikuZip) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(nazwaPlikuZip))) {
            ZipEntry entry = zis.getNextEntry();
            if (entry != null) {
                try (ObjectInputStream ois = new ObjectInputStream(zis)) {
                    Object obj = ois.readObject();
                    if (obj instanceof EwidencjaPracownikow odtworzonaEwidencja) {
                        ewidencjaPracownikow.setPracownicy(odtworzonaEwidencja.pobierzListePracownikow());
                        Infos.kopiaOdczytanaInfo(nazwaPlikuZip);
                    } else {
                        Errors.niepoprawnyFormatError();
                    }
                }
            } else {
                Errors.brakBlikuError();
            }
        } catch (IOException | ClassNotFoundException e) {
            Errors.cosPoszloNieTakError();
        }
    }

    public void odczytajKopieGzip(String nazwaPliku) {
        try (GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(nazwaPliku));
             ObjectInputStream ois = new ObjectInputStream(gzis)) {

            Object obj = ois.readObject();
            if (obj instanceof EwidencjaPracownikow odtworzonaEwidencja) {
                ewidencjaPracownikow.setPracownicy(odtworzonaEwidencja.pobierzListePracownikow());
                Infos.kopiaOdczytanaInfo(nazwaPliku);
            } else {
                Errors.zlyFormatDanychError();
            }
        } catch (IOException e) {
            Errors.cosPoszloNieTakError();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}