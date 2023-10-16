package fr.iutfbleau.projetIHM2022FI2.MP;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.util.*;
import java.sql.*;
/**
 * créer un étudiant via base de données
 */

public class EtudiantMP implements Etudiant{

    private int id;
    private String nom, prenom;

    /**
     * Constructeur + insert dans la base de donnée.
     * @param nom nom de l'etudiant
     * @param prenom prenom de l'etudiant
     * 
*/
    public EtudiantMP(String nom, String prenom){
        Objects.requireNonNull(nom,"On ne peut pas créer un étudiant avec un nom null");
        Objects.requireNonNull(prenom,"On ne peut pas créer un étudiant avec un prenom null");
        this.nom=nom;
        this.prenom=prenom;
        //increment de l'id
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement reqid = con.prepareStatement("select MAX(id) from IHM_Etudiant");
                    ResultSet rs = reqid.executeQuery();
                    rs.next();
                    this.id=rs.getInt(1)+1;
                    System.err.println("crea etu id:"+id);

                    PreparedStatement req = con.prepareStatement("INSERT INTO IHM_Etudiant (id,nom,prenom) VALUES(?,?,?);");
					req.setInt(1,this.id);
					req.setNString(2,this.nom);
					req.setNString(3,this.prenom);
					//System.err.println(req);
		    		req.executeUpdate();

		    		con.close();
				}catch(SQLException e1){
				    System.out.println("Erreur dans la requete");
				    con.close();
				}
			}catch(SQLException e2){
				System.out.println("Erreur de connexion le serveur refuse + "+e2);
	    	}
		}catch(ClassNotFoundException e3){
	    	System.out.println("Erreur de connexion le pilote n'est pas disponible +"+e3);
		}
    }

    /**
     * Constructeur via base de données.
     * @param id id de l'etudiant
     * 
*/
    public EtudiantMP(int id){
        Objects.requireNonNull(id,"On ne peut pas créer un étudiant avec un id null");
        // auto incrément de l'id
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement req = con.prepareStatement("SELECT id,nom,prenom FROM IHM_Etudiant where id=?;");
					req.setInt(1,id);
					//System.err.println(req);
                    ResultSet rs = req.executeQuery();
                    rs.next();
                    this.id = rs.getInt("id");
                    this.nom = rs.getString("nom");
                    this.prenom = rs.getString("prenom");

		    		con.close();
				}catch(SQLException e1){
				    System.out.println("Erreur dans la requete "+e1);
				    con.close();
				}
			}catch(SQLException e2){
				System.out.println("Erreur de connexion le serveur refuse + "+e2);
	    	}
		}catch(ClassNotFoundException e3){
	    	System.out.println("Erreur de connexion le pilote n'est pas disponible +"+e3);
		}
    }

     /**
     *Initialisation des etudiant via base de donnée.
     pas utilisé.
     */
    public static Set<Etudiant> InitEtu(Set<Etudiant> listeEtu){
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement req2 = con.prepareStatement("SELECT * FROM IHM_Etudiant;");
					//System.err.println(req2);
		    		ResultSet rs2 = req2.executeQuery();

                    while (rs2.next()) {
                        int idEtu = rs2.getInt("id");
                        //System.err.println(idEtu);
                        listeEtu.add(new EtudiantMP(idEtu));
                    }
		    		con.close();
				}catch(SQLException e1){
				    System.out.println("Erreur dans la requete");
				    con.close();
				}
			}catch(SQLException e2){
				System.out.println("Erreur de connexion le serveur refuse + "+e2);
	    	}
		}catch(ClassNotFoundException e3){
	    	System.out.println("Erreur de connexion le pilote n'est pas disponible +"+e3);
		}
        return listeEtu;
    }
    
    /**
     * permet de récupérer l'identifiant de l'étudiant.
     * @return l'identifiant.
     */
    public int getId(){
        return this.id;
    }

    /**
     * permet de récupérer 
     * @return le nom de l'étudiant.
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * permet de récupérer
     * @return le prénom de l'étudiant
     */
    public String getPrenom(){
        return this.prenom;
    }


}
