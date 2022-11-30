import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class KMP {
    public static void main(String[] args) throws Exception {
        Scanner testInput = new Scanner(System.in);

        SearchPlag searchPlag = new SearchPlag();

        String stringTest = "";
        String stringPattern = "";

        System.out.println("Enter a test file : ");
        String testFile = testInput.nextLine();
        Scanner patternInput = new Scanner(System.in);
        System.out.println("Enter a pattern file : ");
        String patternFile = patternInput.nextLine();
        System.out.println("///////////////// OUTPUT /////////////////");

        FileReader testFileReader = new FileReader(testFile);

        BufferedReader testBufferedReader = new BufferedReader(testFileReader);

        FileReader patternFileReader = new FileReader(patternFile);

        BufferedReader patternBufferedReader = new BufferedReader(patternFileReader);

        try {
            while (testBufferedReader.ready()) {
                stringTest += (char) testBufferedReader.read();
            }
            while (patternBufferedReader.ready()) {
                stringPattern += (char) patternBufferedReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int lengthOfTest = stringTest.length();
        searchPlag.KMPSearch(stringPattern.toLowerCase(), stringTest.toLowerCase());
        searchPlag.calculateThresholdValue(lengthOfTest);

    }
}
