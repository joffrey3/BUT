public interface Pile <E>{

    void addFirst(E element);

    E removeFirst();
    
    boolean isEmpty();
}