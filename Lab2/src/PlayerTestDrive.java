 class Player {
    static int playerCount = 0;
    private String name;

    public Player(String n){
        name =n;
        playerCount++;
    }
}

public class PlayerTestDrive{
    public static void main(String[] args) {
        //int[] []x[];a
//        int *x;
//        int x[5];
//        int[] x = {1,2,3};
//        int x[];
//        []int x[];



        System.out.println(Player.playerCount);
        Player one = new Player("Tommy");
        System.out.println(Player.playerCount);
    }
}
