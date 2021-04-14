/*
    https://www.hackerrank.com/challenges/bigger-is-greater/problem
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the biggerIsGreater function below.
    // w = abdc
    static String biggerIsGreater(String w) {
        StringBuilder builder = new StringBuilder();
        
        // ab (d)c
        int splitIndex = w.length() - 1;
        while (splitIndex > 0) {
            // ab dc
            if (w.charAt(splitIndex) > w.charAt(splitIndex - 1)) {
                break;
            }
            splitIndex--;
        }
        
        if (splitIndex == 0) {
            return "no answer";
        }
        
        // result = a
        builder.append(w.substring(0, splitIndex - 1));
        
        // ab d(c)
        int changeIndex = w.length() - 1;
        while (changeIndex >= splitIndex) {
            if (w.charAt(changeIndex) > w.charAt(splitIndex - 1)) {
                // result = ac
                builder.append(w.charAt(changeIndex));
                break;
            }
            changeIndex--;
        }
        
        for (int i = w.length() - 1; i > changeIndex; i--) {
            // result = ac
            builder.append(w.charAt(i));
        }
        
        // result = acb
        builder.append(w.charAt(splitIndex - 1));
        
        for (int i = changeIndex - 1; i >= splitIndex; i--) {
            // result = acbd
            builder.append(w.charAt(i));
        }
        
        return builder.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
