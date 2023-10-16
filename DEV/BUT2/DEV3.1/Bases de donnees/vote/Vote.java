import java.sql.*;

public class Vote {
    public static void main(String[] args){
	try{
	    Class.forName("org.mariadb.jdbc.Driver");		
	    try{
		Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
		/*try{
		    PreparedStatement req = con.prepareStatement("DROP TABLE Competition;");
		    PreparedStatement req2 = con.prepareStatement("DROP TABLE Pays2;");
		    req.executeUpdate();
		    req2.executeUpdate();		    
		}catch(SQLException e1){
		    System.out.println("Erreur dans la requete DROP");
		    }
		try{
		    PreparedStatement req = con.prepareStatement("CREATE TABLE Pays2(id INT PRIMARY KEY, Pays VARCHAR(50));");
		    PreparedStatement req2 = con.prepareStatement("CREATE TABLE Competition(Competiteur INT REFERENCES Pays2(id), Votants INT REFERENCES Pays2(id), Points INT, PRIMARY KEY(Competiteur,Votants));");
		    req.executeUpdate();
		    req2.executeUpdate();
		}catch(SQLException e1){
		    System.out.println("Erreur dans la requete CREATE");
		}
		try{
		    PreparedStatement req = con.prepareStatement("INSERT INTO Pays2(id, Pays) VALUES(?,?);");
		    PreparedStatement req2 = con.prepareStatement("INSERT INTO Competition(Competiteur, Votants, Points) VALUES(?,?,?);");
		    String[] liste = {"Pays-Bas","Italie","Russie"};
		    int[] tableau = {0,5,5,16,0,1,5,8,0};
		    for(int i=0;i<liste.length;i++){
			req.setInt(1,i+1);
			req.setNString(2,liste[i]);
			req.executeUpdate();
		    }
		    for(int i=0;i<liste.length;i++){
			for(int j=0;j<liste.length;j++){
			    if(i!=j){
				req2.setInt(1,i+1);
				req2.setInt(2,j+1);
				req2.setInt(3,tableau[i*3+j]);
				req2.executeUpdate();
			    }
			}
		    }
		}catch(SQLException e1){
		    System.out.println("Erreur dans la requete INSERT");
		    }*/
		try{
		    PreparedStatement req = con.prepareStatement("SELECT P2.Pays,Points FROM (Pays2 P JOIN Competition C ON P.id=C.Competiteur) JOIN Pays2 P2 ON P2.id=C.Votants WHERE P.Pays=?;");
		    String texte = new String(args[0]);
		    req.setNString(1,texte);
		    ResultSet res = req.executeQuery();
		    int total=0;
		    while(res.next()) {
			String chaine = new String();
			chaine = chaine+res.getNString(1)+" "+res.getInt(2);
			System.out.println(chaine);
			total=total+res.getInt(2);
		    }
		    System.out.println("      ------");
		    String mot = "TOTAL   "+Integer.toString(total);
		    System.out.println(mot);
		    con.close();
		}catch(SQLException e1){
		    System.out.println("Erreur dans la requete SELECT");
		    con.close();
		}
	    }catch(SQLException e2){
		System.out.println("Erreur de connexion le serveur refuse");
	    }
	}catch(ClassNotFoundException e3){
	    System.out.println("Erreur de connexion le pilote n'est pas disponible");
	}
    }
}
