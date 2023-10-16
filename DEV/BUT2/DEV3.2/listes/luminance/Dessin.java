import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Dessin extends JComponent{
    List <Color> tab;
    Iterator<Color> ite;
    public Dessin(List <Color> t){
        this.tab=t;
        this.ite=this.tab.iterator();
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
        final int nbPoints=4;
        Graphics secondPinceau = pinceau.create();
        int i,j;
        for(i=0,j=0;this.ite.hasNext();i=i+100,j=j+10){
            int[] tab_x = {30+i/2+j,80+i/2+j,60+i/2+j,10+i/2+j};
            int[] tab_y = {10,10,100,100};
            secondPinceau.setColor(this.ite.next());
            secondPinceau.fillPolygon(tab_x,tab_y,nbPoints);
            secondPinceau.setColor(Color.BLACK);
            secondPinceau.drawPolygon(tab_x,tab_y,nbPoints);
        }
  }
}