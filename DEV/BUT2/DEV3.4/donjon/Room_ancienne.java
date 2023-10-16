public class Room_ancienne implements Room{
    private int id;
    private int valeur;
    public Room_ancienne(int i,int v){
        this.id=i;
        this.valeur=v;
    }
    public int getId(){
        return this.id;
    }
    public int getValeur(){
        return this.valeur;
    }
    public void setValeur(int v){
        this.valeur=v;
    }
}