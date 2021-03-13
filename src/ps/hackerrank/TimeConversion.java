/*
    https://www.hackerrank.com/challenges/time-conversion/problem
 */
package ps.hackerrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        int hhInt = Integer.valueOf(s.substring(0, 2));
        String ampm = s.substring(8);

        hhInt = ("PM".equals(ampm)) ? (hhInt % 12) + 12 : hhInt % 12;
        String hh = (hhInt < 10) ? "0" + hhInt : String.valueOf(hhInt);

        return hh + s.substring(2, 8);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
