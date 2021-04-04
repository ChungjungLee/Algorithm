/*
    https://www.hackerrank.com/challenges/cavity-map/problem
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

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {

        int n = grid.length;
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder line = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
                    line.append(Character.toString(grid[i].charAt(j)));
                    continue;
                }

                if (grid[i].charAt(j) > grid[i - 1].charAt(j)
                        && grid[i].charAt(j) > grid[i].charAt(j - 1)
                        && grid[i].charAt(j) > grid[i + 1].charAt(j)
                        && grid[i].charAt(j) > grid[i].charAt(j + 1)) {
                    line.append("X");
                } else {
                    line.append(Character.toString(grid[i].charAt(j)));
                }
            }

            result[i] = line.toString();
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
