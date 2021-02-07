/*
    https://www.hackerrank.com/challenges/append-and-delete/problem
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

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        int index = 0;

        while (index < s.length() && index < t.length()) {
            if (s.charAt(index) != t.charAt(index)) {
                break;
            }
            index++;
        }

        int minOperations = s.length() - index + t.length() - index;

        if (minOperations == 0) {
            return (k / 2 >= s.length() || k % 2 == 0) ? "Yes" : "No";
        } else {
            if (minOperations > k) {
                return "No";
            } else if (k >= minOperations + index * 2 || (k - minOperations) % 2 == 0) {
                return "Yes";
            } else {
                return "No";
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
