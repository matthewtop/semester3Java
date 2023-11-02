import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;
    private final Scanner scanner;

    public Controller(Model model, View view, Scanner scanner){
        this.model=model;
        this.view=view;
        this.scanner=scanner;
    }

    public void run(){
        while (true) {
            view.showMainMenu();
            chooseMainOption();
        }
    }

    public void chooseMainOption(){
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                createEnteringMatrixes();
                break;
            case 2:
                chooseSecondOption();
                break;
            case 3:
                chooseThirdOption();
                break;
            case 4:
                System.exit(0);
            default:
                System.err.println("Wrong data");
                break;
        }
    }

    public void createEnteringMatrixes(){
        model.setMatrix("A",insertMatrix());
        model.setMatrix("B",insertMatrix());
    }

    public void chooseSecondOption(){
        view.showSecondMenu();
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                transposeMatrixesAandB();
                break;
            case 2:
                model.setMatrix("C",multiply(model.getMatrix("A"), model.getMatrix("B")));
                break;
            case 3:
                model.setMatrix("TC", transpose(model.getMatrix("C")));
                break;
            default:
                System.err.println("Wrong data");
                break;
        }
    }
    public void transposeMatrixesAandB(){
        model.setMatrix("TA", transpose(model.getMatrix("A")));
        model.setMatrix("TB", transpose(model.getMatrix("B")));
    }

    public void chooseThirdOption(){
        view.showThirdMenu();
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                showAandB();
                break;
            case 2:
                showMatrix(model.getMatrix("C"));
                break;
            case 3:
                showTransposedAandB();
                break;
            default:
                System.err.println("Wrong data");
                break;
        }
    }

    public void showAandB(){
        System.out.println("Macierz A: ");
        showMatrix(model.getMatrix("A"));
        System.out.println("Macierz B: ");
        showMatrix(model.getMatrix("B"));
    }
    public void showTransposedAandB(){
        System.out.println("Transponowana macierz A: ");
        showMatrix(model.getMatrix("TA"));
        System.out.println("Transponowana macierz B: ");
        showMatrix(model.getMatrix("TB"));
    }

    public int[][] insertMatrix(){
        System.out.println("Liczba wierszy: ");
        int rows=scanner.nextInt();
        System.out.println("Liczba kolumn: ");
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        System.out.println("Wprowadz wartosci: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element [" +(i+1) + "]" + (j+1) + "]: " );
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public void showMatrix(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0){
            System.err.println("Macierz jest pusta");
        }
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public int [][] transpose(int[][]matrix){
        int rows=matrix.length;
        int columns=matrix[0].length;
        int [][]transposed = new int[columns][rows];
        for (int i=0; i<rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public int [][] multiply(int [][]matrixA, int[][]matrixB) {
        int[][] matrixCtemp = new int[matrixA.length][matrixB.length];
        if (matrixA[0].length == matrixB.length) {
            for (int i = 0; i < matrixCtemp.length; i++) {
                for (int j = 0; j < matrixCtemp.length; j++) {
                    for (int k = 0; k < matrixA[0].length; k++) {
                        matrixCtemp[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }
        } else {
            System.err.println("Nieprawidlowy wymiar macierzy");
        }
        return matrixCtemp;
    }
}
