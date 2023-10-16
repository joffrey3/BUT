//Fouché Joffrey

public class Doublon implements Ensemble{
    private Liste[] liste= new Liste[100];
    public Doublon(){
        for(int i=0;i<liste.length;i++){
            this.liste[i]=new Liste();
        }
    }
    public boolean ajouter(int element){
        int key = this.hachage(element);
        if(liste[key]!=null){
            if(liste[key].egale(element)){
                return false;
            }
        }
        liste[key].add(element);
        return true;
    }
    public int hachage(int element){
        return element%100;
    }
}
