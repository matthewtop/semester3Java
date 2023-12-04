package App.Controller.FunctionControllers;

import App.Model.EwidencjaPracownikow;
import App.View.ListaPracownikowView;

import java.util.Scanner;

public class ListaPracownikowController {
    private final EwidencjaPracownikow ewidencjaPracownikow;
    private final ListaPracownikowView listaPracownikowView;

    public ListaPracownikowController(Scanner scanner, EwidencjaPracownikow ewidencjaPracownikow, ListaPracownikowView listaPracownikowView) {
        this.ewidencjaPracownikow = ewidencjaPracownikow;
        this.listaPracownikowView = listaPracownikowView;
    }

    public void wyswietlListePracownikow() {
        listaPracownikowView.wyswietlListePracownikow(ewidencjaPracownikow.pobierzListePracownikow());
    }
}
