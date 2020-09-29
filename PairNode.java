// --== CS400 File Header Information ==--
// Name: <Jiangang Chen>
// Email: <jiangang.chen@wisc.edu>
// Team: <HE>
// Role: <Test Engineering>
// TA: <Na Li>
// Lecturer: <Florian Heimerl>
// Notes to Grader: <optional extra notes>

public class PairNode<KeyType, ValueType> {
    private KeyType key;
    private ValueType val;
    private PairNode<KeyType, ValueType> next;

    public PairNode(KeyType key, ValueType val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }

    public KeyType getKey() {
        return this.key;
    }

    public ValueType getVal() {
        return this.val;
    }

    public void setNext(KeyType key, ValueType val) {
        this.next = new PairNode<>(key, val);
    }

    public void setNext(PairNode node) {
        this.next = node;
    }

    public PairNode<KeyType, ValueType> getNext() {
        return this.next;
    }

}
