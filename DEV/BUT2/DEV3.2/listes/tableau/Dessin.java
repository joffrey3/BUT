import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Dessin extends JComponent{
    Tableau <Color> tab;
    //Iterator<Color> ite;
    public Dessin(Tableau <Color> t){
        this.tab=t;
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
        final int nbPoints=4;
        Graphics secondPinceau = pinceau.create();
        int i,j;
        for(i=0,j=0;i/100<this.tab.size();i=i+100,j=j+10){
            int[] tab_x = {30+i/2+j,80+i/2+j,60+i/2+j,10+i/2+j};
            int[] tab_y = {10,10,100,100};
            secondPinceau.setColor(this.tab.get(i/100));
            secondPinceau.fillPolygon(tab_x,tab_y,nbPoints);
            secondPinceau.setColor(Color.BLACK);
            secondPinceau.drawPolygon(tab_x,tab_y,nbPoints);
        }
  }
}