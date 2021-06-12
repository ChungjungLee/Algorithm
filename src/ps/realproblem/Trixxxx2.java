package ps.realproblem;

import java.util.*;
/*
 * MxNの行列について、要素が0であれば、その行と列のすべてを0にする。
 */
public class Trixxxx2 {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 3}, {0, 4, 5}};

        Set<Integer> rowIndices = new HashSet<Integer>();
        Set<Integer> colIndices = new HashSet<Integer>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 0) {
                    rowIndices.add(i);
                    colIndices.add(j);
                }
            }
        }

        Iterator<Integer> rowIterator = rowIndices.iterator();
        while (rowIterator.hasNext()) {
            int rowIndex = rowIterator.next().intValue();
            for (int i = 0; i < input[0].length; i++) {
                input[rowIndex][i] = 0;
            }
        }

        Iterator<Integer> colIterator = colIndices.iterator();
        while (colIterator.hasNext()) {
            int colIndex = colIterator.next().intValue();
            for (int i = 0; i < input.length; i++) {
                input[i][colIndex] = 0;
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
}