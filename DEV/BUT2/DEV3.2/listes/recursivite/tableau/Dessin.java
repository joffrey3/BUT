import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Dessin extends JComponent{
    Liste <Color> tab;
    //Iterator<Color> ite;
    public Dessin(Liste <Color> t){
        this.tab=t;
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();
        int i,j;
        if(this.tab.size()!=0){
            this.dessiner(0,secondPinceau);
        }
    }
    public void dessiner(int i,Graphics secondPinceau){
        final int nbPoints=4;
        int[] tab_x = {30+i*60,80+i*60,60+i*60,10+i*60};
        int[] tab_y = {10,10,100,100};
        secondPinceau.setColor(this.tab.get(i));
        secondPinceau.fillPolygon(tab_x,tab_y,nbPoints);
        secondPinceau.setColor(Color.BLACK);
        secondPinceau.drawPolygon(tab_x,tab_y,nbPoints);
        if(i<this.tab.size()-1){
            dessiner(i+1,secondPinceau);
        }
    }
}