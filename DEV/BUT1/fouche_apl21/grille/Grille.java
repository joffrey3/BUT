

public class Grille { 
   private int[][] grille = new int[6][7];
   public Grille(){
      for(int i=0;i<6;i++){
         for(int j=0;j<7;j++){
            grille[i][j]=0;
         }
      }
   }

   public void Jouer(int colonne,int joueur) {
      for(int i=1;i<6;i++){
         if(grille[6-i][colonne]!=0){

            if (joueur ==1){
               grille[6-i][colonne]=1;
            }
            if (joueur ==2){
               grille[i][colonne]=2;
            }
            System.out.println(grille[6-i][colonne]);
         }
      }
 }
 public String toString() {
   String chaine= new String("");
   for(int i=0;i<6;i++){
      for(int j=0;j<7;j++){
         chaine=chaine+"│";
         if (grille[i][j] ==1){
            chaine=chaine+"●";
         }
         else if (grille[i][j] ==2){
            chaine=chaine+"○";
         }
         else{
            chaine=chaine+" ";
         }
      }
      chaine=chaine+"│\n";
   } 
   for (int i=0;i<7;i++){
      chaine=chaine+"┴─";
      }
      chaine=chaine+"┴\n";
      return chaine;
   }

}