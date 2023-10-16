public class Room_recupere implements Room{
    private int id;
    private int valeur;
    public Room_recupere(int i,int v){
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