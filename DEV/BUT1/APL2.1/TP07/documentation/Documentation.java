import java.lang.Object;

public class Documentation{
  // attribut
  private String texte;
  public Documentation() {
    this.texte = " ";
  }
  // méthode
  public String Majuscule() {
      return this.texte.toUpperCase();
  }
  public static void main(String[] args) {
    Documentation k= new Documentation();
    k.texte=args[0];
    System.out.println(k.Majuscule());
  }
}
