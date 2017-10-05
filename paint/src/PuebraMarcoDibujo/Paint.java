
package PuebraMarcoDibujo;

//import javax.swing.JComboBox;
import javax.swing.JFrame;
//import javax.swing.JPanel;

/**
 *
 * @author santo
 */
public class Paint extends JFrame {

    public static void main(String[] args) {
        Display display = new Display();
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setSize(700, 500);
        display.setVisible(true);

    }

}
