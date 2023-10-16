package fr.iutfbleau.projetIHM2022FI2.MP;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.util.*;
import java.sql.*;
/**
 * Une demande de changement de groupe
 * concerne un étudiant, qui est dans un groupe A et veut aller dans un groupe B.
 * 
 * Implémentation persistante.
 */

public class ChangementMP implements Changement {

    private int id;
    private Groupe a,b;
    private Etudiant e;
    private String ex;

    public ChangementMP(Groupe a, Etudiant e, Groupe b,String ex){
        Objects.requireNonNull(a,"On ne peut pas créer un changement avec un groupe à quitter null");
        Objects.requireNonNull(b,"On ne peut pas créer un changement avec un groupe à rejoindre null");
        Objects.requireNonNull(e,"On ne peut pas créer un changement concernant un étudiant null");
        Objects.requireNonNull(ex,"On ne peut pas créer un changement concernant une explication null");

        this.a=a;
        this.b=b;
        this.e=e;
        this.ex=ex;

        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    
                    PreparedStatement reqid = con.prepareStatement("select MAX(id) from IHM_Changement");
                    ResultSet rs = reqid.executeQuery();
                    rs.next();
                    this.id=rs.getInt(1)+1;
                    System.err.println("crea changement id:"+id);
                    
                
                    PreparedStatement req = con.prepareStatement("INSERT INTO IHM_Changement (id,A,B,idEtu,explication) VALUES(?,?,?,?,?);");
					req.setInt(1,this.id);
                    req.setInt(2,this.a.getId());
                    req.setInt(3,this.b.getId());
                    req.setInt(4,this.e.getId());
                    req.setNString(5,this.ex);
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
     * permet de récupérer l'identifiant du changement (référence interne sans intérêt irl).
     * @return l'identifiant.
     */
    public int getId(){
        return this.id;
    }

    /**
     * permet de récupérer le groupe de depart
     * @return ce groupe.
     */
    public Groupe getA(){
        return this.a;
    }

    /**
     * permet de récupérer le groupe d'arrivée
     * @return ce groupe.
     */
    public Groupe getB(){
        return this.b;
    }
    public String getExplication(){
        return this.ex;
    }

    /**
     * permet de récupérer l'étudiant demandant le changement
     * @return cet étudiant
     */
    public Etudiant getEtu(){
        return this.e;
    }

}
