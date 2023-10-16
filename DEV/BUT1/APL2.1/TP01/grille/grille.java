/**
* Cette classe est une simple coquille pour recevoir la méthode principale
*
* @version 1.1 09 March 2014
* @author Luc Hernandez
*/
import java.util.Arrays;
public class grille {
 
  /**
  * Affiche &laquo;Bonjour !&raquo;
  *
  * @param args la liste des arguments de la ligne de commande (inutilisée ici)
  */
  public static void main(String[] args) {
    int i,j;
    int n=Integer.parseInt(args[0]);
  for(i=0;i<n*2+1;i=i+1){
    for(j=0;j<n;j=j+1){
      if (i%2==0) {
      System.out.print("+");
      System.out.print("-");
      }
      if (i%2==1) {
      System.out.print("|");
      System.out.print(" ");
      }
    }
  if (i%2==0) {
    System.out.print("+");
  }
  if (i%2==1) {
    System.out.print("|");
  }
  System.out.println();
  }
}
}