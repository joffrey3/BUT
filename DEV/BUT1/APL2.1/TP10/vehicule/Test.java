import javax.swing.JOptionPane;
 
public class Test {
  public static void main(String[] args) {
    Vehicule v;
    Object[] choix = {"Voiture", "Moto"};
 
    int reponse = JOptionPane.showOptionDialog(null,
      "Quel v\u00E9hicule choisissez-vous ?",
      "Question",
      JOptionPane.DEFAULT_OPTION,
      JOptionPane.QUESTION_MESSAGE,
      null,
      choix,
      null);
    if (reponse == 0)
      v = new Voiture();
    else
      v = new Moto();
    System.out.println("Une "+v.sorte()+" poss\u00E8de "+v.nbRoues()+" roues.");
  }
}