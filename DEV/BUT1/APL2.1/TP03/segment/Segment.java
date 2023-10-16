import java.awt.Point;

public class Segment {
  private Point pointA;
  private Point pointB;
  public Segment(Point pointC,Point pointD){
    this.pointA = pointC;
    this.pointB = pointD;
  }
//  public Segment(int a,int b, int c,int d){
//    this.pointA.x = a;
//    this.pointA.y = b;
//    this.pointB.x = c;
//    this.pointB.y = d;
//  }
  // attribut
  public String toString() {
    return "("+this.pointA.x+","+this.pointA.y+"),("+this.pointB.x+","+this.pointB.y+")";
  }
  // méthode
  public int longueurSegment() {
    int x1=this.pointA.x;
    int y1=this.pointA.y;
    int x2=this.pointB.x;
    int y2=this.pointB.y;
    int x=0;
    int y=0;
    if (x1>=x2){
      x=x1-x2;
    }if (x1<x2){
      x=x2-x1;
    }
    if (y1>=y2){
      y=y1-y2;
    }if (y1<y2){
      y=y2-y1;
    }
    int longueurCarre=x*x+y*y;
    int longueur=longueurCarre;
    return longueur;
  }
  // autre méthode
  public void ChangerPoint(Point pointC, Point pointD) {
    if (this.pointA.x==pointC.x && this.pointA.y==pointC.y){
      this.pointA.x=pointD.x;
      this.pointA.y=pointD.y;
    }
    if (this.pointB.x==pointC.x && this.pointB.y==pointC.y){
      this.pointB.x=pointD.x;
      this.pointB.y=pointD.y;
    }
  }
  public int TesterEgalite(Segment segment2) {
    int egalite=0;
    if(this.pointA.x==segment2.pointA.x && this.pointA.y==segment2.pointA.y && this.pointB.x==segment2.pointB.x && this.pointB.y==segment2.pointB.y){
      egalite=1;
    }
    return egalite;
  }
  public static void main(String[] args) {
    Point a= new Point(1,2);
    Point b= new Point(2,4);
    Point c= new Point(12,24);
    Point d= new Point(12,24);
    Point e= new Point(2,4);
    Segment n = new Segment(a,b);
    Segment m = new Segment(d,e);
    System.out.println(n.toString());
    System.out.println(n.longueurSegment());
    n.ChangerPoint(a,c);
    System.out.println(n.toString());
    int egalite = n.TesterEgalite(m);
    if (egalite==1){
      System.out.println("Les segments sont égaux");
    }
    if (egalite==0){
      System.out.println("Les segments ne sont pas égaux");
    }
  }
}