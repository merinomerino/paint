/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuebraMarcoDibujo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel {

    private Figura[] figuras;//variable de arreglo firguras

    //variables para cada tipo de firgura
    private static final int LINEAS = 0;
    private static final int OVALOS = 1;
    private static final int RECTANGULOS = 2;

    //varaibles de instancia nuevas 
    private int cuentaFiguras;//cuenta el numero de figuras en el arreglo

    private int tipoFigura;//determina el tipo de figura a dibujar

    private Figura figuraActual;//figura actual que esta dibujando el usuario

    private Paint color1, color2, colorDegradado, colorActual;//color del dibujo actual

    private Stroke trazoActual;

    private boolean figuraRellena;//determina si se va dibujar una figura rellena
private boolean seDibujo;

    private int anchuraLinea;//anchura de linea 

    private int x1, y1, x2, y2;// 

    //constructor , crea un panel con figuras al azar 
    public PanelDibujo(JLabel etiqueta) {
        figuras = new Figura[100];//incializa arreglo con 100 entradas

        cuentaFiguras = 0;

        tipoFigura = LINEAS;

        figuraActual = null;

        color1 = Color.BLACK;

        this.setBackground(Color.WHITE);

        ManejadorEventos manejador = new ManejadorEventos();

        this.addMouseListener(manejador);
        this.addMouseMotionListener(manejador);

    }//fin del constructor

    @Override//anotacion que asegura que los metodos se sobrescriban con los de la superclase

    //para cada arreglo de figuras , dibuja las figuras individuales
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //usar  variables cuentaFiguras para deerminar cuantas figuras hay que dibujar
        Graphics2D g2d = (Graphics2D) g;

        //pendiente checar
        for (int f = 0; f < cuentaFiguras; f++) {
            if (figuras[f] != null) {
                figuras[f].dibujar(g2d);
            }

        }

        if (seDibujo) {
            figuraActual.dibujar(g2d);
        }

    }//fin del metodo paintComponent

    //clase privada
    private class ManejadorEventos extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent e) {
            switch (tipoFigura) {
                case LINEAS:
                    figuraActual = new MiLinea(e.getX(), e.getY(), e.getX(), e.getY(), colorActual, trazoActual);
                    x1 = e.getX();
                    y1 = e.getY();
                    break;
                case OVALOS:
                    figuraActual = new MiOvalo(e.getX(), e.getY(), e.getX(), e.getY(), colorActual, trazoActual, figuraRellena);
                    x1 = e.getX();
                    y1 = e.getY();
                    break;
                case RECTANGULOS:
                    figuraActual = new MiRectangulo(e.getX(), e.getY(), e.getX(), e.getY(), colorActual, trazoActual, figuraRellena);
                    x1 = e.getX();
                    y1 = e.getY();
                    break;
            }//fin de switch que creador de objetos figura de clases concretas

            seDibujo = true;

        }//fin de metodo mousePressed

//        @Override ///checar///
//        public void mouseReleased(MouseEvent e) {
//
//            //establece los puntos finales 
//            //figuraActual.establecerX1(x1);
//            //figuraActual.establecerY1(x2);
//            figuraActual.establecerX2(e.getX());
//            figuraActual.establecerY2(e.getY());
//
//            //agrega la figura al arreglo
//            figuras[cuentaFiguras++] = figuraActual;
//
//            repaint();
//
//            //establece figura actual a null
//            figuraActual = null;
//
//            seDibujo = false;
//        }//fin de metodo mouseReleased
        public void mouseDragged(MouseEvent e) {
            figuraActual.establecerX2(e.getX());
            figuraActual.establecerY2(e.getY());

            repaint();

        }//fin del metodo mouseDragged

    }//fin de la clase interna ManejadorEventos

    public void establecerTipoFigura(int tF) {
        tipoFigura = tF;
    }

    public void establecerColor1(Color c) {
        color1 = c;
    }

//    public void establecerColor2(Color c) {
//        color2 = c;
//    }
    public void establecerTrazoActual(Stroke s) {
        trazoActual = s;
    }

    public void establecerFiguraRellena(boolean fR) {
        figuraRellena = fR;
    }

//    public void establecerDegradado(boolean d) {
//        degradado = d;
//    }//fin de metodo establecerDegradado
//    public void establecerLineaPunteada(boolean l) {
//        lineaPunteada = l;
//    }
    public void establecerAnchuraLinea(int anchura) {
        anchuraLinea = anchura;
    }

    //borra la ultima figura dibujada
    public void borrarUltimaFigura() {
        --cuentaFiguras;
        if (cuentaFiguras < 0) {
            cuentaFiguras = 0;
            JOptionPane.showMessageDialog(null, "Ya no hay mas figuras por borrar!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        repaint();//acgtualiza la pantalla
    }//fin de metodo borrarUltimaFIgura

    //elimina todas las figuras del dibujo actual
    public void borrarDibujo() {
        cuentaFiguras = 0;
        repaint();//acgtualiza la pantalla
    }

}//fin de la clase PanelDibujo