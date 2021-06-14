/*
    https://www.hackerrank.com/challenges/gem-stones/problem
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
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */

    public static int gemstones(List<String> arr) {
    // Write your code here
        boolean[][] found = new boolean[arr.size()][27];
        
        for (int i = 0; i < arr.size(); i++) {
            String str = arr.get(i);
            
            for (int j = 0; j < str.length(); j++) {
                found[i][str.charAt(j) - 'a'] = true;
            }
        }
        
        int result = 0;
        for (int j = 0; j < found[0].length; j++) {
            boolean allFound = true;
            
            for (int i = 0; i < found.length; i++) {
                if (!found[i][j]) {
                    allFound = false;
                    break;
                }
            }
            
            if (allFound) {
                result++;
            }
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result.gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
