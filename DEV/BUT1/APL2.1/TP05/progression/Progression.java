public class Progression {
  // attribut
  private int compte;
  public Progression() {
    this.compte = 0;
  }
  // méthode
  public void plusUn() {
    this.compte++;
  }
  // autre méthode
  public String toString() {
    return Integer.toBinaryString(this.compte);
  }
  public String binaire(int n){
    String binaire = new String();
    for(;n!=1;){
      int m=n%2;
      n=n/2;
      binaire=m+binaire;
    }
    binaire="1"+binaire;
     if(n<=7){
      binaire="00000"+binaire;
    }
    if(n>=8){
      binaire="0000"+binaire;
    }
    return binaire;
  }
  public static void main(String[] args) {
    Progression k= new Progression();
    k.compte=5;
    System.out.println(k.compte);
    System.out.println(k.binaire(k.compte));
    k.plusUn();
    System.out.println(k.compte);
    System.out.println(k.binaire(k.compte));
    k.plusUn();
    System.out.println(k.compte);
    System.out.println(k.binaire(k.compte));
    k.plusUn();
    System.out.println(k.compte);
    System.out.println(k.binaire(k.compte));
    k.plusUn();
    System.out.println(k.compte);
    System.out.println(k.binaire(k.compte));
  }
}