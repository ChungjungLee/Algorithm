/*
    https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 */
package ps.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
        final String compareStr = "hackerrank";

        int candidateIndex = 0;
        int compareStrIndex = 0;
        while (candidateIndex < s.length()
                && compareStrIndex < compareStr.length()) {
            if (s.charAt(candidateIndex) == compareStr.charAt(compareStrIndex)) {
                candidateIndex++;
                compareStrIndex++;
                continue;
            }

            candidateIndex++;
        }

        if (compareStrIndex == compareStr.length()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
