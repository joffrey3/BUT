/**
 * interface simpliste pour une mémoire de capacitée limitée contenant des chaînes de charactèes (String).
 */
interface Memoire {
    /**
     * ajoute s à la mémoire
     * On aurait pu nommer cette méthode : se-souvenir-de(quelque chose).
     *
     * Les exceptions sont levés dans l'ordre de cette documentation.
     * Par exemple si la mémoire est pleine et qu'on ajoute null, 
     * c'est une NullPointerException qui doit être levée.
     *
     * @param  s String
     * @return void
     * @throws NullPointerException si s est null
     * @throws ArrayIndexOutOfBoundsException si la mémoire est pleine
     * @throws IllegalStateException si s est déjà présent
     */
    public void add (String s);
    
    /**
     * enlève un élément de la mémoire pour faire de la place
     * On aurait pu nommer cette méthode : oublie.
     *
     * @return cet élément
     * @throws IllegalStateException si la memoire est vide
     */
    public String remove ();

    /**
     * teste si un String est présent en mémoire. 
     * On aurait pu nommer cette méthode : est-ce-que-je-connaîs?
     *
     * @param s String
     * @return true ssi s est présent en mémoire
     * @throws NullPointerException si s est null
     */
    public Boolean contain (String s);

    /**
     * retourne le nombre d'éléments de la mémoire
     * @return int
     */
    public int size();

    /**
     * retourne le nombre maximal d'éléments que la mémoire peut contenir.
     * @return int
     */
    public int capacity();

    
    
}
