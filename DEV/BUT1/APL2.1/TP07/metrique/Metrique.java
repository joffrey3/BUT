import java.lang.Object;
import javax.swing.*;
import java.awt.*;
import java.awt.print.Paper;

public class Metrique extends Paper {
  // attribut
  public Metrique() {
    super();
    JFrame fenetre = new JFrame();
    // on configure la fenetre
    fenetre.setSize(1920,1080);
    fenetre.setLocation(0, 0);
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // un composant pour afficher du texte
    Color gris= new Color(128,128,128);
    Color blanc= new Color(255,255,255);
    fenetre.setLayout(null);
    JTextArea un = new JTextArea("1");
    un.setSize(500, 100);
    un.setLocation(0, 0);
    un.setBackground(gris);
    fenetre.add(un);
    JButton deux = new JButton("2");
    deux.setSize(100,500);
    deux.setLocation(400, 100);
    fenetre.add(deux);
    JButton trois = new JButton("3");
    trois.setSize(500, 100);
    trois.setLocation(0,600);
    fenetre.add(trois);
    JButton quatre = new JButton("4");
    quatre.setSize(100,500);
    quatre.setLocation(0,100);
    fenetre.add(quatre);
    JButton cinq = new JButton("5");
    cinq.setSize(Metrique.getHeight(),Metrique.getWidth());
    cinq.setLocation(100, 100);
    fenetre.add(cinq);
    // et on montre le resultat
    fenetre.setVisible(true);
  }
    public double getMetric(double  pouce){
	     return 10*pouce/25.4;
    }
    public double setMetric(double  millimetre){
	     return 25.4*millimetre/10;
    }
    /*public double getPixel(double  pixel){
       return pixel;
    }
    public double setPixel(double  millimetre){
       return 25.4*millimetre/1250*33;
    }*/
    @Override
    public double getHeight(){
      return getMetric(super.getHeight());
    }
    @Override
    public double getWidth(){
      return getMetric(super.getWidth());
    }
    @Override
    public double getImageableHeight(){
      return getMetric(super.getImageableHeight());
    }
    @Override
    public double getImageableWidth(){
      return getMetric(super.getImageableWidth());
    }
        @Override
    public double getImageableX(){
      return getMetric(super.getImageableX()-72);
    }
    @Override
    public double getImageableY(){
      return getMetric(super.getImageableY()-72);
    }
  public static void main(String[] args) {
    Metrique k= new  Metrique();
    System.out.println(k.getHeight());
    System.out.println(k.getWidth());
    System.out.println(k.getImageableHeight());
    System.out.println(k.getImageableWidth());
    System.out.println(k.getImageableX());
    System.out.println(k.getImageableY());
    System.out.println(k.getHeight());
    System.out.println(1);
  }
}
