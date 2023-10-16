import java.sql.*;

public class Requete{
    public Requete(){

    }
    public int selectionnerRoom(int id){
        int valeur=-1;
        try{
            Class.forName("org.mariadb.jdbc.Driver");		
            try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
                try{
                    PreparedStatement req = con.prepareStatement("SELECT id,valeur FROM DONJON_ROOM WHERE id=?");
                    req.setInt(1,id);
		            ResultSet res = req.executeQuery();
		            while(res.next()) {
			            valeur=res.getInt("valeur");
		            }
                    return valeur;
                }catch(SQLException e1){
                    System.out.println("Erreur dans la requete SELECT");
                }
            }catch(SQLException e2){
		        System.out.println("Erreur de connexion le serveur refuse");
	        }
	    }catch(ClassNotFoundException e3){
	        System.out.println("Erreur de connexion le pilote n'est pas disponible");
	    }
        return valeur;
    }
    public void insererRoom(int id,int valeur){
        try{
            Class.forName("org.mariadb.jdbc.Driver");		
            try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
                try{
                    PreparedStatement req = con.prepareStatement("INSERT INTO DONJON_ROOM(id, valeur) VALUES (?,?)");
                    req.setInt(1,id);
                    req.setInt(2,valeur);
                    req.executeUpdate();
                }catch(SQLException e1){
                    System.out.println("Erreur dans la requete SELECT");
                }
            }catch(SQLException e2){
		        System.out.println("Erreur de connexion le serveur refuse");
	        }
	    }catch(ClassNotFoundException e3){
	        System.out.println("Erreur de connexion le pilote n'est pas disponible");
	    }
    }
    public String selectionnerDeplacement(int id_start, int id_end){
        String deplacement=null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");		
            try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
                try{
                    PreparedStatement req = con.prepareStatement("SELECT id_salle_present, id_salle_futur, id_direction FROM DONJON_DEPLACEMENT WHERE id_salle_present=? id_salle_futur=?");
                    req.setInt(1,id_start);
                    req.setInt(2,id_end);
		            ResultSet res = req.executeQuery();
		            while(res.next()) {
			            deplacement=res.getNString("id_direction");
		            }
                    return deplacement;
                }catch(SQLException e1){
                    System.out.println("Erreur dans la requete SELECT");
                }
            }catch(SQLException e2){
		        System.out.println("Erreur de connexion le serveur refuse");
	        }
	    }catch(ClassNotFoundException e3){
	        System.out.println("Erreur de connexion le pilote n'est pas disponible");
	    }
        return deplacement;
    }
    public void insererDeplacement(int id_start, int id_end,String id_direction){
        try{
            Class.forName("org.mariadb.jdbc.Driver");		
            try{
                Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
                try{
                    PreparedStatement req = con.prepareStatement("INSERT INTO DONJON_DEPLACEMENT(id_salle_present, id_salle_futur, id_direction) VALUES (?,?,?)");
                    req.setInt(1,id_start);
                    req.setInt(2,id_end);
                    req.setNString(1,id_direction);
                    req.executeUpdate();
                }catch(SQLException e1){
                    System.out.println("Erreur dans la requete SELECT");
                }
            }catch(SQLException e2){
		        System.out.println("Erreur de connexion le serveur refuse");
	        }
	    }catch(ClassNotFoundException e3){
	        System.out.println("Erreur de connexion le pilote n'est pas disponible");
	    }
    }
}