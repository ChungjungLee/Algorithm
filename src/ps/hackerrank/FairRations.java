/*
    https://www.hackerrank.com/challenges/fair-rations/problem
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

    // Complete the fairRations function below.
    static int fairRations(int[] B) {
        boolean hasOddsEvenly = true;
        int countBetweenOdds = 0;
        int result = 0;

        for (int i = 0; i < B.length; i++) {
            if (B[i] % 2 == 1 && hasOddsEvenly) {
                hasOddsEvenly = false;
            } else if (B[i] % 2 == 0 && !hasOddsEvenly) {
                countBetweenOdds++;
            } else if (B[i] % 2 == 1 && !hasOddsEvenly) {
                result += (countBetweenOdds % 2 == 0) ? 1 : 2;
                result += 2 * (countBetweenOdds / 2);
                hasOddsEvenly = true;
                countBetweenOdds = 0;
            }
        }

        if (hasOddsEvenly) {
            return result * 2;
        } else {
            return -1;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);

        if (result == -1) {
            bufferedWriter.write("NO");
        } else {
            bufferedWriter.write(String.valueOf(result));
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
