/*
    https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
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
    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int result = 0;

        for (int index = i; index <= j; index++) {
            if (Math.abs(index - reverse(index)) % k == 0) {
                result++;
            }
        }

        return result;
    }

    static int reverse(int i) {
        StringBuilder result = new StringBuilder();

        result.append(i);

        return Integer.parseInt(result.reverse().toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
