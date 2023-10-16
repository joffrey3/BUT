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
  @Override
  protected void paintComponent(Graphics pinceau) {
    Graphics secondPinceau = pinceau.create();
    int i,j;
    for(i=0;i<1000;i=i+100){
      for(j=0;j<1000;j=j+100){
        secondPinceau.setColor(new Color(0,0+j/5,0+i/5));
        secondPinceau.fillOval(i,j,100,100);
        secondPinceau.setColor(new Color(255,255,255));
        secondPinceau.fillOval(i+25,j+25,50,50);
      }
    }
  }
}