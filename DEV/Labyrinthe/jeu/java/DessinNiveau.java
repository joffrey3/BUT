import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class DessinNiveau extends JComponent{
    private int[] tab;
    private LecteurXPM bouton0;
    private LecteurXPM bouton1;
    private LecteurXPM bouton2;
    private LecteurXPM bouton3;
    private String[] chaine0;
    private String[] chaine1;
    private String[] chaine2;
    private String[] chaine3;
    public DessinNiveau(int monde,int niveau,int[] tableau) {
	this.tab=tableau;
	this.bouton0 = new LecteurXPM(); 
	this.chaine0=this.bouton0.lireImage(new File("../xpm/MUR-1.xpm"));
	this.bouton1 = new LecteurXPM(); 
	this.chaine1=this.bouton1.lireImage(new File("../xpm/J.xpm"));
	this.bouton2 = new LecteurXPM(); 
	this.chaine2=this.bouton2.lireImage(new File("../xpm/MUR-16.xpm"));
	this.bouton3 = new LecteurXPM();
	String m = new String(Integer.toString(monde));
	String n = new String(Integer.toString(monde));
	String texte = new String("../xpm/E"+m+"-"+n+".xpm");
	this.chaine3=this.bouton3.lireImage(new File(texte));

    }
    @Override
    protected void paintComponent(Graphics pinceau) {
	Graphics secondPinceau = pinceau.create();
	for(int i=0;i<36;i++){
	    for(int j=0;j<64;j++){
		for(int k=0;k<30;k++){
		    for(int l=0;l<30;l++){
			if(this.tab[i*64+j]==0){
			secondPinceau.setColor(Color.decode(this.chaine0[k*30+l]));
			secondPinceau.fillRect(j*30+l,i*30+k,1,1);
			}
			if(this.tab[i*64+j]==1){
			secondPinceau.setColor(Color.decode(this.chaine1[k*30+l]));
			secondPinceau.fillRect(j*30+l,i*30+k,1,1);
			}
			if(this.tab[i*64+j]==2){
			secondPinceau.setColor(Color.decode(this.chaine2[k*30+l]));
			secondPinceau.fillRect(j*30+l,i*30+k,1,1);
			}
			if(this.tab[i*64+j]==3){
			secondPinceau.setColor(Color.decode(this.chaine3[k*30+l]));
			secondPinceau.fillRect(j*30+l,i*30+k,1,1);
			}
		    }
		}
	    }
	}
    }
}
