import java.lang.Object;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;


public class Grisaille extends Color{
  // attribut
  private int couleur;
  public Grisaille(int pixel) {
      super((int)pixel,(int)pixel,(int)pixel);
      this.couleur=pixel;
  }
   @Override
  public String toString(){
      return "("+this.couleur+","+this.couleur+","+this.couleur+")";
  }
  // méthode
  public static void main(String[] args) {
    JFrame fenetre = new JFrame();
    fenetre.setSize(1000, 1000);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    String nombre = args[0];
    Grisaille k= new  Grisaille(Integer.parseInt(nombre));
    k.couleur = Integer.parseInt(nombre);
    System.out.println(k.toString());
    JTextArea etiquette = new JTextArea("");
    Color coul= new Color(k.couleur,k.couleur,k.couleur);
    etiquette.setBackground(coul);
    fenetre.add(etiquette);
    fenetre.setVisible(true);
  }
}
