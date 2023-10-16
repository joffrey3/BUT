public class Periode {
  // attribut
  private int jour;
  private int mois;
  private int annee;
  public Periode() {
    this.jour = 00;
    this.mois = 00;
    this.annee = 0000;
  }
  public String toString(){
    return this.annee+"-"+this.mois+"-"+this.jour;
  }
   /* String nombre="0123456789";
    String chaine="";
    int k=0;
    for(int j=0;j<2;j++){
      if(j=0){
        k=this.annee/10/10/10;
      }
      if(j=1){
        k=this.annee/10/10%10;
      }
      if(j=2){
        k=this.annee/10%10;
      }
      if(j=3){
        k=this.annee%10;
      }
      for(int i=0;i<10;i++){
        if(i=k){
          chaine=chaine+nombre[i];
        }
      }
    }
    for(int j=0;j<2;j++){
      if(j=0){
        k=this.mois/10;
      }
      if(j=1){
        k=this.mois%10;
      }
      for(int i=0;i<10;i++){
        if(i=k){
          chaine=chaine+nombre[i];
        }
      }
    }for(int j=0;j<2;j++){
      if(j=0){
        k=this.jour/10;
      }
      if(j=1){
        k=this.jour%10;
      }
      for(int i=0;i<10;i++){
        if(i=k){
          chaine=chaine+nombre[i];
        }
      }
    }*/
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

  public int Intervalle(Periode m){
    int compte=0;
    for (;m.jour<this.jour || m.mois<this.mois || m.annee<this.annee;){
      m.lendemain();
      compte=compte+1;
    }
    return compte;
  }
  public static void main(String[] args) {
    Periode n= new Periode();
    Periode m= new Periode();
    n.jour=1;
    n.mois=1;
    n.annee=2;
    m.jour=1;
    m.mois=1;
    m.annee=0;
    System.out.println(n.toString());
    System.out.println(m.toString());
    System.out.println(n.Intervalle(m));
   
  }
}