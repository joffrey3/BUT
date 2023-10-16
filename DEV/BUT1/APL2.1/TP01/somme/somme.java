/**
* Cette classe est une simple coquille pour recevoir la méthode principale
*
* @version 1.1 09 March 2014
* @author Luc Hernandez
*/
public class somme {
 
  /**
  * Affiche &laquo;Bonjour !&raquo;
  *
  * @param args la liste des arguments de la ligne de commande (inutilisée ici)
  */
  public static void main(String[] args) {
    int i,n=0;
    for(i=0;i<args.length;i=i+1){
          String nombre = args[i];
          n = n+Integer.parseInt(nombre);
  }
  System.out.println(n);
  }
}