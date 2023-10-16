public class DNASequence {

    private DNALetter value;
    private DNASequence next;

    public DNASequence(DNALetter value) {
        this.value = value;
    }

    public DNALetter getValue() {
        return value;
    }

    public DNASequence getNext() {
        return next;
    }

    public void setNext(DNASequence next) {
        this.next = next;
    }
}
