package App.Controller.FunctionControllers;

import App.Model.EwidencjaPracownikow;
import App.View.Menus;
import App.View.Messages.Errors;

import java.io.*;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static App.View.Menus.kopiaZapasowaMenu;
import static App.View.Menus.przerywnik;

public class KopiaZapasowaController {
    private final Scanner scanner;
    private final EwidencjaPracownikow ewidencjaPracownikow;

    public KopiaZapasowaController(Scanner scanner, EwidencjaPracownikow ewidencjaPracownikow) {
        this.scanner = scanner;
        this.ewidencjaPracownikow = ewidencjaPracownikow;
    }

    public void kopiaZapasowaZachowajOdtworz(){
        kopiaZapasowaMenu();
        String wybor=scanner.next();
        switch(wybor){
            case "z", "Z":
                //zachowaj
                przerywnik();
                wyborKopiaZapasowa();
                break;
            case "o", "O":
                przerywnik();
                odtworzKopieZapasowa();
                break;
            default:
                Errors.zlyWyborError();
                break;
        }

    }

    public void wyborKopiaZapasowa(){
        Menus.wyborKompresji();
        String wybor=scanner.next();
        switch(wybor){
            case "g", "G":
                przerywnik();
                kopiaGzip();
                break;
            case "z", "Z":
                przerywnik();
                kopiaZip();
                break;
            default:
                Errors.zlyWyborError();
                break;
        }

    }

    public void odtworzKopieZapasowa(){
        //todo
    }

    public void kopiaZip() {
        String nazwaPliku = "kopia.zip";
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(nazwaPliku))) {
            dodajDoZip(zos, "ewidencjaPracownikow.ser");
            System.out.println("Kopia zapasowa została wykonana w pliku " + nazwaPliku);
        } catch (IOException e) {
            Errors.bladIOError();
        }
        przerywnik();
    }

    public void kopiaGzip() {
        String nazwaPliku = "kopia.gz";
        try (FileOutputStream fos = new FileOutputStream(nazwaPliku);
             GZIPOutputStream gzos = new GZIPOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(gzos)) {

            oos.writeObject(ewidencjaPracownikow.pobierzListePracownikow());
            System.out.println("Kopia zapasowa została wykonana w pliku " + nazwaPliku);
        } catch (IOException e) {
            Errors.bladIOError();
        }
        przerywnik();
    }

    private void dodajDoZip(ZipOutputStream zos, String nazwaPliku) throws IOException {
        File plik = new File(nazwaPliku);
        try (FileInputStream fis = new FileInputStream(plik)) {
            zos.putNextEntry(new ZipEntry(plik.getName()));

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();
        }
    }
}
