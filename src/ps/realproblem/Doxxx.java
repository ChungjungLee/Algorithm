/*
    Given an array A of N integers, 
    returns the smallest positive integer (> 0) that doesn't occur in A
    1 <= N <= 100000
    -1000000 <= A <= 1000000
 */
package realproblem;

class Doxxx {
    public static int solution(int[] input) {
        boolean[] isFound = new boolean[1000000];

        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                isFound[input[i]] = true;
            }
        }

        int result = 1;
        while (isFound[result]) {
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 6, 4, 1, 2};

        System.out.println(solution(input));
    }
}