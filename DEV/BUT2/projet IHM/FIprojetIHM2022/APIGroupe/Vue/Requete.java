import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class  Requete{
public static Connection getCon() throws SQLException{
	final Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
	return con;
}
    
    public static void insertEtudiant(){
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
				Connection con = Requete.getCon();
				try{
		    		PreparedStatement req = con.prepareStatement("INSERT INTO Etudiant (id,nom,prenom) VALUES(?,?,?);");
<<<<<<< HEAD
					req.setInt(1,2);
=======
					req.setNString(1,"2");
>>>>>>> master
					req.setNString(2,"nom2");
					req.setNString(3,"prenom2");
					System.out.println(req);
		    		req.executeUpdate();
		    		
		    		con.close();
				}catch(SQLException e1){
				    System.out.println("Erreur dans la requete INSERT");
				    con.close();
				}
			}catch(SQLException e2){
				System.out.println("Erreur de connexion le serveur refuse");
	    	}
		}catch(ClassNotFoundException e3){
	    	System.out.println("Erreur de connexion le pilote n'est pas disponible");
		}
    }

	public static void selectEtudiant(){
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
				Connection con = Requete.getCon();
				try{
		    		PreparedStatement req = con.prepareStatement("SELECT * FROM Etudiant WHERE id=?;");
					req.setNString(1,"1");
		    		ResultSet res = req.executeQuery();
		    		while(res.next()) {
						System.out.println(res.getInt(1));
						System.out.println(res.getNString(2));
						System.out.println(res.getNString(3));
					     //res.getInt(2);
					     //res.getNString(1);
					}
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

	public static void insertGroupe(){
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
				Connection con = Requete.getCon();
				try{
		    		PreparedStatement req = con.prepareStatement("INSERT INTO `Groupe`(`id`, `name`, `min`, `max`, `size`, `type`, `idpere`, `sous-groupes`, `etudiants`) VALUES (?,?,?,?,?,?,?,?,?);");
					req.setNString(1,"2");
					req.setNString(2,"nom2");
					req.setNString(3,"3");
					req.setNString(4,"4");
					req.setNString(5,"8");
					req.setNString(6,"3");
					req.setNString(7,"3");
					req.setNString(8,"3");
					req.setNString(9,"3");
					System.out.println(req);
		    		req.executeUpdate();
		    		
		    		con.close();
				}catch(SQLException e1){
				    System.out.println("Erreur dans la requete INSERT");
				    con.close();
				}
			}catch(SQLException e2){
				System.out.println("Erreur de connexion le serveur refuse");
	    	}
		}catch(ClassNotFoundException e3){
	    	System.out.println("Erreur de connexion le pilote n'est pas disponible");
		}
    }

	public static void selectGroupe(){
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
				Connection con = Requete.getCon();
				try{
		    		PreparedStatement req = con.prepareStatement("SELECT * FROM Groupe WHERE id=?;");
					req.setNString(1,"2");
		    		ResultSet res = req.executeQuery();
		    		while(res.next()) {
						System.out.println(res.getInt(1));
						System.out.println(res.getNString(2));
						System.out.println(res.getInt(3));
						System.out.println(res.getInt(4));
						System.out.println(res.getInt(5));
						System.out.println(res.getInt(6));
						System.out.println(res.getInt(7));
						System.out.println(res.getInt(8));
						System.out.println(res.getInt(9));
					}
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
	public static void insertChangement(){
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
				Connection con = Requete.getCon();
				try{
		    		PreparedStatement req = con.prepareStatement("INSERT INTO `Groupe`(`id`, `name`, `min`, `max`, `size`, `type`, `idpere`, `sous-groupes`, `etudiants`) VALUES (?,?,?,?,?,?,?,?,?);");
					req.setNString(1,"2");
					req.setNString(2,"nom2");
					req.setNString(3,"3");
					req.setNString(4,"4");
					req.setNString(5,"8");
					req.setNString(6,"3");
					req.setNString(7,"3");
					req.setNString(8,"3");
					req.setNString(9,"3");
					System.out.println(req);
		    		req.executeUpdate();
		    		
		    		con.close();
				}catch(SQLException e1){
				    System.out.println("Erreur dans la requete INSERT");
				    con.close();
				}
			}catch(SQLException e2){
				System.out.println("Erreur de connexion le serveur refuse");
	    	}
		}catch(ClassNotFoundException e3){
	    	System.out.println("Erreur de connexion le pilote n'est pas disponible");
		}
    }

	public static void selectGroupe(){
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
				Connection con = Requete.getCon();
				try{
		    		PreparedStatement req = con.prepareStatement("SELECT * FROM Groupe WHERE id=?;");
					req.setNString(1,"2");
		    		ResultSet res = req.executeQuery();
		    		while(res.next()) {
						System.out.println(res.getInt(1));
						System.out.println(res.getNString(2));
						System.out.println(res.getInt(3));
						System.out.println(res.getInt(4));
						System.out.println(res.getInt(5));
						System.out.println(res.getInt(6));
						System.out.println(res.getInt(7));
						System.out.println(res.getInt(8));
						System.out.println(res.getInt(9));
					}
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
