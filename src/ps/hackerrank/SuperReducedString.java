/*
    https://www.hackerrank.com/challenges/reduced-string/problem
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
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
    // Write your code here
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        
        if (stack.empty()) {
            return "Empty String";
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
