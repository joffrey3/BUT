public class Lendemain {
  // attribut
  private int jour;
  private int mois;
  private int annee;
  public Lendemain() {
    this.jour = 00;
    this.mois = 00;
    this.annee = 0000;
  }
  // méthode
  // autre méthode
  public void lendemain(){
    int j = this.jour;
    int m = this.mois;
    int a = this.annee;
    if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12){
      if (j==31){
        j=0;
        if(m==12){
          m=1;
          a=a+1;
        }else{
          m=m+1;
        }
      }
    }
    if (m==4 || m==6 || m==9 || m==11){
      if (j==30){
        j=0;
        m=m+1;
      }
    }
    if (m==2){
      if (j==28){
        j=0;
        m=m+1;
      }
    }
    j=j+1;
    this.annee = a;
    this.mois = m;
    this.jour = j;
  }
  public static void main(String[] args) {
    Lendemain n = new Lendemain();
    n.jour=31;
    n.mois=12;
    n.annee=0;
    n.lendemain();
    System.out.print(n.annee);
    System.out.print("-");
    System.out.print(n.mois);
    System.out.print("-");
    System.out.print(n.jour);
    System.out.println(" ");
   
  }
}