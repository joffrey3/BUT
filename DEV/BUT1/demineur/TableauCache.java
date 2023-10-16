//La classe tableauCache crée un tableau d'entier ou les nombres représentent les états des cases
public class TableauCache {
	int ligne;
	int colonne;
	String chaine = new String();
	int tab[][];
	//le premier constructeur ne prend en argument que les lignes et les colonnes
	public TableauCache(int l,int c){
		this.ligne=l;
		this.colonne=c;
		this.tab= new int[l][c];
		String texte="";
		int i=0;
		int j=0;
		for(i=0;i<this.ligne;i++){
			for(j=0;j<this.colonne;j++){
				this.tab[i][j]=1;
				texte = texte + " ";
				texte = texte + this.tab[i][j];
			}
			texte = texte + "\n";
		}
		this.chaine=texte;;
	}
	//le deuxieme constructeur prend en argument que les lignes, les colonnes et un tableau deja préexistant
    public TableauCache(int l,int c,int[][] tab_c){
		this.ligne=l;
		this.colonne=c;
		this.tab= tab_c;
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
	}
	//La méthode passe le tableau à 0
	public void reveler(int l,int c) {
		this.tab[l][c]=0;
		this.chaine = new String();
		for(int i=0;i<this.ligne;i++){
			for(int j=0;j<this.colonne;j++){
				this.chaine = this.chaine + " ";
				this.chaine = this.chaine + tab[i][j];
			}
			this.chaine = this.chaine + "\n";
		}
		//System.out.println(this.chaine);
	}
	//La méthode change le nombre dans le tableau en fonction du marqueur
	public int marquer(int l,int c) {
		int point=0;
		switch(this.tab[l][c]){
			case 1 : point=2;
			break;
			case 2 : point=3;
			break;
			case 3 : point=1;
			break;
		}
		this.tab[l][c]=point;
		this.chaine = new String();
		for(int i=0;i<this.ligne;i++){
			for(int j=0;j<this.colonne;j++){
				this.chaine = this.chaine + " ";
				this.chaine = this.chaine + tab[i][j];
			}
			this.chaine = this.chaine + "\n";
		}
		return this.tab[l][c];
	}
	//la methode renvoie le nombre d'une case
    public int getCase(int x,int y) {
	return this.tab[x][y];
    }
    //la methode modifie le nombre d'une case
    public void setCase(int x,int y,int nombre) {
    	this.tab[x][y]=nombre;
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
