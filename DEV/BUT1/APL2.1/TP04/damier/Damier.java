import javax.swing.*;
import java.awt.*;
 
public class Damier {
  public static void main(String[] args) {
    // un objet pour servir de fenetre
    JFrame fenetre = new JFrame();
    // on configure la fenetre
    int n = Integer.parseInt(args[0]);
    fenetre.setSize(100*n, 100*n);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // un composant pour afficher du texte
    Color bleu= new Color(0,0,255);
    Color blanc= new Color(255,255,255);
    GridLayout gestionnaire = new GridLayout(n, n);
    fenetre.setLayout(gestionnaire);
    for(int i = 0; i < n*n; i++){
      JTextArea etiquette = new JTextArea("");
      fenetre.add(etiquette);
      if(n%2==1){
        if(i%2==0){
          etiquette.setBackground(blanc);
        }else{
          etiquette.setBackground(bleu);
        }
      }
      if(n%2==0){
        int m=i/n;
        if(m%2==0){
          if(i%2==0){
            etiquette.setBackground(blanc);
          }else{
            etiquette.setBackground(bleu);
          }
        }
        if(m%2==1){
          if(i%2==0){
            etiquette.setBackground(bleu);
          }else{
            etiquette.setBackground(blanc);
          }
        }
      }
    }
    // et on montre le resultat
    fenetre.setVisible(true);
  }
}