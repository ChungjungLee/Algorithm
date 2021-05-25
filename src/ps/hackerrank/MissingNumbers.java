/*
    https://www.hackerrank.com/challenges/missing-numbers/problem
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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    // Write your code here
        Map<Integer, Integer> bMap = new HashMap<Integer, Integer>();
        for (Integer b : brr) {
            if (!bMap.containsKey(b)) {
                bMap.put(b, 1);
            } else {
                bMap.replace(b, bMap.get(b).intValue() + 1);
            }
        }
        
        for (Integer a : arr) {
            bMap.replace(a, bMap.get(a).intValue() - 1);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        Iterator<Map.Entry<Integer, Integer>> itr = bMap.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Integer, Integer> b = itr.next();
            
            if (b.getValue().intValue() != 0) {
                result.add(b.getKey());
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

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
