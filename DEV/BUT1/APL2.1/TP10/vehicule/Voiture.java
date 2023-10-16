import javax.swing.JOptionPane;
 
public class Voiture implements Vehicule{
  @Override
    public String sorte(){
    return "Voiture";
  }
  @Override
  public int nbRoues(){
    return 4;
  }
}