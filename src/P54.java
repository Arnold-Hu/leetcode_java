//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//    Example 1:
//
//    Input:
//    [
//    [ 1, 2, 3 ],
//    [ 4, 5, 6 ],
//    [ 7, 8, 9 ]
//    ]
//    Output: [1,2,3,6,9,8,7,4,5]
//    Example 2:
//
//    Input:
//    [
//    [1, 2, 3, 4],
//    [5, 6, 7, 8],
//    [9,10,11,12]
//    ]
//    Output: [1,2,3,4,8,12,11,10,9,5,6,7]

import java.util.LinkedList;
import java.util.List;

public class P54 {

    public static void main(String[] args) {
        P54 p54 = new P54();
        System.out.println();
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new LinkedList<>();
        }
        if (matrix[0].length == 0) {
            return new LinkedList<>();
        }

        int line = 0;
        int row = 0;
        int lineGap = matrix.length;
        int rowGap = matrix[0].length;
        List<Integer> ret = new LinkedList<>();
        while (lineGap > 0 && rowGap > 0) {
            if (lineGap == 1) {
            }
            for (int i = 0; i < rowGap; i++ ){
                ret.add(matrix[line][row + i]);
            }
            for (int i = 0; i < lineGap - 2; i ++) {
                ret.add(matrix[line + i + 1][row + rowGap - 1]);
            }
            if (lineGap > 1) {
                for (int i = 0; i < rowGap; i++) {
                    ret.add(matrix[line + lineGap - 1][row + rowGap - 1 - i]);
                }
            }
            if (rowGap > 1) {
                for (int i = 0; i < lineGap - 2; i ++) {
                    ret.add(matrix[line + lineGap - 2 - i][row]);
                }
            }
            lineGap -= 2;
            rowGap -= 2;
            line++;
            row++;
            System.out.println(lineGap);
            System.out.println(rowGap);
        }

        return ret;
    }


}
