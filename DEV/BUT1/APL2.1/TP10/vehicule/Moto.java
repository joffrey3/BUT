import javax.swing.JOptionPane;
 
public class Moto implements Vehicule{
  @Override
  public String sorte(){
    return "Moto";
  }
  @Override
  public int nbRoues(){
    return 2;
  }
}