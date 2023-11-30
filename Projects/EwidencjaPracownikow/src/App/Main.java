package App;

import App.Controller.DodajPracownikaController;
import App.Controller.MenuController;
import App.Model.EwidencjaPracownikow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EwidencjaPracownikow ewidencja = new EwidencjaPracownikow();
        Scanner scanner= new Scanner(System.in);
        MenuController controller=new MenuController(scanner);

        controller.run();
    }
}