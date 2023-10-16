package fr.iutfbleau.projetIHM2022FI2.MP;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.util.*;
import java.sql.*;
/**
 * créer un groupe via base de données
 */

public class GroupeMP implements Groupe {


    // attributs naturels induits par getter de l'interface Groupe
    private int id;
    private String name;
    private int min,max;
    private TypeGroupe type;
    private Groupe pointPoint;    
    // On utilise une interface set pour les sous-groupes et pour les membres (ce sont bien des ensembles en pratique).
    private Set<Groupe> sousGroupes;
    private Set<Etudiant> membresDuGroupe;



    /**
     * Ajout d'un groupe ROOT via BD.
     *
     * @param A id du goupe a creer 
     * 
     */
    public GroupeMP(int id){
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{

                    PreparedStatement req = con.prepareStatement("SELECT * FROM IHM_Groupe where id=? ;");
					req.setInt(1,this.id);
					//System.err.println(req);
		    		ResultSet rs = req.executeQuery();

                    rs.next();
                    this.id = rs.getInt("id");
                    this.name = rs.getString("name");
                    this.min = rs.getInt("min");
                    this.max = rs.getInt("max");
                    String tempo =  rs.getString("type");
                    if(tempo.equals("ROOT")) this.type=TypeGroupe.ROOT;
                    else if (tempo.equals("FREE")) this.type=TypeGroupe.FREE;
                    else this.type=TypeGroupe.PARTITION;

                    this.pointPoint = this;
                    this.sousGroupes=new LinkedHashSet<Groupe>();
                    this.membresDuGroupe=new LinkedHashSet<Etudiant>();

                    PreparedStatement req2 = con.prepareStatement("SELECT * FROM IHM_RelationGroupe where idGroupePere=? ;");
					req2.setInt(1,this.id);
					//System.err.println(req2);
		    		ResultSet rs2 = req2.executeQuery();

                    while (rs2.next()) {
                        int idfils = rs2.getInt("idGroupeFils ");
                        this.sousGroupes.add(new GroupeMP(idfils,this));
                            
                    }

                    PreparedStatement req3 = con.prepareStatement("SELECT * FROM IHM_Appartenance where idgroupe=? ;");
					req3.setInt(1,this.id);
					//System.err.println(req3);
		    		ResultSet rs3 = req3.executeQuery();

                    while (rs3.next()) {
                        int idetu = rs3.getInt("idEtu");
                        this.membresDuGroupe.add(new EtudiantMP(idetu));     
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
    }

    /**
     * insertion via base de donnée groupe de type non ROOT
     *
     * @param id id du groupe
     * @param pere id groupe pere
     * 
     */
    public GroupeMP(int id,GroupeMP pere){
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{

                    PreparedStatement req = con.prepareStatement("SELECT * FROM IHM_Groupe where id=? ;");
					req.setInt(1,this.id);
					//System.err.println(req);
		    		ResultSet rs = req.executeQuery();

                    rs.next();
                    this.id = rs.getInt("id");
                    this.name = rs.getString("name");
                    this.min = rs.getInt("min");
                    this.max = rs.getInt("max");
                    String tempo =  rs.getString("type");
                    if(tempo.equals("ROOT")) this.type=TypeGroupe.ROOT;
                    else if (tempo.equals("FREE")) this.type=TypeGroupe.FREE;
                    else this.type=TypeGroupe.PARTITION;

                    this.pointPoint = pere;

                    PreparedStatement req2 = con.prepareStatement("SELECT * FROM IHM_RelationGroupe where idGroupePere=? ;");
					req.setInt(1,this.id);
					//System.err.println(req);
		    		ResultSet rs2 = req2.executeQuery();

                    while (rs2.next()) {
                        int idfils = rs2.getInt("idGroupeFils ");
                        this.sousGroupes.add(new GroupeMP(idfils,this));
                            
                    }

                    PreparedStatement req3 = con.prepareStatement("SELECT * FROM IHM_Appartenance where idgroupe=? ;");
					req3.setInt(1,this.id);
					//System.err.println(req3);
		    		ResultSet rs3 = req3.executeQuery();

                    while (rs3.next()) {
                        int idetu = rs3.getInt("idEtu ");
                        this.membresDuGroupe.add(new EtudiantMP(idetu));     
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
    }


/**
     * Nouveau groupe vide de type ROOT sans étudiants, sans sous-Groupe.
     *
     * @param name nom du groupe
     * @param min nombre minimal d'etudiant
     * @param max nombre maximal d'etudiant
     * 
*/
    public GroupeMP(String name, int min, int max){
        Objects.requireNonNull(name,"On ne peut pas créer un groupe dont le nom est null");
        this.name=name;
        this.min=min;
        this.max=max;
        this.type=TypeGroupe.ROOT;
        this.pointPoint=this;
        this.sousGroupes=new LinkedHashSet<Groupe>();
        this.membresDuGroupe=new LinkedHashSet<Etudiant>();

        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement reqid = con.prepareStatement("select MAX(id) from IHM_Groupe");
                    ResultSet rs = reqid.executeQuery();
                    rs.next();
                    this.id=rs.getInt(1)+1;
                    System.err.println("crea groupe id:"+id);

                    PreparedStatement req = con.prepareStatement("INSERT INTO IHM_Groupe (id,name,min,max,type,pointpoint) VALUES(?,?,?,?,?,?);");
					req.setInt(1,this.id);
					req.setNString(2,this.name);
					req.setInt(3,this.min);
                    req.setInt(4,this.max);
                    req.setNString(5,"ROOT");
                    req.setInt(6,id);
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
     * Nouveau groupe vide de type FREE sans étudiants, sans sous-Groupe
     *
     * @param pere groupe pere
     * @param name nom du groupe
     * @param min nombre minimal d'etudiant
     * @param max nombre maximal d'etudiant
     * 
*/
    public GroupeMP(Groupe pere, String name, int min, int max){
        Objects.requireNonNull(pere,"On ne peut pas créer un groupe dont le père est null");
        Objects.requireNonNull(name,"On ne peut pas créer un groupe dont le nom est null");
        this.name=name;
        this.min=min;
        this.max=max;
        this.type=TypeGroupe.ROOT;
        this.pointPoint=pere;
        this.sousGroupes=new LinkedHashSet<Groupe>();
        this.membresDuGroupe=new LinkedHashSet<Etudiant>();

        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement reqid = con.prepareStatement("select MAX(id) from IHM_Groupe");
                    ResultSet rs = reqid.executeQuery();
                    rs.next();
                    this.id=rs.getInt(1)+1;
                    System.err.println("crea groupe id:"+id);

                    PreparedStatement req = con.prepareStatement("INSERT INTO IHM_Groupe (id,name,min,max,type,pointpoint) VALUES(?,?,?,?,?,?);");
					req.setInt(1,this.id);
					req.setNString(2,this.name);
					req.setInt(3,this.min);
                    req.setInt(4,this.max);
                    req.setNString(5,"FREE");
                    req.setInt(6,pere.getId());
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
     * Nouveau groupe de type PARTITION dupliquant le groupe passé en paramètre (pour servir de racine à une partition de ce groupe de type FREE passé en paramètre).
     *
     * @param pere groupe pere
     * 
*/
    public GroupeMP(Groupe pere){
        Objects.requireNonNull(pere,"On ne peut pas créer un groupe dont le père est null");

        this.min=pere.getMin();
        this.max=pere.getMax();
        this.type=TypeGroupe.PARTITION;
        this.pointPoint=pere;
        this.sousGroupes= new LinkedHashSet<Groupe>();
        this.membresDuGroupe = pere.getEtudiants();

        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement reqid = con.prepareStatement("select MAX(id) from IHM_Groupe");
                    ResultSet rs = reqid.executeQuery();
                    rs.next();
                    this.id=rs.getInt(1)+1;
                    System.err.println("crea groupe id:"+id);

                    this.name=pere.getName()+"_PARTITION_"+ this.id;
                    /*PreparedStatement req2 = con.prepareStatement("SELECT idGroupe,idEtu FROM IHM_Appartenance where idGroupe=? ;");
					req2.setInt(1,pere.getId());
					//System.err.println(req2);
		    		ResultSet rs2 = req2.executeQuery();

                    while (rs2.next()) {
                        //System.err.println("ca tourne :"+rs2.getInt(2));
                        PreparedStatement req3 = con.prepareStatement("INSERT INTO IHM_Appartenance (idGroupe,idEtu) VALUES(?,?);");
					    req3.setInt(1,this.getId());
					    req3.setInt(2,rs2.getInt(2));

					    //System.err.println(req);
		    		    req3.executeUpdate();
                            
                    }*/
                
                    PreparedStatement req = con.prepareStatement("INSERT INTO IHM_Groupe (id,name,min,max,type,pointpoint) VALUES(?,?,?,?,?,?);");
					req.setInt(1,this.id);
					req.setNString(2,this.name);
					req.setInt(3,this.min);
                    req.setInt(4,this.max);
                    req.setNString(5,"PARTITION");
                    req.setInt(6,pere.getId());
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
     * permet d'ajouter un nouveau changement.
     *
     * @param e Etudiant a ajouter
     * @return renvoie true si l'ajout c'est bien passé false sinon
     * 
*/
    public boolean addEtudiant(Etudiant e){
        Objects.requireNonNull(e,"On ne peut pas ajouter un Étudiant qui est null");
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement req = con.prepareStatement("INSERT INTO IHM_Appartenance (idGroupe,idEtu) VALUES(?,?);");
					req.setInt(1,this.id);
					req.setInt(2,e.getId());
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
        return this.membresDuGroupe.add(e);
    }

    /**
     * permet d'enlever un nouveau changement.
     *
     * @param e Etudiant a enlever
     * @return renvoie true si la supression c'est bien passé false sinon
     * 
*/
    public boolean removeEtudiant(Etudiant e){
        Objects.requireNonNull(e,"On ne peut pas enlever un Étudiant qui est null");
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement req = con.prepareStatement("DELETE FROM IHM_Appartenance WHERE idGroupe=? & idEtu=?;");
					req.setInt(1,this.id);
					req.setInt(2,e.getId());
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
        return this.membresDuGroupe.remove(e);
    }

    /**
     * permet d'ajouter un nouveau sous groupe.
     *
     * @param g groupe a ajouter
     * @return renvoie true si l'ajout c'est bien passé false sinon
     * 
*/
     public boolean addSousGroupe(Groupe g){
        Objects.requireNonNull(g,"On ne peut pas ajouter un sous-groupe qui est null");
        if (this.equals(g.getPointPoint())){
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement req = con.prepareStatement("INSERT INTO IHM_RelationGroupe (idGroupePere,idGroupeFils) VALUES(?,?);");
					req.setInt(1,this.id);
					req.setInt(2,g.getId());
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
            return this.sousGroupes.add(g);}
        else throw new IllegalArgumentException("on ne peut pas ajouter un sous-groupe ont le père n'est pas this");
    }

    /**
     * permet d'enlever un nouveau sous groupe.
     *
     * @param g Etudiant a enlever
     * @return renvoie true si la supression c'est bien passé false sinon
     * 
*/
    public boolean removeSousGroupe(Groupe g){
        Objects.requireNonNull(g,"On ne peut pas enlever un Étudiant qui est null");
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement req = con.prepareStatement("DELETE FROM IHM_RelationGroupe WHERE idGroupePere=? & idGroupeFils=?;");
					req.setInt(1,this.id);
					req.setInt(2,g.getId());
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
        return this.sousGroupes.remove(g);
    }

    /**
     * permet de renomer un groupe.
     *
     * @param nouvNom nouveau nom du Groupe
     * 
*/
    public void setName(String nouvNom){
        this.name=nouvNom;
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement req = con.prepareStatement("Update IHM_Groupe set name=? WHERE id=?;");
					req.setNString(1,nouvNom);
					req.setInt(2,this.id);
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
     * permet de récupérer l'identifiant d'un groupe (référence interne sans intérêt irl).
     * @return l'identifiant.
     */
    public int getId(){
        return this.id;
    }

    /**
     * permet de récupérer le nom d'un groupe (utile irl).
     * @return le nom.
     */
    public String getName(){
        return this.name;
    }

    /**
     * permet de récupérer le nombre minimum d'étudiants souhaités dans le groupe.
     * @return le minimum souhaité
     */
    public int getMin(){
        return this.min;
    }

    /**
     * permet de récupérer le nombre maximum d'étudiants souhaités dans un groupe.
     * @return le maximum souhaité
     */
    public int getMax(){
        return this.max;
    }

    /**
     * permet de récupérer le nombre d'étudiants dans ce groupe.
     * @return le nombre de places prises (pas forcément limité entre Min et Max, mais c'est le but)
     */
    public int getSize(){
        return this.membresDuGroupe.size();
    }
    
    /**
     * permet de récupérer la nature du groupe
     * @return le type du groupe
     */
    public TypeGroupe getType(){
        return type;
    }

    /**
     * permet de récupérer le groupe père
     * un groupe racine devrait retourner lui-même
     *
     * @return le père
     */
    public Groupe getPointPoint(){
        return this.pointPoint;
    }

    /**
     * Potentiellement "vide"
     * Attention nous renvoyons l'ensemble sans le copier
     *
     * @return l'ensemble des sous-groupes.
     */
    public Set<Groupe> getSousGroupes(){
        return this.sousGroupes;
    }

    /**
     * Potentiellement "vide"
     * Attention nous renvoyons l'ensemble sans le copier
     *
     * @return l'ensemble des étudiants.
     */
    public Set<Etudiant> getEtudiants(){
        return this.membresDuGroupe;
    }


}
