package App.Controller;


import App.Model.EwidencjaPracownikow;
import App.View.Errors;
import App.View.Menus;

import java.util.Scanner;

public class DodajPracownikaController {
    private EwidencjaPracownikow ewidencja;
    private Scanner scanner;

    public DodajPracownikaController(EwidencjaPracownikow ewidencja, Scanner scanner) {
        this.ewidencja = ewidencja;
        this.scanner =scanner;
    }

    public void dodajPracownika(){
        Menus.dodajPracownikaMenu();
        String wybor=scanner.next();
        switch (wybor){
            case "d", "D":
                System.out.println("wybrano dyrektora");

                //todo:
                break;
            case "h", "H":
                //todo
                System.out.println("wybrano handlowca");
                break;
            default:
                Errors.zlyWyborError();
                break;
        }
    }
}
