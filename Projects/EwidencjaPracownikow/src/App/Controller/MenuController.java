package App.Controller;

import App.Controller.FunctionControllers.DodajPracownikaController;
import App.Controller.FunctionControllers.KopiaZapasowaController;
import App.Controller.FunctionControllers.ListaPracownikowController;
import App.Controller.FunctionControllers.UsunPracownikaController;
import App.Model.EwidencjaPracownikow;
import App.View.Errors;
import App.View.ListaPracownikowView;
import App.View.Menus;

import java.util.Scanner;

public class MenuController {
    private final Scanner scanner;
    private DodajPracownikaController dodajPracownikaController;
    private UsunPracownikaController usunPracownikaController;
    private KopiaZapasowaController kopiaZapasowaController;
    private ListaPracownikowController listaPracownikowController;

    public MenuController(Scanner scanner){
        this.scanner = scanner;
        init();
    }

    private void init(){
        EwidencjaPracownikow ewidencja = new EwidencjaPracownikow();
        ListaPracownikowView listaPracownikowView = new ListaPracownikowView(scanner);

        listaPracownikowController =new ListaPracownikowController(ewidencja,listaPracownikowView);
        dodajPracownikaController = new DodajPracownikaController(scanner,ewidencja);
        usunPracownikaController = new UsunPracownikaController(scanner);
        kopiaZapasowaController = new KopiaZapasowaController(scanner);
    }

    public void run(){
        while (true){
            chooseMainOption();
        }
    }

    public void chooseMainOption(){
        Menus.mainMenu();
        int wybor=scanner.nextInt();
        scanner.nextLine();
        switch (wybor){
            case 1:
                listaPracownikowController.wyswietlListePracownikow();
                break;
            case 2:
                dodajPracownikaController.dodajPracownika();
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
