public class Moyenne2{
  private double[] tab;
  private int taille;
  public Moyenne2(){
    this.tab= new double[1000];
    this.taille=0;
  }
  public void getAverage(){
    double moyenne=0.0, somme=0.0;
    for(int i=0;i<taille;i++){
      somme=somme+this.tab[i];
    }
    moyenne=somme/taille;
    System.out.println(moyenne);
  }
    public void add(Number n){
    double type = n.doubleValue();
    this.tab[this.taille]=type;
    taille=taille+1;
  }
public static void main(String[] args) {
    Moyenne2 classe = new Moyenne2();
    classe.add(10);
    classe.add(20L);
    classe.add(14.5f);
    classe.add(8.5d);
    classe.getAverage();
  }
}