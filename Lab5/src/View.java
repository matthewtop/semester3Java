public class View {
    public View(){}
    public void showMainMenu() {
        System.out.println("Wybierz opcje: ");
        System.out.println("1. Wprowadz macierze wejsciowe");
        System.out.println("2. Operacje arytmetyczne ");
        System.out.println("3. Wyswietl macierze");
        System.out.println("4. Wyjscie z programu");
    }
    public void showSecondMenu() {
        System.out.println("1. Transponuj macierze wejsciowe");
        System.out.println("2. Pomnoz macierze wejsciowe ");
        System.out.println("3. Transponuj macierz wynikowa");
    }

    public void showThirdMenu(){
        System.out.println("1. Wyswietl macierze wejsciowe");
        System.out.println("2. Wyswietl macierz wyjsciowa");
        System.out.println("3. Wyswietl transponowane macierze wejsciowe");
    }

}
