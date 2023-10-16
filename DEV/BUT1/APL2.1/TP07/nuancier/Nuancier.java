import java.lang.Object;
import javax.swing.*;
import java.awt.*;
import java.awt.print.Paper;

public class Nuancier extends Color {
  // attribut
  public Nuancier(int rgb) {
    super((int)rgb);
  }
  public static void main(String[] args) {
    Color bleu= new Color(0,0,255);
    Color vert= new Color(0,255,0);
    Color rouge= new Color(255,0,0);
    //Color couleur= new Color(args[1]);
    JFrame fenetre = new JFrame();
    fenetre.setLayout(null);
    fenetre.setSize(1920,1080);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Color couleur= new Color();
    //System.out.println(args.length);
    String hexa= new String("0123456789ABCDEF");
    int r=0, g=0, b=0;
    for(int k=0;k<args.length;k++){
      r=0;
      g=0;
      b=0;
      for (int j=1; j<args[k].length();j++){
        for (int i=0; i<16;i++){
          if(args[k].charAt(j)==hexa.charAt(i)){
            switch(j){
              case 1: r=r+i*16;
              break;
              case 2: r=r+i;
              break;
              case 3: g=g+i*16;
              break;
              case 4: g=g+i;
              break;
              case 5: b=b+i*16;
              break;
              case 6: b=b+i;
              break;
            }
          }
        }
      }
      Color couleur= new Color(r,g,b);
      String texte = new String(r+", "+g+", "+b);
      System.out.println(texte);
      Nuance premier = new Nuance();
      premier.Case(fenetre,couleur,k,texte);
    }
    // et on montre le resultat
    fenetre.setVisible(true);
  }
}
