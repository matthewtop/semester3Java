package App.Controller;

import App.Model.EwidencjaPracownikow;
import App.View.Errors;

import java.util.Scanner;

import static App.View.Menus.kopiaZapasowaMenu;
import static App.View.Menus.przerywnik;

public class KopiaZapasowaController {
    private EwidencjaPracownikow ewidencja;
    private Scanner scanner;

    public KopiaZapasowaController(EwidencjaPracownikow ewidencja, Scanner scanner) {
        this.ewidencja = ewidencja;
    }

    public void kopiaZapasowa(){
        kopiaZapasowaMenu();
        String wybor=scanner.next();
        switch(wybor){
            case "z", "Z":
                przerywnik();
                break;
            case "o", "O":
                przerywnik();
                break;
            default:
                Errors.zlyWyborError();
                break;
        }

    }
}
