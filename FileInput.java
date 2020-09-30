// --== CS400 File Header Information ==--
// Name: <Jiangang Chen>
// Email: <jiangang.chen@wisc.edu>
// Team: <HE>
// Role: <Test Engineering>
// TA: <Na Li>
// Lecturer: <Florian Heimerl>
// Notes to Grader: <optional extra notes>

import java.io.File;

public class FileInput {
    public static void main(String[] args) {
        HashTableMap table = new HashTableMap(50);
        File inputFile = new File("data1.txt");
        DataLoader loader = new DataLoader(inputFile, table);

        System.out.println("paul30's ID is: " + loader.getMap().get("paul30").getID());
    }

}
