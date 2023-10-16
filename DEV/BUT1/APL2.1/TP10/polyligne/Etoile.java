import java.awt.Point;
 
public class Etoile implements ProducteurDePoints {
  private static final int xCentre = 100;
  private static final int yCentre = 100;
  private static final double rayon = 90.0;
  private static final double angleDepart = Math.PI/4.0;
  private static final double angleIncrement = (4.0*Math.PI)/5.0;
  private double numero;
  public Etoile() {
    this.numero = 0.0;
  }
  public Point suivant() {
    Point p = null;
    if (this.numero < 6.0) {
      double angle = Etoile.angleDepart+this.numero*Etoile.angleIncrement;
      p = new Point((int) (Etoile.rayon*Math.cos(angle)),
                    (int) (Etoile.rayon*Math.sin(angle)));
      p.translate(Etoile.xCentre, Etoile.yCentre);
      this.numero++;
    } else {
      this.numero = 0.0;
    }
    return p;
  }
}