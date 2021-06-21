/*
    https://www.hackerrank.com/challenges/making-anagrams/problem
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
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
    // Write your code here
        Map<Character, Integer> s1Counts = new HashMap<Character, Integer>();
        Map<Character, Integer> s2Counts = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1Counts.containsKey(s1.charAt(i))) {
                s1Counts.put(s1.charAt(i), s1Counts.get(s1.charAt(i)) + 1);
            } else {
                s1Counts.put(s1.charAt(i), 1);
            }
        }
        
        for (int i = 0; i < s2.length(); i++) {
            if (s1Counts.containsKey(s2.charAt(i))) {
                s1Counts.put(s2.charAt(i), s1Counts.get(s2.charAt(i)) - 1);
                continue;
            }
            
            if (s2Counts.containsKey(s2.charAt(i))) {
                s2Counts.put(s2.charAt(i), s2Counts.get(s2.charAt(i)) + 1);
            } else {
                s2Counts.put(s2.charAt(i), 1);
            }
        }
        
        int result = 0;
        
        for (Integer s1Count : s1Counts.values()) {
            result += Math.abs(s1Count.intValue());
        }
        
        for (Integer s2Count : s2Counts.values()) {
            result += s2Count.intValue();
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
