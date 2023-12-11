package App.Controller.FunctionControllers;

import App.Model.EwidencjaPracownikow;
import App.View.Menus;
import App.View.Messages.Errors;

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
                zapiszKopieZapasowa("kopia.ser");
                kopiaGzip("kopia.gz");
                break;
            case "z":
                przerywnik();
                zapiszKopieZapasowa("kopia.ser");
                kopiaZip("kopia.ser");
                break;
            default:
                Errors.zlyWyborError();
                break;
        }
    }

    public void wyborOdczyt(){
        Menus.wyborKompresji();
        String wybor = scanner.next();
        switch (wybor.toLowerCase()){
            case "g":
                odczytajKopieGzip("kopia.gz");
                odczytajKopieZapasowa("kopia.ser");
                przerywnik();
                break;
            case "z":
                przerywnik();
                odczytajKopieZip("kopia.zip");
                odczytajKopieZapasowa("kopia.ser");
                break;
            default:
                Errors.zlyWyborError();
                break;
        }
    }

    public void zapiszKopieZapasowa(String nazwaPliku) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("kopia.ser"))) {
            oos.writeObject(ewidencjaPracownikow);
            System.out.println("Kopia zapasowa została zapisana do pliku " + nazwaPliku);
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    public void odczytajKopieZapasowa(String nazwaPliku) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nazwaPliku))) {
            Object obj = ois.readObject();
            if (obj instanceof EwidencjaPracownikow) {
                EwidencjaPracownikow odtworzonaEwidencja = (EwidencjaPracownikow) obj;
                ewidencjaPracownikow.setPracownicy(odtworzonaEwidencja.pobierzListePracownikow());
                System.out.println("Odtworzono kopię zapasową z pliku " + nazwaPliku);
            } else {
                System.out.println("Błąd: Niepoprawny format pliku.");
            }
        } catch (IOException e) {
            handleIOException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void kopiaZip(String nazwaPliku) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("kopia.zip"))) {
            ZipEntry entry = new ZipEntry("kopia.ser");
            zos.putNextEntry(entry);

            try (ObjectOutputStream oos = new ObjectOutputStream(zos)) {
                oos.writeObject(ewidencjaPracownikow);
                zos.closeEntry();
                System.out.println("Kopia zapasowa została zapisana do pliku kopia.zip");
            }
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    public void odczytajKopieZip(String nazwaPlikuZip) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(nazwaPlikuZip))) {
            ZipEntry entry = zis.getNextEntry();
            if (entry != null && entry.getName().equals("kopia.ser")) {
                try (ObjectInputStream ois = new ObjectInputStream(zis)) {
                    Object obj = ois.readObject();
                    if (obj instanceof EwidencjaPracownikow) {
                        EwidencjaPracownikow odtworzonaEwidencja = (EwidencjaPracownikow) obj;
                        ewidencjaPracownikow.setPracownicy(odtworzonaEwidencja.pobierzListePracownikow());
                        System.out.println("Odtworzono kopię zapasową z pliku " + nazwaPlikuZip);
                    } else {
                        System.out.println("Błąd: Niepoprawny format pliku w archiwum ZIP.");
                    }
                }
            } else {
                System.out.println("Błąd: Brak pliku 'kopia.ser' w archiwum ZIP.");
            }
        } catch (IOException | ClassNotFoundException e) {
            handleIOException((IOException) e);
        }
    }

    public void kopiaGzip(String nazwaPliku) {
        try (GZIPOutputStream gzos = new GZIPOutputStream(new FileOutputStream(nazwaPliku));
             ObjectOutputStream oos = new ObjectOutputStream(gzos)) {

            oos.writeObject(ewidencjaPracownikow);
            System.out.println("Kopia zapasowa została zapisana do pliku " + nazwaPliku);
        } catch (IOException e) {
            handleIOException(e);
        }
    }
    public void odczytajKopieGzip(String nazwaPliku) {
        try (GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(nazwaPliku));
             ObjectInputStream ois = new ObjectInputStream(gzis)) {

            Object obj = ois.readObject();
            if (obj instanceof EwidencjaPracownikow) {
                EwidencjaPracownikow odtworzonaEwidencja = (EwidencjaPracownikow) obj;
                ewidencjaPracownikow.setPracownicy(odtworzonaEwidencja.pobierzListePracownikow());
                System.out.println("Odtworzono kopię zapasową z pliku " + nazwaPliku);
            } else {
                System.out.println("Błąd: Niepoprawny format pliku GZIP.");
            }
        } catch (IOException | ClassNotFoundException e) {
            handleIOException((IOException) e);
        }
    }



    private void handleIOException(IOException e) {
        e.printStackTrace();
        Errors.IOError();
    }
}