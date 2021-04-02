/*
    https://www.hackerrank.com/challenges/strong-password/problem
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

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int result = 0;
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);

            if (Pattern.matches("[0-9]", Character.toString(c))) {
                hasDigit = true;
            } else if (Pattern.matches("[a-z]", Character.toString(c))) {
                hasLower = true;
            } else if (Pattern.matches("[A-Z]", Character.toString(c))) {
                hasUpper = true;
            } else if (Pattern.matches("[!@#$%^&*()\\-+]", Character.toString(c))) {
                hasSpecial = true;
            }
        }

        if (!hasDigit) {
            result++;
        }
        if (!hasLower) {
            result++;
        }
        if (!hasUpper) {
            result++;
        }
        if (!hasSpecial) {
            result++;
        }

        int shorterLen = 6 - password.length();
        if (shorterLen < 1) {
            return result;
        } else {
            return (result > shorterLen) ? result : shorterLen;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
