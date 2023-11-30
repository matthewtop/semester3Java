import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {

    public static void setStdOut2File(String filename){
        String logFile= filename+".log";

        try{
            PrintStream out = new PrintStream(new FileOutputStream(logFile));
            System.setOut(out);
            System.setErr(out);
            System.out.println("Mateusz");
            System.err.println("Tołpa");
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        setStdOut2File("test");
    }

}