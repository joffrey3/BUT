public class Maillon <E>{
    private E element;
    private Maillon<E> maillon;

    public Maillon(E e,Maillon<E> m){
        this.maillon=m;
        this.element=e;
    }
    public E getValue(){
        return this.element;
    }
    public Maillon<E> getMaillon(){
        return this.maillon;
    }
}