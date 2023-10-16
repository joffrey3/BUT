import javax.swing.JComponent;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.lang.Object;
import java.awt.Color;
import java.lang.Object;
import java.awt.Font;
import java.awt.event.*; 
//La classe Maths ne sert qu'a centrer les éléments de la grille lorsqu'elle est affichée
public class Maths {
    public Maths(){
    }

    //elle définit la taille de la fenetre en fonction de la taille de la grille mais qui ne peut pas etre inférieur à 200
    public int Fenetre_taille(int c) {
	if(c<7){
	    return 210;
	}
	else{
	    return c*30+10;
	}
    }

    //Lorsque la grille est inférieure à 7, elle doit être centrée par rapport aux autres éléments
    public int Grille_centre(int c) {
	if(c<7){
	    return 100-c*15;
	}
	else{
	    return 0;
	}
    }

    //Lorsque la grille est supérieure à 6, les autres éléments doivent être centrés par rapport à la grille
    public int Composant_centre(int c) {
    	if(c>=7){
	    return c*15-100;
	}
	else{
	    return 0;
	}
    }
}
