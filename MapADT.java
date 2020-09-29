// --== CS400 File Header Information ==--
// Name: <Jiangang Chen>
// Email: <jiangang.chen@wisc.edu>
// Team: <HE>
// Role: <Test Engineering>
// TA: <Na Li>
// Lecturer: <Florian Heimerl>
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;

public interface MapADT<KeyType, ValueType> {

    public boolean put(KeyType key, ValueType value);
    public ValueType get(KeyType key) throws NoSuchElementException;
    public int size();
    public boolean containsKey(KeyType key);
    public ValueType remove(KeyType key);
    public void clear();

}