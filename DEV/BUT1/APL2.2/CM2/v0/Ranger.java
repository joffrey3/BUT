/**
 * interface simpliste pour une mémoire de capacitée limitée contenant des chaînes de charactèes (String) dans l'ordre.
 * On ne peut qu'ajouter de l'information. On peut ajouter plusieurs fois le même contenu.
 *
 * on peut ajouter null, ce qui revient à faire de la place, sauf si la mémoire est déjà remplie de null.
 */
interface Ranger {
    /**
     * ajoute s à la mémoire
     *
     * si s n'est pas null celà revient à ajouter s si il reste un emplacement libre (null).
     *
     * si s est null celà revient à éliminer le plus petit String mémorisé qui n'est pas null.
     *
     * Notez que l'implémentation n'est pas obligé de ranger les éléments dans l'ordre mais c'est probablement plus simple pour coder la méthode suivante. 
     * On aurait pu nommer cette méthode : se-souvenir-de (quelque chose) et le ranger dans l'ordre
     *
     * @param  s String qui peut être nul
     * @return void
     * @throws IllegalStateException si la mémoire est pleine de String instantié et que s est instantié (trop plein) ou la mémoire est pleine de null et s est null (trop vide).
     */
    public void add (String s);
    
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
    public String content(int i);

    /**
     * retourne le nombre maximal d'éléments que la mémoire peut contenir.
     * @return int
     */
    public int capacity();

    
    
}
