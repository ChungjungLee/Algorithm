/*
    https://www.hackerrank.com/challenges/find-digits/problem
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

    // Complete the findDigits function below.
    static int findDigits(int n) {
        boolean[] isDivisibleByDigit = new boolean[9];

        for (int i = 0; i < isDivisibleByDigit.length; i++) {
            isDivisibleByDigit[i] = (n % (i + 1) == 0) ? true : false;
        }

        int[] countOfDigit = new int[9];

        while (n > 0) {
            if (n % 10 != 0) {
                countOfDigit[n % 10 - 1]++;
            }

            n /= 10;
        }

        int result = 0;

        for (int i = 0; i < countOfDigit.length; i++) {
            if (isDivisibleByDigit[i]) {
                result += countOfDigit[i];
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
