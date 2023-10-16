import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Evenement implements MouseListener{
    JFrame fenetre;
    JComponent dessin;
    Liste<Color> tab;
    public Evenement(JFrame f,JComponent d,Liste<Color> c){
        this.fenetre=f;
        this.dessin=d;
        this.tab=c;
    }
    public void mouseExited(MouseEvent e){
    
    }    
    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseReleased(MouseEvent e){
        
    }
    public void mousePressed(MouseEvent e){
        if(e.getY()>=40 && e.getY()<=130){
            Liste<Color> liste = new Liste<Color>();
            for(int i=0;i<this.tab.size();i++){
                Color couleur=this.tab.get(i);
                if(e.getX()<=30+i*60 || e.getX()>=80+i*60){
                    liste.add(couleur);
                
                }
            }
            this.tab=liste;
        }
        this.fenetre.remove(this.dessin);
        this.dessin=new Dessin(this.tab);
        this.fenetre.revalidate();
        this.fenetre.add(this.dessin);
        this.fenetre.setVisible(true);
    }
    public void mouseClicked(MouseEvent e){
        
    }
}