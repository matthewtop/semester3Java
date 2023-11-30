import java.util.Arrays;
import java.util.List;
public class ijLoops {
    public static void main(String[] args) {
        iLoop:
        for (int i = 0; i<100; i++){
            for (int j =0; j<100; j++){
                if(j==50){
                    continue iLoop;
                }
            }
        }
    }

}
