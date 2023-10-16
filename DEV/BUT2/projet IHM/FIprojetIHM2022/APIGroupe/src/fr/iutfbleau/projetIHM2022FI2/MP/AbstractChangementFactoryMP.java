package fr.iutfbleau.projetIHM2022FI2.MP;
import fr.iutfbleau.projetIHM2022FI2.API.*;
import java.util.*;
import java.sql.*;
/**
 * Usine abstraite gérant l'ensemble des changements.
 * 
 */
public class AbstractChangementFactoryMP implements AbstractChangementFactory {
    // l'usine à groupe travaillant en tandem avec cette usine.
    private AbstractGroupeFactoryMP agf;
    // On utilise une table de hachage pour retrouver facilement un changement (à partir de son id).
    // Si il y a beaucoup de changements c'est plus rapide que de parcourir toute une liste.
    private HashMap<Integer,Changement> brain;
    public AbstractChangementFactoryMP(AbstractGroupeFactoryMP agf){
        Objects.requireNonNull(agf,"On ne peut pas créer une usine à changement dont l'usine à groupe parternaire est null");
        this.agf=agf;
        this.brain=new HashMap<Integer,Changement>();
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement reqid = con.prepareStatement("select id from IHM_Changement");
                    ResultSet rs = reqid.executeQuery();
                    while(rs.next()){
                        createChangement(rs.getInt("id"));
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
     * permet de récupérer l'usine abstraite pour les groupes qui fonctionne en tandem avec cette usine abstraite
     * @return cette usine abstraite pour les groupes
     */
    public AbstractGroupeFactory getGroupeFactory(){
        return this.agf;
    }
    
    /**
     * permet de récupérer les changements 
     * @return l'ensemble de tous les changements en attente
     */
    public Set<Changement> getAllChangements(){
        // la méthode value() d'un hashmap retourne la collection des valeurs.
        // Il faut transformer la collection en Set.
        // Un constructeur de HashSet permet de faire cette opération.
        Set<Changement> out = new HashSet<Changement>(this.brain.values());
        return out;
    }
    /**
     * permet de mettre en oeuvre un changement connu de l'usine abstraite.
     *
     * @throws java.lang.NullPointerException si un argument est null
     * @throws java.lang.IllegalStateException si le changement n'a pas de sens en l'état actuel (e.g. étudiant pas dans le groupe de départ a, groupe b inconnu, groupe a inconnu, etc).
     * @throws java.lang.IllegalArgumentException si inconnu de l'usine abstraite
     */
    public void applyChangement(Changement c){
        Objects.requireNonNull(c,"On ne peut pas appliquer un changement qui est null");
        Etudiant e = c.getEtu();
        Groupe a = c.getA();
        Groupe b = c.getB();
        if (!agf.knows(a)) throw new IllegalStateException("Le groupe de départ du changement est inconnu. Impossible à mettre en oeuvre.");
        
        if (!agf.knows(b)) throw new IllegalStateException("Le groupe d'arrivée du changement est inconnu. Impossible à mettre en oeuvre.");
        // pas encore implanté.
        // if(!agf.getGroupesOfEtudiant(e).contains(a)) throw new IllegalStateException("Le groupe de départ ne contient pas l'étudiant. Impossible à mettre en oeuvre.");
            
        agf.dropFromGroupe(a,e);
        agf.addToGroupe(b,e);
        // En cas de succès, on enlève le changement du cerveau
        this.brain.remove(Integer.valueOf(c.getId()));
    }
    
    /**
     * permet de supprimer un changement connu de l'usine abstraite.
     *
     * @throws java.lang.NullPointerException si un argument est null
     * @throws java.lang.IllegalArgumentException si inconnu de l'usine abstraite
     */
    public void deleteChangement(Changement c){
        Objects.requireNonNull(c,"On ne peut pas demander la suppression d'un changement qui est null");
        this.brain.remove(Integer.valueOf(c.getId()));
    }
    /**
     * permet d'ajouter un nouveau changement.
     *
     * @param A groupe actuel
     * @param B groupe demandé
     * @param e étudiant concerné par le changement
     *
     * @throws java.lang.NullPointerException si un argument est null
     * @throws java.lang.IllegalArgumentException si les groupes ou l'étudiant ne sont pas connus de la factory partenaire, ou e n'appartient pas à A ou A et B ne sont pas frères dans l'arbre des groupes.
     *        
     */
    public void createChangement(Groupe A, Etudiant e, Groupe B,String ex){
        Objects.requireNonNull(A,"Le groupe d'origine ne peut pas être null");
        Objects.requireNonNull(B,"Le groupe d'arrivée ne peut pas être null");
        Objects.requireNonNull(e,"L'étudiant ne peut pas être null");
        Objects.requireNonNull(ex,"L'étudiant ne peut pas être null");
        Changement c = new ChangementMP(A,e,B,ex);
        this.brain.put(Integer.valueOf(c.getId()),c);   
    }
    public void createChangement(int id){
        try{
	    	Class.forName("org.mariadb.jdbc.Driver");		
	    	try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
				try{
                    PreparedStatement reqid = con.prepareStatement("select id,A,B,nomEtu,explication from IHM_Changement");
                    System.err.println("test1");
                    ResultSet rs = reqid.executeQuery();
                    rs.next();
                    System.err.println("test2");
                    int A = rs.getInt("A");
                    int B = rs.getInt("B");
                    String nomEtu = rs.getNString("nomEtu");
                    String explication = rs.getNString("explication");

                    Changement c = new ChangementMP(agf.getBrain().get(A),agf.getEtudiant(nomEtu),agf.getBrain().get(B),explication);
                    this.brain.put(Integer.valueOf(c.getId()),c);  

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
    
}