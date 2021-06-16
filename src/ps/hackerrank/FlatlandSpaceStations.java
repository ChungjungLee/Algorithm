/*
    https://www.hackerrank.com/challenges/flatland-space-stations/problem
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        // 10
        // 2 6 9
        // 0 1 (2) 3 4 5 (6) 7 8 (9)
        // 2=(2-0)  2=(6-2)/2  1=(9-6)/2  0=(9-9)
        Arrays.sort(c);
        
        int result = c[0] - 0;
        
        for (int i = 0; i < c.length - 1; i++) {
            result = Math.max(result, (int)(c[i+1] - c[i]) / 2);
        }
        
        return Math.max(result, n - 1 - c[c.length - 1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
