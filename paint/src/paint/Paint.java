/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author santo
 */
public class Paint extends JFrame {

    public static void main(String[] args) {
        Interfaz display = new Interfaz();
        display.setBounds(0, 0, 800, 500);
        display.setVisible(true);

    }

}
