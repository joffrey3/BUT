package fr.iutfbleau.info.fouche.genericite.listes;

import  java.util.*;

public class Test{
    public String comparer(Number a,Number b,ArrayList<?> liste){
        String chaine = "";
        if(this.verifier(a,b)){
            chaine = "la liste "+liste+" peut contenir "+b;
            return chaine;
        }else{
            chaine = "la liste "+liste+" ne peut pas contenir "+b;
            return chaine;
        }
    }
    public boolean verifier(Number a,Number b){
	if(a instanceof Byte){
      	    return b instanceof Byte;
	}
	else if(a instanceof Short){
	    return b instanceof Short;
	}
	else if(a instanceof Integer){
	    return b instanceof Integer;
	}
	else if(a instanceof Long){
	    return b instanceof Long;
	}
	else if(a instanceof Float){
	    return b instanceof Float;
	}
	return true;
    }
}
