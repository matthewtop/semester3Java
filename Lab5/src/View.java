import java.util.Scanner;

public class View {

    public int getIntegerInput(String input){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        return scanner.nextInt();
    }

    public void showMainMenu() {
        System.out.println("Wybierz opcje: ");
        System.out.println("1. Wprowadz macierze wejsciowe");
        System.out.println("2. Operacje arytmetyczne ");
        System.out.println("3. Wyswietl macierze");
    }

    public void showSecondMenu() {
        System.out.println("2.1 Transponuj macierze wejsciowe");
        System.out.println("2.2 Pomnoz macierze wejsciowe ");
        System.out.println("2.3 Transponuj macierz wynikowa");
    }

    public void showEnteringMatrixes() {

    }

    public void showFinalMatrix() {

    }

    public void showMatrix(Model matrix) {
        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        for (int i = 0; i < rows ; i++) {
            for (int j=0; j<columns; j++){
                System.out.println(matrix.getValue(i,j));
            }
        }
    }
}
