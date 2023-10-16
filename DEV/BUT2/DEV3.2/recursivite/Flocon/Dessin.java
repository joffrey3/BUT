import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Dessin extends JComponent{
    Polygon p;
    public Dessin(int arguments){
        Flocon flocon = new Flocon();
        LinkedList<Point> liste=new LinkedList<Point>();
        this.p=flocon.ordre(arguments,liste);
    }
    @Override
    protected void paintComponent(Graphics pinceau) {
        Graphics secondPinceau = pinceau.create();
        secondPinceau.drawPolygon(this.p);
        
    }
}