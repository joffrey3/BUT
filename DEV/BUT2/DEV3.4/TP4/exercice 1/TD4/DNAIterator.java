import java.util.Iterator;

public class DNAIterator implements Iterator<DNALetter> {

    private DNASequence first;

    public DNAIterator(DNASequence first) {
        this.first = first;
    }

    @Override
    public boolean hasNext() {
        return first != null;
    }

    @Override
    public DNALetter next() {
        DNALetter curr = first.getValue();
        first = first.getNext();
        return curr;
    }
    
}
