/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author santo
 */
public class Interfaz extends JFrame {

    private JComboBox combo1, combo2, combo3;
    private JButton num1,num2;
    private JRadioButton radio1;
    

    public Interfaz() {
        setLayout(null);
        String[] ColorsOptions = {"Red", "Green"};
        String[] FigOptions = {"Circulo", "Rectangulo","Linea"};
        
        num1=new JButton("Undo");
        num1.setBounds(10,10, 80, 30);
        add(num1);
        
        
        num2=new JButton("Clear");
        num2.setBounds(100,10, 80, 30);
        add(num2);
        
        combo1 = new JComboBox(ColorsOptions);
        combo1.setBounds(200, 10, 100, 30);
        add(combo1);
        
        combo2 = new JComboBox(FigOptions);
        combo2.setBounds(310, 10, 100, 30);
        add(combo2);
        
        radio1=new JRadioButton("Filled");
        radio1.setBounds(415,10, 100, 30);
        add(radio1);
        

    }

}
