/*
    https://www.hackerrank.com/challenges/big-sorting/problem
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
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */
    
    static List<String> bigSorting(List<String> unsorted) {
        // Write your code here
        Comparator<String> bigSortingComparator = new Comparator<String>(){
            public int compare(String str1, String str2){
                if (str1 == str2) {
                    return 0;
                }
                
                if (str1.length() > str2.length()) {
                    return 1;
                }
                
                if (str1.length() < str2.length()) {
                    return -1;
                }
                
                for (int i = 0; i < str1.length(); i++) {
                    if (str1.charAt(i) > str2.charAt(i)) {
                        return 1;
                    }
                    
                    if (str1.charAt(i) < str2.charAt(i)) {
                        return -1;
                    }
                }
                
                return 0;
            }
        };
        
        Collections.sort(unsorted, bigSortingComparator);
        
        return unsorted;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bigSorting(unsorted);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
