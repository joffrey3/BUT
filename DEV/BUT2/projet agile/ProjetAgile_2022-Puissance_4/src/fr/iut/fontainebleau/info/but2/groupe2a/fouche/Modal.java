package src.fr.iut.fontainebleau.info.but2.groupe2a.fouche;
import javax.swing.*;
import java.awt.*;
import java.io.*;
 
public class Modal extends JComponent{
    //private Color couleur;
    public Modal(Vue f) {
        JDialog popup= new JDialog(f.getFrame());
        popup.setSize(800,400);
        popup.setLocation((1920-800)/2,(1080-400)/2);
        DessinBulle bubulle= new DessinBulle();
        bubulle.setSize(800,400);
        bubulle.setLocation((1920-800)/2,(1080-400)/2);
        popup.add(bubulle);
        
        popup.setVisible(true);
    }
}