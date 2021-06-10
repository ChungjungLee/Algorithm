package ps.realproblem;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

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

public class TrixxxxVer2 {
    static class Line {
        private final int spaces;
        private final String tag;

        public Line(int spaces, String tag) {
            this.spaces = spaces;
            this.tag = tag;
        }

        public int getSpaces() {
            return spaces;
        }

        public String getTag() {
            return tag;
        }
    }

    static String writeTag(Line line, boolean isClose) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < line.getSpaces(); i++) {
            stringBuilder.append(" ");
        }

        stringBuilder.append("<");

        if (isClose) {
            stringBuilder.append("/");
        }

        stringBuilder.append(line.getTag()).append(">").append("\n");

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

        Stack<Line> stack = new Stack<Line>();
        Line line;

        int currentSpaces = 0;
        int previousSpaces = -1;

        for (String str : input) {
            currentSpaces = getSpaces(str);
            line = new Line(currentSpaces, str.trim());

            // if spaces is equal or less than previous
            if (currentSpaces <= previousSpaces) {
                boolean hasSameSpaces = true;

                while (hasSameSpaces) {
                    Line previousLine = stack.peek();

                    if (currentSpaces > previousLine.getSpaces()) {
                        hasSameSpaces = false;
                    }

                    if (hasSameSpaces) {
                        previousLine = stack.pop();
                        stringBuilder.append(writeTag(previousLine, true));
                    }
                }
            }

            stringBuilder.append(writeTag(line, false));
            stack.add(line);
            previousSpaces = currentSpaces;
        }

        while (!stack.isEmpty()) {
            line = stack.pop();
            stringBuilder.append(writeTag(line, true));
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
