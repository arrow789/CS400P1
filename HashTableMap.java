// --== CS400 File Header Information ==--
// Name: <Jiangang Chen>
// Email: <jiangang.chen@wisc.edu>
// Team: <HE>
// Role: <Test Engineering>
// TA: <Na Li>
// Lecturer: <Florian Heimerl>
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;

public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType>{
    private int capacity; // hash table capacitor
    private int size; // number of the occupied hash table index
    private int numOfPairs; // number of key-value pairs
    private PairNode<KeyType, ValueType>[] hashTable; // I create a new class called PairNode

    // Constructor
    public HashTableMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.numOfPairs = 0;
        this.hashTable = new PairNode[capacity];

    }

    // Constructor
    public HashTableMap() {
        this.capacity = 10;
        this.size = 0;
        this.numOfPairs = 0;
        this.hashTable = new PairNode[10];
    }

    @Override
    /**
     * this method passes a key into the hash table
     * @param key the key
     * @param value the value
     * @return true if the key-value pairs place in table, otherwise, false
     */
    public boolean put(KeyType key, ValueType value) {
        if(key == null) {
            throw new NoSuchElementException();
        }
        int index = hashFunction(key);
        if (this.hashTable[index] == null) {
            this.hashTable[index] = new PairNode(key, value);
            this.size++;
            this.numOfPairs++;
            this.checkAndReHash();
            return true;
        }else { // check the chain
            PairNode curNode = this.hashTable[index];
            if(curNode.getKey().equals(key)) { // check the first element of the chain
                return false;
            }else { // check rest of chain
                while (curNode.getNext() != null) { // loop the chain
                    if (curNode.getNext().getKey().equals(key)) {
                        return false;
                    }
                    curNode = curNode.getNext();
                }
                curNode.setNext(key, value);
                ++this.numOfPairs;
                checkAndReHash();
                return true;
            }
        }
    }

    @Override
    /**
     * return the value of matched key
     * @return the value of matched key
     */
    public ValueType get(KeyType key) throws NoSuchElementException {
        if (key == null) {
            throw new NoSuchElementException();
        }
        int index = hashFunction(key);
        if(this.hashTable[index] == null) { // if the PairNode is not exiting
            throw new NoSuchElementException();
        }else {
            if (this.hashTable[index].getKey().equals(key)) { // if the first node match
                return this.hashTable[index].getVal();
            }else { // check the rest of chain
                PairNode<KeyType, ValueType> curNode = this.hashTable[index];
                while(curNode.getNext() != null) { // loop whole chain
                    if (curNode.getNext().getKey().equals(key)) {
                        return curNode.getNext().getVal();
                    }else{
                        curNode = curNode.getNext();
                    }
                }
                throw new NoSuchElementException();
            }
        }
    }

    @Override
    /**
     * return the number of key-value pairs
     * @return the number of key-value pairs
     */
    public int size() {
        return this.numOfPairs;
    }

    @Override
    /**
     * Return true if the exits, otherwise, false
     * @param key the key
     * @return true if key exits, otherwise, false
     */
    public boolean containsKey(KeyType key) {
        int index = hashFunction(key);
        if (this.hashTable[index] == null) {
            return false;
        }else {
            if(this.hashTable[index].getKey().equals(key)) { // check the first element in chain
                return true;
            }else {
                PairNode curNode = this.hashTable[index];
                while(curNode.getNext() != null) { // loop the chain
                    if(curNode.getNext().getKey().equals(key)) {
                        return true;
                    }else {
                        curNode = curNode.getNext();
                    }
                }
                return false;
            }
        }
    }

    @Override
    /**
     * remove a key, and return its value; if key doesn't exit, return null
     * @param key the key
     * @return the value of the removed key
     */
    public ValueType remove(KeyType key) {
        int index = hashFunction(key);
        PairNode curNode = this.hashTable[index];
        if(curNode != null) {
            if(curNode.getKey().equals(key)) { // check the first node in chain
                if(curNode.getNext() != null) {
                    this.hashTable[index] = curNode.getNext();
                    return (ValueType) curNode.getVal();
                }else {
                    this.hashTable[index] =null;
                    --this.size;
                    return (ValueType) curNode.getVal();
                }
            }else { // check the rest of chain
                PairNode lastNode;
                while(curNode.getNext() != null) {
                    lastNode = curNode;
                    curNode = curNode.getNext();
                    if(curNode.getKey().equals(key)) {
                        lastNode.setNext(curNode.getNext());
                        // --this.size;
                        return (ValueType) curNode.getVal();
                    }
                }
                return null; // only one node and not match key Or no match in chain
            }
        }
        return null; // if the curNode is null
    }

    @Override
    /**
     * clear all key-val pairs
     */
    public void clear() {
        HashTableMap cleanTable = new HashTableMap(this.capacity);
        hashTable = cleanTable.getHashTable();
        this.size = 0;
        this.numOfPairs = 0;
//        for (int i = 0; i < this.capacity; ++i) {
//            if (this.hashTable[i] != null) {
//                this.hashTable[i].setNext(null);
//                this.hashTable[i] = null;
//            }
//        }
    }

    /**
     * hash table index generator by inputting key into hash function
     * @param key the key
     * @return the certain index in the hash table
     */
    public int hashFunction(KeyType key) {
        int index = (key.hashCode()) % this.capacity;
        return Math.abs(index);
    }

    /**
     * check whether the loadFactor has reached the threshold. Once it reaches, double the size and rehashing
     */
    private void checkAndReHash() {
        double loadFactor = (double)this.numOfPairs / this.capacity; // loadFactor can also calculated by this.size/this.capacitor,
                                                                     // this way will save some storage
        if(loadFactor >= 0.8) {
            HashTableMap newHashTable = new HashTableMap(this.capacity * 2);
            for (int i = 0; i < this.capacity; ++i) { // loop whole old hash table
                if(this.hashTable[i] != null) {
                    newHashTable.put(this.hashTable[i].getKey(), this.hashTable[i].getVal());
                    PairNode<KeyType, ValueType> currentNode = this.hashTable[i];
                    while (currentNode.getNext() != null) { // loop the chain
                        currentNode = currentNode.getNext();
                        newHashTable.put(currentNode.getKey(), currentNode.getVal());
                    }
                }
            }
            this.hashTable = newHashTable.getHashTable(); // include the hashtable and number of k-v pairs
            this.capacity = this.capacity * 2;
            this.size = newHashTable.sizeCounting();
        }
    }

    /**
     * count the number of occupied hash table index
     * @return the number of occupoed hash table index
     */
    public int sizeCounting() {
        int num = 0;
        for (PairNode<KeyType, ValueType> curNode : this.hashTable) {
            if(curNode != null) {
                ++num;
            }
        }
        return num;
    }

    /**
     * return the hashtable
     * @return hashtable
     */
    public PairNode<KeyType, ValueType>[] getHashTable() {
        return this.hashTable;
    }

    /**
     * return capacitor of the hash table
     * @return capacitor of the hash table
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * return the number of occupied hash table index
     * @return number of occupied hash table index
     */
    public int getSize() {
        return this.size;
    }

}
