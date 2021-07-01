/*
    https://www.hackerrank.com/challenges/grid-challenge/problem
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
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
    // Write your code here
        if (grid.size() == 1) {
            return "YES";
        }
        
        ArrayList<PriorityQueue<Character>> list = 
                new ArrayList<PriorityQueue<Character>>();
        
        for (String str : grid) {
            PriorityQueue<Character> queue = new PriorityQueue<Character>();
            
            for (Character cha : str.toCharArray()) {
                queue.add(cha);
            }
            
            list.add(queue);
        }

        for (int i = 0; i < grid.get(0).length(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j - 1).peek() > list.get(j).peek()) {
                    return "NO";
                }
            }
            
            for (int k = 0; k < list.size(); k++) {
                list.get(k).poll();
            }
        }
        
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
