/**
* Cette classe est une simple coquille pour recevoir la méthode principale
*
* @version 1.1 09 March 2014
* @author Luc Hernandez
*/
import java.util.Arrays;
public class tri {
 
  /**
  * Affiche &laquo;Bonjour !&raquo;
  *
  * @param args la liste des arguments de la ligne de commande (inutilisée ici)
  */
  public static void main(String[] args) {
    int i;
    int[] n= new int[args.length];
    for(i=0;i<args.length;i=i+1){
          String nombre = args[i];
          n[i] =Integer.parseInt(nombre);
  }
  Arrays.sort(n);
  for(i=0;i<n.length;i=i+1){
    System.out.print(n[i]);
    System.out.print(" ");
  }
  System.out.println();
  }
}