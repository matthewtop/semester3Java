package App.Controller;

import App.Model.EwidencjaPracownikow;
import App.View.*;
import java.util.Scanner;


public class MenuController {
    private final Scanner scanner;
    private DodajPracownikaController dodajPracownikaController;
    private UsunPracownikaController usunPracownikaController;
    private KopiaZapasowaController kopiaZapasowaController;

    public MenuController(Scanner scanner){
        this.scanner = scanner;
    }



    public void run(){
        EwidencjaPracownikow ewidencja = new EwidencjaPracownikow();
        dodajPracownikaController = new DodajPracownikaController(ewidencja, scanner);
        usunPracownikaController = new UsunPracownikaController(ewidencja,scanner);
        kopiaZapasowaController = new KopiaZapasowaController(ewidencja,scanner);


        while (true){
            Menus.mainMenu();
            chooseMainOption();
        }
    }

    public void chooseMainOption(){
        int wybor=scanner.nextInt();
        switch (wybor){
            case 1:
                //todo
                break;
            case 2:
                dodajPracownikaController.dodajPracownika();
                //todo
                break;
            case 3:
                usunPracownikaController.usunPracownika();
                //todo
                break;
            case 4:
                //todo
                kopiaZapasowaController.kopiaZapasowa();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                Errors.zlyWyborError();
                break;
        }
    }






}
