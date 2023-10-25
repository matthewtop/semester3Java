import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view=new View();
        Controller controller = new Controller();
//        controller.run();
        Scanner scanner = new Scanner(System.in);

        while (true){
            view.showMainMenu();
            int wybor=scanner.nextInt();
            switch (wybor){
                //FINISHED
                case 1:
                    model.setMatrix("A", controller.insertMatrix());
                    System.out.println("Macierz A wypelniona");
                    model.setMatrix("B", controller.insertMatrix());
                    System.out.println("Macierz B wypelniona");
                    continue;
                    //FINISHED
                case 2:
                    view.showSecondMenu();
                    int wybor2=scanner.nextInt();
                    switch (wybor2){
                        case 1:
                           // model.setMatrix("TA", model.transpose(model.getMatrix("A")));

                            //TODO OGARNAC TO TEZ


//                            controller.transponse(model.getMatrix(""))
//                            controller.transpose(model.getMatrix("A"));
//                            controller.transpose(model.getMatrix("B"));
//                            System.out.println("Macierze zostaly ztransponowane");
                            continue;
                        case 2:
                            //TODO: MNOZENIE MACIERZY
                            break;
                        case 3:
                            //TODO: TRANSPONUJ MACIERZ WYNIKOWA
                            break;
                        default:
                            System.err.println("Nieprawidlowy wybor");
                    }
                    break;
                case 3:
                    view.showThirdMenu();
                    int wybor3=scanner.nextInt();
                    switch (wybor3){
                        case 1:
                            System.out.println("Macierz A: ");
                            view.showMatrix(model.getMatrix("A"));
                            System.out.println("Macierz B: ");
                            view.showMatrix(model.getMatrix("B"));
                            continue;
                        case 2:
                            System.out.println("Transponowana macierz A: ");
                            view.showMatrix(model.getMatrix("TA"));
                            System.out.println("Transponowana macierz B:");
                            view.showMatrix(model.getMatrix("TB"));
//                            System.err.println("Macierz B jest pusta");
                            continue;
                        default:
                            System.err.println("Nieprawidlowe dane");
                            continue;
                    }
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Nieprawidlowe dane");
                    continue;
            }
            break;
        }
    }
}