public class Chaine <E> implements Pile <E>{
    private Maillon<E> m;

    public Chaine(){
        this.m=null;
    }
    
    @Override
    public void addFirst(E element){
        Maillon<E> n = new Maillon<E>(element,this.m);
        this.m=n;
    }

    @Override
    public E removeFirst(){
        E element =this.m.getValue();
        this.m=this.m.getMaillon();
        return element;
    }

    @Override
    public boolean isEmpty(){
        return this.m==null;
    }
}