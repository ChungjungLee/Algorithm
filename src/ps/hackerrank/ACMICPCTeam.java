/*
    https://www.hackerrank.com/challenges/acm-icpc-team/problem
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

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int[] numOfTeamsKnowingTopic = new int[501];
        int m = topic[0].length();

        for (int i = 0; i < topic.length - 1; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                int knownTopic = 0;

                for (int k = 0; k < m; k++) {
                    if (topic[i].charAt(k) == '1' || topic[j].charAt(k) == '1') {
                        knownTopic++;
                    }
                }

                numOfTeamsKnowingTopic[knownTopic]++;
            }
        }

        int maxNumOfKnowingTopic = numOfTeamsKnowingTopic.length - 1;

        while (maxNumOfKnowingTopic >= 0) {
            if (numOfTeamsKnowingTopic[maxNumOfKnowingTopic] != 0) {
                break;
            }
            maxNumOfKnowingTopic--;
        }

        int[] result = {maxNumOfKnowingTopic, numOfTeamsKnowingTopic[maxNumOfKnowingTopic]};
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
