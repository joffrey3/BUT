public class Moyenne{
  private double[] tab;
  private int taille;
  public Moyenne(){
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
  public void add(byte n){
    this.tab[this.taille]=n;
    taille=taille+1;
  }
    public void add(short n){
    this.tab[this.taille]=n;
    taille=taille+1;
  }
    public void add(int n){
    this.tab[this.taille]=n;
    taille=taille+1;
  }
    public void add(long n){
    this.tab[this.taille]=n;
    taille=taille+1;
  }
    public void add(float n){
    this.tab[this.taille]=n;
    taille=taille+1;
  }
    public void add(double n){
    this.tab[this.taille]=n;
    taille=taille+1;
  }
  public static void main(String[] args) {
    Moyenne classe = new Moyenne();
    classe.add(10);
    classe.add(20L);
    classe.add(14.5f);
    classe.add(8.5d);
    classe.getAverage();
  }
}