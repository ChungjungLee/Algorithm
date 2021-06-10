package ps.realproblem;

import java.io.*;
import java.util.*;

/**
 * -----------------------------
 * Convert
 *
 * a
 *   b
 *     c
 *       d
 *       e
 *         f
 *     g
 *   h
 *     i
 *
 * to
 *
 * <a>
 *   <b>
 *     <c>
 *       <d></d>
 *       <e>
 *         <f></f>
 *       </e>
 *     </c>
 *     <g></g>
 *   </b>
 *   <h>
 *     <i></i>
 *   </h>
 * </a>
 * -----------------------------
 *
 * if the current indent is equal to or smaller than the previous one
 *      >> close tag popped from stack until indentation is same + open tag + keep stack
 * if the current indent is bigger than the previous one
 *      >> open tag + keep stack
 */

public class Trixxxx {
    static String openTag(String tag) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<").append(tag).append(">");

        return stringBuilder.toString();
    }

    static String closeTag(String tag) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("</").append(tag).append(">");

        return stringBuilder.toString();
    }

    static int getSpaces(String str) {
        int index = 0;

        while (str.charAt(index) == ' ') {
            index++;
        }

        return index;
    }

    static String solution(List<String> input) {
        StringBuilder stringBuilder = new StringBuilder();

        Stack<HashMap<Integer, String>> stack = new Stack<HashMap<Integer, String>>();
        HashMap<Integer, String> map = null;

        int currentSpaces = 0;
        int previousSpaces = -1;

        for (String str : input) {
            currentSpaces = getSpaces(str);

            map = new HashMap<Integer, String>();
            map.put(currentSpaces, str.trim());

            // if spaces is equal or less than previous
            if (currentSpaces <= previousSpaces) {
                boolean hasSameSpaces = true;

                while (hasSameSpaces) {
                    HashMap<Integer, String> previousMap = null;
                    previousMap = stack.peek();
                    for (Integer integer : previousMap.keySet()) {
                        if (currentSpaces > integer) {
                            hasSameSpaces = false;
                        }
                    }

                    if (hasSameSpaces) {
                        previousMap = stack.pop();
                        previousMap.forEach((k, v) -> stringBuilder.append(closeTag(v)));
                    }
                }
            }

            stringBuilder.append(openTag(str.trim()));
            stack.add(map);
            previousSpaces = currentSpaces;
        }

        while (!stack.isEmpty()) {
            map = stack.pop();
            map.forEach((k, v) -> stringBuilder.append(closeTag(v)));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Question.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Answer.txt"));

        List<String> input = new ArrayList<String>();

        String inputLine = bufferedReader.readLine();
        while (inputLine != null) {
            input.add(inputLine);
            inputLine = bufferedReader.readLine();
        }

        bufferedWriter.write(solution(input));

        bufferedReader.close();
        bufferedWriter.close();
    }

}
