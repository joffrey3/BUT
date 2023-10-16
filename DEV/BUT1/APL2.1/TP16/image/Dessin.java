import     java.lang.Object;
import     java.io.OutputStream;
import     java.io.FileOutputStream ;
import        java.io.InputStream;
import            java.io.FileInputStream;
import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font;
import java.awt.event.*; 
import   java.lang.Throwable;
import  java.lang.Exception;
import      java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.awt.image.BufferedImage;

public class Dessin extends JComponent{
    int[] x;
    int[] y;
    int n;
    public Dessin(int[] abs,int[] ord,int nombre){
	this.x=abs;
	this.y=ord;
	this.n=nombre;
     }
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    secondPinceau.fillPolygon(x,y,n);
  }
}
