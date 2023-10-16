public class Date {
  // attribut
  private String date;
  public Date() {
    this.date = "0000-00-00";
  }
  // méthode
  // autre méthode
  //public String toString( String chaine) {
  //  return Integer.toBinaryString(chaine);
  //}
  public static String date(String annee, String mois, String jour){
    return annee+'-'+mois+'-'+jour;
    }
  public static void main(String[] args) {
    String annee=args[0];
    String mois=args[1];
    String jour=args[2];
    String dateFinale;
    dateFinale=date(annee,mois,jour);
    System.out.println(dateFinale);
  }
}