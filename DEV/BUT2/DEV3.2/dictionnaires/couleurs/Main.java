import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Main {
    public static void main (String[] args){
        /*Map<Thread,StackTraceElement[]> dico =Thread.getAllStackTraces();
        Set<Map.Entry<Thread,StackTraceElement[]>> tab=dico.entrySet();
        Iterator ite=tab.iterator();
        for(;ite.hasNext();){
            //tab.clear();
            System.out.println(ite.next());
        }*/
        JFrame fenetre = new JFrame();
        fenetre.setSize(400,300);
        fenetre.setLocation(0,0);

        GridLayout grille = new GridLayout(1,2);
        fenetre.setLayout(grille);

        JPanel panneau= new JPanel();
        panneau.setBackground(Color.BLACK);

        String[] data = {"one", "two", "three", "four"};
        JList<String> myList = new JList<String>(data);

        fenetre.add(myList);
        fenetre.add(panneau);

        fenetre.setVisible(true);

        String ligne;
        try {
        BufferedReader lecture = new BufferedReader(new FileReader("rgb.txt"));
            try {
                while((ligne = lecture.readLine()) != null) {
                    ligne=ligne.trim();
                    int lr=3,lg=7,lb=11;
                    String[] tab= new String[4];
                    String[] section= new String[3];

                    tab[0]=ligne.substring(0,3);
                    String r=tab[0];
                    //System.out.println(r+"oui");
                    section=r.split(" ");
                    r=section[0];
                    //System.out.println();
                    if(r.length()==1){
                        tab[1]=ligne.substring(lr-1,lr+10);
                        lg=lr+1;   
                    }else{
                        tab[1]=ligne.substring(lr+1,lr+10);
                        lg=lr+4;
                    }

                    String g=tab[1];
                    //System.out.println(g+"oui");
                    section=g.split(" ");
                    g=section[0];
                    System.out.println(lg);
                    if(g.length()==1){
                        tab[1]=ligne.substring(lg-1,lg+10);
                        lb=lg+1;    
                    }else{
                        tab[1]=ligne.substring(lg+1,lg+10);
                        lb=lg+4;
                    }
                    String b=tab[2];
                    //System.out.println(b+"oui");
                    //section=b.split(" ");
                    //b=section[0];
                    //b2=section[1];
                    //b3=section[2];
                    //System.out.println(b+"oui");
                    //System.out.println(b.length());
                    tab[3]=ligne.substring(13);
                    //Color c =new Color(Integer.parseInt(r),Integer.parseInt(g),Integer.parseInt(b));
                    System.out.println(r+" "+g+" "+b+" "+" "+tab[3]+" ");
                    System.out.println();
                }
            } catch(IOException e) {
                System.err.println("Erreur de lecture dans rgb.txt !");
            }
            try {
                lecture.close();
            } catch(IOException e) {
                System.err.println("Erreur de fermeture de rgb.txt !");
            }
        } catch(FileNotFoundException e) {
            System.err.println("Erreur d'ouverture de rgb.txt !");
        }
    }
}