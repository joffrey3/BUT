import java.awt.Color;
import java.util.*;
import javax.swing.*;

public class Fenetre {
    public Fenetre(){
        JFrame w1= new JFrame();
        w1.setSize(800,200);
        w1.setLocation(300,500);
        Liste<Color> tab = new Liste<Color>();
        addColor(10,tab);
        Dessin d1= new Dessin(tab);
        w1.add(d1);
        w1.setVisible(true);
        w1.addMouseListener(new Evenement(w1,d1,tab));
    }
    public void addColor(int i,Liste<Color> tab){
        Random alea = new Random();
        int nb1 = alea.nextInt(255);
        int nb2 = alea.nextInt(255);
        int nb3 = alea.nextInt(255);
        tab.add(new Color(nb1,nb2,nb3));
        if(i>1){
            this.addColor(i-1,tab);
        }
    }
}