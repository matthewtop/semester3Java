import java.util.Scanner;

public class View {
    private Controller controller;

    public View(){}
    //private Scanner scanner;
    public void showMainMenu() {
        System.out.println("Wybierz opcje: ");
        System.out.println("1. Wprowadz macierze wejsciowe");
        System.out.println("2. Operacje arytmetyczne ");
        System.out.println("3. Wyswietl macierze");
        System.out.println("4. Wyjscie z programu");
//        controller.chooseMainOption();
    }
    public void showSecondMenu() {
        System.out.println("1. Transponuj macierze wejsciowe");
        System.out.println("2. Pomnoz macierze wejsciowe ");
        System.out.println("3. Transponuj macierz wynikowa");
    }

    public void showThirdMenu(){
        System.out.println("1. Wyswietl macierze wejsciowe");
        System.out.println("2. Wyswietl macierze wyjsciowe");
    }

    public void showMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }


}
