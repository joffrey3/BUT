import java.util.*;
import java.text.*;
import java.awt.*;
import javax.swing.*;

public class Liste <E>{
    private Association<E> maillon;

    public Liste(Association<E> e){
        this.maillon=e;
    }
    public Liste(){
        this.maillon=null;
    }

    @Override
    public String toString(){
        String chaine;
        if(this.maillon!=null){
            chaine = "La liste est composée des élements suivants : \n"+this.maillon.toString();
        }else{
            chaine = "La liste est composée des élements suivants : null\n";
        }
        return chaine;
    }

    public Association<E> getMaillon(){
        return this.maillon;
    }

    public void setMaillon(Association<E> e){
        this.maillon=e;
    }
}