package App.Controller;


import App.View.Errors;
import App.View.Menus;

import java.util.Scanner;

public class DodajPracownikaController {
    private final Scanner scanner;

    public DodajPracownikaController(Scanner scanner) {
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
