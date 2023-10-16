import java.lang.Object;
import javax.swing.*;
import java.awt.*;
import java.util.EventObject;
import java.awt.AWTEvent;
import java.awt.event.*;

public class Volume extends JFrame implements MouseWheelListener{
        JPanel panneau = new JPanel();
    GridLayout gestionnaire = new GridLayout(1, 10);
    public Volume(){
    setSize(1600,200);
    setLocation(0, 0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(gestionnaire);
    for(int i=0;i<10;i++){
    Cercle cercle = new Cercle(0);
    this.add(cercle);
    }
    setVisible(true);
    addMouseWheelListener(this);
    }
   public void mouseWheelMoved(MouseWheelEvent evenement){
       System.out.println(evenement.getWheelRotation());
       if(evenement.getWheelRotation()==1){
        Cercle cercle = new Cercle(1);
       }
       if(evenement.getWheelRotation()==-1){
        Cercle cercle = new Cercle(-1);
       }
   }
}
