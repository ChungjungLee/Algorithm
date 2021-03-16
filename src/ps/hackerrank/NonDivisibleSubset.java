/*
    https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */
package ps.hackerrank;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        Map<Integer, Integer> remainsMap = new HashMap<Integer, Integer>();

        for (Integer i : s) {
            if (remainsMap.containsKey(i % k)) {
                int times = remainsMap.get(i % k) + 1;
                remainsMap.replace(i % k, times);
            } else {
                remainsMap.put(i % k, 1);
            }
        }

        int result = 0;
        for (int i = 0; i <= k / 2; i++) {
            result += moreCount(remainsMap, i, k);
        }

        return result;
    }

    private static int moreCount(Map<Integer, Integer> remainsMap, int i, int k) {
        Integer a = remainsMap.get(i);
        Integer b = remainsMap.get(k - i);

        if (i == 0 || i * 2 == k) {
            return (Objects.isNull(a) && Objects.isNull(b)) ? 0 : 1;
        }

        if (Objects.isNull(a)) {
            return (Objects.isNull(b)) ? 0 : b;
        } else {
            return (Objects.isNull(b)) ? a : Math.max(a, b);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
