package fr.iutfbleau.projetIHM2022FI2.MP;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class  RequeteMP{
public static Connection getCon() throws SQLException{
	final Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
	return con;
}
    
    public static void insertEtudiant(EtudiantMP e){
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement reqid = con.prepareStatement("select MAX(id) from IHM_Etudiant");
                    ResultSet rs = reqid.executeQuery();
                    rs.next();
                    e.id=rs.getInt(1);
                    //System.err.println(id);

		    		PreparedStatement req = con.prepareStatement("INSERT INTO IHM_Etudiant (id,nom,prenom) VALUES(?,?,?);");
					req.setInt(1,e.getId()+1);
					req.setNString(2,e.getNom());
					req.setNString(3,e.getPrenom());
					//System.err.println(req);
		    		req.executeUpdate();
		    		
		    		con.close();
				}catch(SQLException e1){
				    System.out.println("Erreur dans la requete INSERT");
				    con.close();
				}
			}catch(SQLException e2){
				System.out.println("Erreur de connexion le serveur refuse + "+e2);
	    	}
		}catch(ClassNotFoundException e3){
	    	System.out.println("Erreur de connexion le pilote n'est pas disponible +"+e3);
		}
    }

	public static EtudiantMP selectEtudiant(int id){
		String nom="",prenom="";
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
				Connection con = RequeteMP.getCon();
				try{
		    		PreparedStatement req = con.prepareStatement("SELECT * FROM Etudiant WHERE id=?;");
					req.setInt(1,id);
		    		ResultSet res = req.executeQuery();
		    		while(res.next()) {
						System.out.println(res.getInt(1));
						System.out.println(res.getNString(2));
						System.out.println(res.getNString(3));
					    nom=res.getNString(2);
						prenom=res.getNString(3);
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
		EtudiantMP etudiant = new EtudiantMP(nom,prenom);
		return etudiant;
    }
	public static void insertGroupe(GroupeMP g){
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
				Connection con = RequeteMP.getCon();
				try{
		    		PreparedStatement req = con.prepareStatement("INSERT INTO `Groupe`(`id`, `name`, `min`, `max`, `size`, `type`, `idpere`, `sous-groupes`, `etudiants`) VALUES (?,?,?,?,?,?,?,?,?);");
					req.setNString(1,Integer.toString(g.getId()));
					req.setNString(2,g.getName());
					req.setNString(3,Integer.toString(g.getMin()));
					req.setNString(4,Integer.toString(g.getMax()));
					req.setNString(5,Integer.toString(g.getSize()));
					//req.setNString(6,Integer.toString(g.getType()));
					req.setNString(7,Integer.toString(g.getPointPoint().getId()));
					req.setNString(8,Integer.toString(g.getId()));
					req.setNString(9,Integer.toString(g.getId()));
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

	public static GroupeMP selectGroupe(){
		int min=-1,max=-1;
		String name="";
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
				Connection con = RequeteMP.getCon();
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
						name=res.getNString(2);
						min=res.getInt(3);
						max=res.getInt(4);
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
		GroupeMP groupe = new GroupeMP(name,min,max);
		return groupe;
    }
	public static void insertChangement(){
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
				Connection con = RequeteMP.getCon();
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

	public static void selectChangement(){
		try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
				Connection con = RequeteMP.getCon();
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
