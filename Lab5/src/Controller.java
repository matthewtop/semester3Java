import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private Scanner scanner;

    public Controller(){}

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



   // public Controller(){}

    public void chooseMainOption(){
        int wybor=scanner.nextInt();
        switch (wybor){
            case 1:
                model.setMatrix("A",insertMatrix());
                model.setMatrix("B",insertMatrix());
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

    public void chooseSecondOption(){
        view.showSecondMenu();
        int wybor=scanner.nextInt();
        switch (wybor){
            case 1:
                model.setMatrix("TA", transpose(model.getMatrix("A")));
                model.setMatrix("TB", transpose(model.getMatrix("B")));
                break;
            case 2:
                //TODO MNOZENIE
                break;
            case 3:
                //todo
                break;
            default:
                System.err.println("Wrong data");
                break;

        }


    }

    public void chooseThirdOption(){
        view.showThirdMenu();
        int wybor=scanner.nextInt();
        switch (wybor){
            case 1:
                view.showMatrix(model.getMatrix("A"));
                view.showMatrix(model.getMatrix("B"));
                break;
            case 2:
                view.showMatrix(model.getMatrix("TA"));
                view.showMatrix(model.getMatrix("TB"));
                break;
            default:
                System.err.println("Wrong data");
                break;
        }


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

    public int [][] multiply(){
        return null;
    }





}
