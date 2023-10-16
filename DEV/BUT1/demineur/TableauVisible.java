import java.util.Arrays;

//La classe tableauVisible crée un tableau d'entier ou les nombres représentent les états des cases
public class TableauVisible {
	int ligne;
	int colonne;
	String chaine = new String();
	int tab[][];
	int compteur;
	//le premier constructeur ne prend en argument que les lignes et les colonnes
	public TableauVisible(int l,int c){
		this.ligne=l;
		this.colonne=c;
		this.tab= new int[l][c];
		String texte="";
		int i=0;
		int j=0;
		for(i=0;i<this.ligne;i++){
			for(j=0;j<this.colonne;j++){
				this.tab[i][j]=0;
				texte = texte + " ";
				texte = texte + this.tab[i][j];
			}
			texte = texte + "\n";
		}
		this.chaine=texte;
		this.compteur=0;
	}
	//le premier constructeur ne prend en argument les lignes et les colonnes en un tableau préexistant
    public TableauVisible(int l,int c,int[][] tab_v){
		this.ligne=l;
		this.colonne=c;
		this.tab= tab_v;
		String texte="";
		int i=0;
		int j=0;
		for(i=0;i<this.ligne;i++){
			for(j=0;j<this.colonne;j++){
				texte = texte + " ";
				texte = texte + this.tab[i][j];
			}
			texte = texte + "\n";
		}
		this.chaine=texte;
		this.compteur=0;
	}
	public void miner(int mine) {
		Mine minage = new Mine();
		this.tab = minage.MinerTableau(this.ligne,this.colonne,mine);
	}
	public void entourer() {
		int compteur=0;
		this.chaine = new String();
		for(int i=0;i<this.ligne;i++){
			for(int j=0;j<this.colonne;j++){
				if (this.tab[i][j]==0){
					this.condition(i,j);
					this.tab[i][j]=this.compteur;
					this.compteur=0;
				}
				this.chaine = this.chaine + " ";
				this.chaine = this.chaine + tab[i][j];
			}
			this.chaine = this.chaine + "\n";
		}
	}
	//La méthode vérifie le rebord des cases 
	public void condition(int i,int j){
		if(i==0 && j==0){
			this.verification(i,j,0,1,0,1);
		}
		else if(i==0 && j==this.colonne-1){
			this.verification(i,j,0,1,-1,0);
		}
		else if(i==this.ligne-1 && j==0){
			this.verification(i,j,-1,0,0,1);
		}
		else if(i==this.ligne-1 && j==this.colonne-1){
			this.verification(i,j,-1,0,-1,0);
		}
		else if(i==0){
			this.verification(i,j,0,1,-1,1);
		}
		else if(j==0){
			this.verification(i,j,-1,1,0,1);
		}
		else if(i==this.ligne-1){
			this.verification(i,j,-1,0,-1,1);
		}
		else if(j==this.colonne-1){
			this.verification(i,j,-1,1,-1,0);
		}
		else{
			this.verification(i,j,-1,1,-1,1);
		}
	}
	//La methode implémente le compteur avant le jeu
	public void verification(int i,int j,int infk,int supk,int infl,int supl){
		for(int k=infk;k<=supk;k++){
			for(int l=infl;l<=supl;l++){
				if (this.tab[i+k][j+l]==9){
					this.compteur=this.compteur+1;
				}
			}
		}
	}
	//La méthode passe le tableau à 1
	public void reveler(int l,int c) {
		this.chaine = new String();
		for(int i=0;i<this.ligne;i++){
			for(int j=0;j<this.colonne;j++){
				this.chaine = this.chaine + " ";
				this.chaine = this.chaine + this.tab[i][j];
			}
			this.chaine = this.chaine + "\n";
		}
	}
	//la methode renvoie le nombre d'une case
	public int getCase(int x,int y) {
		return this.tab[x][y];
	}

	//la methode renvoie le tableau dans la console
	public void afficher() {
		this.chaine = new String();
		for(int i=0;i<this.ligne;i++){
			for(int j=0;j<this.colonne;j++){
				this.chaine = this.chaine + " ";
				this.chaine = this.chaine + tab[i][j];
			}
			this.chaine = this.chaine + "\n";
		}
		System.out.println(this.chaine);
	}
}
