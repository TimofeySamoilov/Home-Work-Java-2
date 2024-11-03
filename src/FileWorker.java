import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class FileWorker {
    public static void fileWork() {
        FileReader inputFile = null;
        FileWriter outputFile = null;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please write a input file name:");
            String fileName = sc.next();
            inputFile = new FileReader("inputfiles/" + fileName);
            //
            System.out.println("Please write a output file name:");
            fileName = sc.next();
            outputFile = new FileWriter("outputfiles/" + fileName);
        } catch (FileNotFoundException ex) {
            System.out.println("File is not found!");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Failed to open file for writing!");
            System.exit(0);
        }
        ArrayList<Integer> charactersArray = new ArrayList<Integer>();
        try {
            int character;
            while ((character = inputFile.read()) != -1) {
                charactersArray.add(character);
            }
            inputFile.close();
        } catch (IOException ex) {
            System.out.println("Failed to Read!");
            System.exit(0);
        }
        int[] arr = toSortedPairs(charactersArray);
        try {
            for (int i = 0; i < 130; ++i) {
                if (arr[i] > 0) {
                    outputFile.write((char) i + " : " + arr[i] + "\n");
                }
            }
            outputFile.close();
        } catch (IOException ex) {
            System.out.println("Failed with file writing!");
            System.exit(0);
        }
    }
    private static int[] toSortedPairs(ArrayList<Integer> charactersArray) {
        // A - Z: 65 - 90 ------ a - z: 97 - 122
        int[] arr = new int[130];
        for (int i = 0; i < charactersArray.size(); ++i) {
            if ((charactersArray.get(i) > 64 && charactersArray.get(i) < 91) || (charactersArray.get(i) > 96 && charactersArray.get(i) < 123)) {
                ++arr[charactersArray.get(i)];
            }
        }
        return arr;
    }
}
