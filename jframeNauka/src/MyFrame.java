import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){
        //podstawowe okno
        //JFrame frame = new JFrame();
        this.setTitle("Mateusz Tolpa");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);
        this.setVisible(true);

        //ikona
        ImageIcon icon = new ImageIcon("matrix.png");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.blue);

        JLabel label =new JLabel();
        label.setText("Wybierz opcje: ");
    }
}
