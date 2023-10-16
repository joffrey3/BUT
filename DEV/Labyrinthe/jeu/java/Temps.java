import java.lang.*;
import java.awt.*;
import java.util.*;

public class Temps extends TimerTask{
    private InterfaceDialogue fenetre;
    private DessinDialogue fond;
    private LecteurDialogue t;
    private String[] text;
    private String portrait;
    private String nom;
    private int ent;
    private int index;
    private int[] ligne_vide;
    private int pos;
    public Temps(InterfaceDialogue j,LecteurDialogue taille,String[] texte,int emplacement,int ind,String p,String n){
	this.fenetre=j;
	this.t=taille;
	this.text=texte;
	this.ent=emplacement;
	this.index=ind;
	this.portrait=p;
	this.nom=n;
	this.fond = new DessinDialogue(this.fenetre,50,this.text,this.ent,this.index,this.portrait,this.nom);
	this.ligne_vide = new int[this.text.length/50];
        for(int i=0;i<this.ligne_vide.length;i++){
	    this.ligne_vide[i]=-1;
	}	  
	this.pos=0;
    }
    public void run(){
	if(this.ent%300!=0 || this.ent==0){
	    this.ent=this.ent+1;
	    boolean flag=this.changement();
	    if(flag==false){
		boolean flag2=this.detecter();
		this.fond = new DessinDialogue(this.fenetre,50,this.text,this.ent,this.index,this.portrait,this.nom);
		this.fenetre.modifier(this.fond,this.ent);
		if (this.ent!=this.text.length){
		    if(this.text[this.ent]==null){
			this.fenetre.getTemps().run();
		    }
		}
		if(flag2==true){
		    this.ent=this.ent-1;
		}
	    }
	    if(flag==true){
		this.fenetre.arret();
	    }	    
	}
    }
    public void pause(){
	this.ent=this.ent+1;
	boolean flag=this.changement();
	if(flag==false){
	    boolean flag2=this.detecter();
	    this.fond = new DessinDialogue(this.fenetre,50,this.text,this.ent,this.index,this.portrait,this.nom);
	    this.fenetre.modifier(this.fond,this.ent);
	    if (this.ent!=this.text.length){
		if(this.text[this.ent]==null){
		    this.fenetre.getTemps().run();
		}
	    }
	    if(flag2==true){
		this.ent=this.ent-1;
	    }
	}
	if(flag==true){
	    this.fenetre.arret();
	}
    }
    public boolean detecter(){
	if(this.ent<this.text.length){
	    if (this.text[this.ent]!=null && this.ent<this.text.length){
		String comparer = this.text[this.ent];
		if(comparer.equals("$")){
		    String chaine = new String();
		    this.text[this.ent]=null;
		    this.ent=this.ent+1;
		    comparer = this.text[this.ent];
		    for(;!comparer.equals("$");){
			chaine=chaine+this.text[this.ent];
			this.text[this.ent]=null;
			this.ent=this.ent+1;
			comparer = this.text[this.ent];
		    }
		    this.text[this.ent]=null;
		    this.portrait = chaine;
		    this.retirer();
		    this.ent=this.ent/50*50;
		    return true;
		}
		if(comparer.equals("£")){
		    String chaine = new String();
		    this.text[this.ent]=null;
		    this.ent=this.ent+1;
		    comparer = this.text[this.ent];
		    for(;!comparer.equals("£");){
			chaine=chaine+this.text[this.ent];
			this.text[this.ent]=null;
			this.ent=this.ent+1;
			comparer = this.text[this.ent];
		    }
		    this.text[this.ent]=null;
		    this.nom = chaine;
		    this.retirer();
		    this.ent=this.ent/50*50;
		    return true;
		}
	    }
	}
	return false;
    }
    public boolean changement(){
	if(this.ent<this.text.length-1){
	    String comparer = this.text[this.ent];
	    if(this.text[this.ent]!=null){
		if(comparer.equals("§")){
		    this.text[this.ent]=null;
		    return true;
		}
	    }
	}
	return false;
    }
    public void retirer(){
	int indent=0;
	for(int i=0;i<this.text.length/50;i++){
	    if(this.text[i*50]==null){
		boolean flag=true;
		for(int j=0;j<50;j++){
		    if(this.text[i*50+j]!=null){
			flag=false;
		    }
		}
		if (flag==true){
		    this.ligne_vide[i]=0;
		    indent=indent+1;
		}
	    }
	}
	int nb=0;
	String[] tableau_temporaire= new String[this.text.length-indent*50];
	for(int i=0;i<this.ligne_vide.length;i++){
	    int nb_avant=nb;
	    if(this.ligne_vide[i]!=-1){
	        nb=nb+1;
	    }
	    for(int j=0;j<50;j++){
		if(nb==nb_avant){
		    tableau_temporaire[i*50+j-nb*50]=this.text[i*50+j];
		}
	    }
	}
        this.text= new String[tableau_temporaire.length];
	for(int i=0;i<this.text.length;i++){
	    this.text[i]=tableau_temporaire[i];
	}
	int new_ligne_vide=this.ligne_vide.length-nb;
	this.ligne_vide=new int[new_ligne_vide];
	for(int i=0;i<this.ligne_vide.length;i++){
	    this.ligne_vide[i]=-1;
	}
    }
    public DessinDialogue getDessinDialogue(){
	return this.fond;
    }
    public int getInt(){
	return this.ent;
    }
    public int getTaille(){
	return this.text.length;
    }
    public String getText(int i){
	return this.text[i];
    }
    public String getPortrait(){
	return this.portrait;
    }
    public String getNom(){
	return this.nom;
    }
}
