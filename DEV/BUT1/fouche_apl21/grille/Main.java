public class Main {
	public static void main(String[] args) {
		Grille grille1 = new Grille();
		grille1.Jouer(3,1);
		grille1.Jouer(7,2);
		grille1.Jouer(1,1);
		grille1.Jouer(4,2);
		System.out.println(grille1.toString());
	}
}