/*
    https://www.hackerrank.com/challenges/game-of-thrones/problem
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
    // Write your code here
        boolean[] oddCounts = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
            oddCounts[s.charAt(i) - 'a'] = !oddCounts[s.charAt(i) - 'a'];
        }
        
        int numOddCount = 0;
        for (int i = 0; i < oddCounts.length; i++) {
            if (oddCounts[i]) {
                numOddCount++;
            }
        }
        
        if (numOddCount <= 1) {
            return "YES";
        } else {
            return "NO";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
