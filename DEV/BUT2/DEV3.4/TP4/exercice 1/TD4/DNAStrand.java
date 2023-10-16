import java.util.Iterator;

/**
 * DNAStrand
 */
public class DNAStrand implements Iterable {

    private DNASequence sequence;
    private DNASequence last;

    public DNAStrand() {
        
    }

    public void addLast(DNALetter letter) {
        if (sequence != null) {
            last.setNext(new DNASequence(letter));
            last = last.getNext();
        } else {
            sequence = new DNASequence(letter);
            last = sequence;
        }
    }


    @Override
    public Iterator<DNALetter> iterator() {
        return (new DNAIterator(sequence));
    }

    
}