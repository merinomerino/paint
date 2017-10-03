/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuebraMarcoDibujo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class MiRectangulo extends MiFiguraDelimitada {
	
	//CONSTRUCTOR sin parametros
	public MiRectangulo (){
		this( 0, 0, 0, 0, Color.BLACK, new BasicStroke(), false);
	}//fin del constructor sin parametros
	
	//CONSTRUCTOR con parametros
	public MiRectangulo ( int x1, int y1, int width, int height, Paint miColor, Stroke estilo , boolean r ){
		super( x1, y1, width, height, miColor, estilo,  r);
		
	}//fin del constructor
	
	//implementacion del metodo dibujar
	@Override
	public void dibujar ( Graphics2D g ){
		g.setPaint( obtenerColor() );
		g.setStroke( obtenerStroke() );
		
		if ( obtenerRelleno() == true )
			g.fillRect( obtenerXSupIzq(), obtenerYSupIzq(), obtenerAnchura(), obtenerAltura() );
		else
			g.drawRect( obtenerXSupIzq(), obtenerYSupIzq(), obtenerAnchura(), obtenerAltura() );
	}//fin del metodo dibujar 
	

}//fin de la clase 
