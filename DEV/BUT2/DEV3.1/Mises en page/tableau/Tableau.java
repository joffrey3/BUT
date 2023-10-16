import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class Tableau{
    JFrame fenetre;
    String[] tableauModuleString;
    Integer[] tableauModuleInt;
    String[][] tableauChamp;
    public Tableau(){
	int max=0;
	try{
	    Class.forName("org.mariadb.jdbc.Driver");		
	    try{
		Connection con = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/fouche","fouche", "fouche");
		try{
		    PreparedStatement req = con.prepareStatement("SELECT COUNT(*) FROM Module;");
		    PreparedStatement req2 = con.prepareStatement("SELECT COUNT(ALL module),M.code FROM Champ C JOIN Module M ON C.module=M.id GROUP BY C.module;");
		    PreparedStatement req3 = con.prepareStatement("SELECT code,module FROM Champ;");
		    //String texte = new String(args[0]);
		    //req.setNString(1,texte);
		    ResultSet res = req.executeQuery();
		    ResultSet res2 = req2.executeQuery();
		    ResultSet res3 = req3.executeQuery();
		    int i,j=0,l=0,precedant=0;
		    res.next();
		    this.tableauModuleString = new String[res.getInt(1)];
		    this.tableauModuleInt = new Integer[res.getInt(1)];
		    for(i=0;res2.next();i++) {
			this.tableauModuleString[i]=res2.getNString(2);
			this.tableauModuleInt[i]=res2.getInt(1);
			if(this.tableauModuleInt[i]>j){
			    j=this.tableauModuleInt[i];
			}
			String chaine = new String();
			chaine = chaine+res2.getNString(2)+" "+res2.getInt(1);
			System.out.println(chaine);
		    }
		    this.tableauChamp = new String[i][j];
		    for(;res3.next();l++){
			if(res3.getInt(2)!=precedant){
			    l=0;
			}
			this.tableauChamp[res3.getInt(2)-1][l]=res3.getNString(1);
			String chaine = new String();
			chaine = chaine+res3.getNString(1)+" "+res3.getInt(2);
			System.out.println(chaine);
			precedant=res3.getInt(2);
		    }
		    max=j;
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
	Fenetre affichage = new Fenetre(tableauModuleString,max,tableauChamp);
    }
}
