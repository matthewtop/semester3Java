package App.Controller.FunctionControllers;

import App.View.Messages.Errors;

import java.util.Scanner;

import static App.View.Menus.kopiaZapasowaMenu;
import static App.View.Menus.przerywnik;

public class KopiaZapasowaController {
    private final Scanner scanner;

    public KopiaZapasowaController(Scanner scanner) {
        this.scanner = scanner;
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
