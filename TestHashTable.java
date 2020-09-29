// --== CS400 File Header Information ==--
// Name: <Jiangang Chen>
// Email: <jiangang.chen@wisc.edu>
// Team: <HE>
// Role: <Test Engineering 1>
// TA: <Na Li>
// Lecturer: <Florian Heimerl>
// Notes to Grader: <optional extra notes>

public class TestHashTable {

    public static void main(String []args) {
        // put test
        HashTableMap put = new HashTableMap(10);
        testForPut(put);

        // resizing and rehashing test
        HashTableMap reHashing = new HashTableMap(6);
        testForRehashing(reHashing);

        // containsKeys test
        HashTableMap containsKeys = new HashTableMap(6);
        testForContainsKeys(containsKeys);

        // get test
        HashTableMap get = new HashTableMap(6);
        testForGet(get);

        // clear test
        HashTableMap clear = new HashTableMap(6);
        testForClear(clear);

    }

    public static boolean testForPut(HashTableMap hashTable) {
        System.out.println("1,1: " + hashTable.put(1, 1));
        System.out.println("11,1: " + hashTable.put(11, 1));
        System.out.println("1,1: " + hashTable.put(1, 1));
        System.out.println("2,1: " + hashTable.put(2, 1));
        System.out.println("3,1: " + hashTable.put(3, 1));
        System.out.println("--------------------------------------------------");
        return true; // pass;
    }

    public static boolean testForRehashing(HashTableMap hashTable) {
        System.out.println("1,1: " + hashTable.put(1, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("2,1: " + hashTable.put(2, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("7,1: " + hashTable.put(7, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("3,1: " + hashTable.put(3, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("4,1: " + hashTable.put(4, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("5,1: " + hashTable.put(5, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("6,1: " + hashTable.put(6, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("8,1: " + hashTable.put(8, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("9,1: " + hashTable.put(9, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("10,1: " + hashTable.put(10, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("--------------------------------------------------");
        return true; // pass
    }

    public static boolean testForContainsKeys(HashTableMap hashTable) {
        System.out.println("1,1: " + hashTable.put(1, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("2,1: " + hashTable.put(2, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("7,1: " + hashTable.put(7, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("3,1: " + hashTable.put(3, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("4,1: " + hashTable.put(4, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("5,1: " + hashTable.put(5, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("6,1: " + hashTable.put(6, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("search 1: " + hashTable.containsKey(1));
        System.out.println("search 2: " + hashTable.containsKey(2));
        System.out.println("search 7: " + hashTable.containsKey(7));
        System.out.println("search 3: " + hashTable.containsKey(3));
        System.out.println("search 4: " + hashTable.containsKey(4));
        System.out.println("search 5: " + hashTable.containsKey(5));
        System.out.println("search 6: " + hashTable.containsKey(6));
        System.out.println("--------------------------------------------------");
        return true; // pass
    }


    public static boolean testForGet(HashTableMap hashTable) {
        System.out.println("1,1: " + hashTable.put(1, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("2,2: " + hashTable.put(2, 2) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("7,7: " + hashTable.put(7, 7) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("3,3: " + hashTable.put(3, 3) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("4,4: " + hashTable.put(4, 4) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("5,5: " + hashTable.put(5, 5) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("6,6: " + hashTable.put(6, 6) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("Get 1 value: " + hashTable.get(1));
        System.out.println("Get 2 value: " + hashTable.get(2));
        System.out.println("Get 7 value: " + hashTable.get(7));
        System.out.println("Get 3 value: " + hashTable.get(3));
        System.out.println("Get 4 value: " + hashTable.get(4));
        System.out.println("Get 5 value: " + hashTable.get(5));
        System.out.println("Get 6 value: " + hashTable.get(6));
        System.out.println("--------------------------------------------------");
        return true; // pass
    }

    public static boolean testForClear(HashTableMap hashTable) {
        System.out.println("1,1: " + hashTable.put(1, 1) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("2,2: " + hashTable.put(2, 2) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("7,7: " + hashTable.put(7, 7) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("3,3: " + hashTable.put(3, 3) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("4,4: " + hashTable.put(4, 4) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("5,5: " + hashTable.put(5, 5) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("6,6: " + hashTable.put(6, 6) + "; numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        hashTable.clear();
        System.out.println("Clear: numOfPairs: " + hashTable.size() + "; size: " + hashTable.getSize() + "; Cap: " + hashTable.getCapacity());
        System.out.println("--------------------------------------------------");
        return true;
    }

}