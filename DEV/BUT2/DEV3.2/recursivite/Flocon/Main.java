import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main (String[] args){
        if(args.length>=1){
        JFrame f = new JFrame();
        f.setSize(1000,1000);
        f.setLocation(0,0);
        Dessin d = new Dessin(Integer.parseInt(args[0]));
        f.add(d);
        f.setVisible(true);
        }
    }
}