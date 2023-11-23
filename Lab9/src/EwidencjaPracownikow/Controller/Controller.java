package EwidencjaPracownikow.Controller;

import EwidencjaPracownikow.View.*;

import java.util.Scanner;

public class Controller {
    private final Scanner SCANNER;

    public Controller(Scanner scanner){
        this.SCANNER=scanner;
    }


    public void run(){
        while (true){
            Menus.mainMenu();
            chooseMainOption();
        }
    }

    public void chooseMainOption(){
        int wybor=SCANNER.nextInt();
        switch (wybor){
            case 1:
                //todo
                break;
            case 2:
                dodajPracownika();
                //todo
                break;
            case 3:
                //todo
                break;
            case 4:
                //todo
                break;
            case 5:
                System.exit(0);
                break;
            default:
                Errors.zlyWyborError();
                break;
        }
    }

    public void dodajPracownika(){
        Menus.dodajPracownikaMenu();
        String wybor=SCANNER.next();
        switch (wybor){
            case "d":
                System.out.println("wybrano dyrektora");
                //todo:
                break;
            case "h":
                //todo
                break;
            default:
                Errors.zlyWyborError();
                break;
        }


    }

}
