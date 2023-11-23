package EwidencjaPracownikow.View;

public class Menus {
    public static void mainMenu(){
        System.out.println("MENU");
        System.out.println("   1.  Lista pracowników");
        System.out.println("   2.  Dodaj pracownika");
        System.out.println("   3.  Usuń pracownika");
        System.out.println("   4.  Kopia zapasowa");
        System.out.println("   5.  Koniec pracy programu");
        System.out.println();
        System.out.print("Wybor>");
    }

    public static void dodajPracownikaMenu(){
        System.out.println("2. Dodaj pracownika");
        System.out.println(" [D]yrektor/[H]andlowiec:     ");
    }

    public static void kopiaZapasowaMenu(){
        System.out.println("4.  Kopia zapasowa");
        System.out.println();
        System.out.println("[Z]achowaj/[O]dtwórz        :       ");
    }

    public static void kopiaZapasowaZachowajMenu(){
        System.out.println("------------------------------------------------");
        System.out.println("Kompresja [G]zip/[Z]ip      :         ");
        System.out.println("Nazwa pliku                 :         ");
        System.out.println("------------------------------------------------");
        System.out.println("[Enter] - potwierdź");
        System.out.println("[Q] - porzuć");
    }

    public void listaPracownikowDyrektor(){
        System.out.println("1. Lista pracowników ");
        System.out.println("  Identyfikator PESEL           :");
        System.out.println("  Imię:                         :");
        System.out.println("  Nazwisko                      :");
        System.out.println("  Wynagrodzenie:                :");
        System.out.println("  Telefon służbowy numer        :");
        System.out.println("  Dodatek służbowy (zł)         :");
        System.out.println("  Karta służbowa numer          :");
        System.out.println("  Limit kosztów/miesiąc(zł)     :");
        System.out.println();
        System.out.println("                                             [Pozycja: "   );
        System.out.println("[Enter] -  następny");
        System.out.println("[Q] - powrót");
    }

    public static void main(String[] args) {
    }
}
