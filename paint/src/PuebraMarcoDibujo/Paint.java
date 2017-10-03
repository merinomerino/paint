/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
