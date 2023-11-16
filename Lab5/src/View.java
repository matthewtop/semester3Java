public class View {
    private final Model model;

    public View(Model model){
        this.model = model;
    }
    public static void showMainMenu() {
        System.out.println("|===================================================|");
        System.out.println("|                   Wybierz opcje:                  |");
        System.out.println("|===================================================|");
        System.out.println("|         1. Wprowadz macierze wejsciowe            |");
        System.out.println("|         2. Operacje arytmetyczne                  |");
        System.out.println("|         3. Wyswietl macierze                      |");
        System.out.println("|         4. Wyjscie z programu                     |");
        System.out.println("|===================================================|");
        System.out.println();
        System.out.print("Twoj wybor:    ");

    }
    public static void showSecondMenu() {
        System.out.println("|===================================================|");
        System.out.println("|           1. Transponuj macierze wejsciowe        |");
        System.out.println("|           2. Pomnoz macierze wejsciowe            |");
        System.out.println("|           3. Transponuj macierz wynikowa          |");
        System.out.println("|===================================================|");
        System.out.println();
        System.out.print("Twoj wybor:    ");
    }

    public static void showThirdMenu(){
        System.out.println("|===================================================|");
        System.out.println("|   1. Wyswietl macierze wejsciowe                  |");
        System.out.println("|   2. Wyswietl macierz wyjsciowa                   |");
        System.out.println("|   3. Wyswietl transponowane macierze wejsciowe    |");
        System.out.println("|===================================================|");
        System.out.println();
        System.out.print("Twoj wybor:    ");
    }

    public static void wrongChoiceError(){System.err.println("Zly wybor");}
    public static void wrongMatrixSizeError(){System.err.println("Nieprawidlowy wymiar macierzy");}
    public static void matrixIsEmptyError(){System.err.println("Macierz jest pusta");}

    public static void howManyColumns(){System.out.println("Liczba kolumn: ");}
    public static void howManyRows(){System.out.println("Liczba wierszy: ");}

    public static void getValues(){System.out.println("Wprowadz wartosci: ");}

    public void displayMatrix(String name){
        switch(name){
            case "A":{
                System.out.println("Macierz A: ");
                Controller.showMatrix(model.getMatrix("A"));
                break;
            }
            case "B":{
                System.out.println("Macierz B: ");
                Controller.showMatrix(model.getMatrix("B"));
                break;
            }
            case "C":{
                System.out.println("Macierz C: ");
                Controller.showMatrix(model.getMatrix("C"));
                break;
            }
            case "TA":{
                System.out.println("Transponowana macierz A: ");
                Controller.showMatrix(model.getMatrix("TA"));
                break;
            }
            case "TB":{
                System.out.println("Transponowana macierz B: ");
                Controller.showMatrix(model.getMatrix("TB"));
                break;
            }
            case "TC":{
                System.out.println("Transponowana macierz C: ");
                Controller.showMatrix(model.getMatrix("TC"));
                break;
            }
        }
    }





}
