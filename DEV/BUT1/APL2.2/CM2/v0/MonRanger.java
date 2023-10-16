import java.util.Objects;
import java.lang.StringBuilder;
/**
 * implémentation de l'interface Ranger.
 * La mémoire, non extensible, ne peut contenir que 8 String.
 *
 * La mémoire est un tableau qui stocke les éléments de la gauche vers la droite dans un ordre inspiré du dictionnaire.
 * D'abord null puis les Strings instantiés dans l'ordre de  String.compareTo(String).
 * 
 * ajouter null permet de faire de la place, sauf si la mémoire est déjà remplie de null.
 * 
 */
public class MonRanger implements Ranger {

    // nombre maximum d'éléments de la mémoire
    private int capacity;
    // la mémoire est un tableau
    private String[] mem;

    
    public MonRanger(){
        this.capacity = 8;
        this.mem = new String[8];//BUGFIX Si la memoire peut contenir 8 String alors il est necessaire d'avoir un tableau de taille 8
    }


    /**
     * ajoute s à la mémoire
     * On aurait pu nommer cette méthode : se-souvenir-de (quelque chose) et le ranger dans l'ordre
     *
     * Cette implémentation procède par insertion de la fin vers le début pour une entrée qui n'est pas null, suivi d'un décalage vers la gauche éventuel.
     *
     * Si l'entrée est null, au contraire le balayage se fait de gauche à droite en 
     *
     * @param  s String qui peut être nul
     * @return void
     * @throws IllegalStateException si la mémoire est pleine de String instantié et que s est instantié (trop plein) ou la mémoire est pleine de null et s est null (trop vide).
     */
    public void add (String s){
        // s is null
        if (null == s){
            for(int i =0; i<this.capacity();i++){
                if(null != this.mem[i]){
                    this.mem[i]=null; //BUGFIX la ligne précédante n'était pas utile elle n'apportait rien au programme (Boolean b = (this.mem[i]==null);), l'important ici est de rendre une case null  sur un case avec un String lorsque l'on ajoute un attribut null
                    return;// nothing to return, method return type is void
                }
            }
            throw new IllegalStateException("La mémoire est trop vide");
        }
        else{// s is not null
            Boolean search = true;
            String propagate = null;
            for(int i = this.capacity()-1; i>=0 ; i--){
                if(search && null == this.mem[i]){//il faut insérer ici puis ne pas décaler
                    this.mem[i]=s;
                    return;// nothing to return, method return type is void
                }
                if (search){//on trouve l'index d'insertion de s, il faudra décaler ensuite. //BUGFIX On retire la partie suivante (&& (this.mem[i].compareTo(s) >= 0)) car elle empeche d'ajouter des éléments différents est de remplir la memoire
                    propagate = this.mem[i]; 
                    this.mem[i]=s;    
                    search = false;
                }
                else if (!search && null != propagate ){//on a trouvé, il faut décaler à gauche
                    String tmp = propagate;
                    propagate = this.mem[i];
                    this.mem[i] = tmp;
                }
                if(null == propagate){//plus rien à décaler
                    return;// nothing to return, method return type is void
                }
            }
            throw new IllegalStateException("La mémoire est trop pleine");//BUGFIX Si la mémoire est trop pleine elle sort de la boucle sans lever d'exception
        }
    }
    
    /**
     * retourne le contenu en ième position dans la mémoire.
     *
     * L'ordre du contenu doit être le suivant : null est plus petit que tout String instantié.
     * ensuite c'est l'ordre du dictionnaire. En pratique, on fera confiance à 
     * String.compareTo(String).
     *
     * @param i int entre 1 et capacity() inclus.
     * @return le ième String mémorisé dans l'ordre du dictionnaire.
     * @throws IllegalArgumentException si i est en dehors de la plage 1 à capacity.
     */
    public String content(int i){
        if (i < 1 || i > this.capacity()) throw new IllegalArgumentException(i + " est en dehors de la plage mémoire");
        return this.mem[i-1];
    }

    /**
     * retourne le nombre maximal d'éléments que la mémoire peut contenir.
     * @return int
     */
    public int capacity(){
        return this.capacity;
    }


    // pour afficher, on surcharge ToString
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.capacity(); i++){
            sb.append(this.mem[i]);
            if (i != this.capacity() - 1){
                sb.append(", ");
            }
            else {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}

