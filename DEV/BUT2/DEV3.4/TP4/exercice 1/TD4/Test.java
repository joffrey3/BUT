import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        DNAStrand s = new DNAStrand();

        s.addLast(DNALetter.A);
        s.addLast(DNALetter.C);
        s.addLast(DNALetter.G);
        s.addLast(DNALetter.T);


        Iterator<DNALetter> i = s.iterator();
        while (i.hasNext()) {
            System.out.println(i.next().getValue());
        }
    }   
}
