import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class P37 {

//    public void solveSudoku(char[][] board) {
//        List<Pair> emptyList = new ArrayList<>(81);
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] == '.') {
//                    emptyList.add(new Pair(i, j));
//                }
//            }
//        }
//
//
//        int index = 0;
//        while (index < emptyList.size()) {
//            Pair pair = emptyList.get(index);
//            int start = '1';
//            if (board[pair.x][pair.y] != '.') {
//                start = board[pair.x][pair.y] + 1;
//            }
//
//            boolean hasvalid = false;
//            for (int i = start; i <= '9'; i++) {
//                if (isAvaNum(board, pair.x, pair.y, i)) {
//                    board[pair.x][pair.y] = (char) i;
//                    index++;
//                    hasvalid = true;
//                    break;
//                }
//            }
//
//            if (!hasvalid) {
//                board[pair.x][pair.y] = '.';
//                index--;
//            }
//        }
//    }
//
//    private static boolean isAvaNum(char[][] board, int x, int y, int num) {
//
//        //row
//        for (int i = 0; i < 9; i++) {
//            if (y == i) {
//                continue;
//            }
//            if (num == board[x][i]) {
//                return false;
//            }
//        }
//
//        //column
//        for (int i = 0; i < 9; i++) {
//            if (x == i) {
//                continue;
//            }
//            if (num == board[i][y]) {
//                return false;
//            }
//        }
//
//        int x0 = (x / 3) * 3;
//        int y0 = (y / 3) * 3;
//        //square
//        for (int i = 0; i < 9; i++) {
//            int xx = x0 + i / 3;
//            int yy = y0 + i % 3;
//            if (xx == x & yy == y) {
//                continue;
//            }
//            if (board[xx][yy] == num) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
//        P37 p37 = new P37();
//        char[][] input = new char[][]{
//            new char[]{'5','3','.','.','7','.','.','.','.'},
//            new char[]{'6','.','.','1','9','5','.','.','.'},
//            new char[]{'.','9','8','.','.','.','.','6','.'},
//            new char[]{'8','.','.','.','6','.','.','.','3'},
//            new char[]{'4','.','.','8','.','3','.','.','1'},
//            new char[]{'7','.','.','.','2','.','.','.','6'},
//            new char[]{'.','6','.','.','.','.','2','8','.'},
//            new char[]{'.','.','.','4','1','9','.','.','5'},
//            new char[]{'.','.','.','.','8','.','.','7','9'}
//        };
////        p37.solveSudoku(input);
//        Arrays.stream(input).forEach(x -> System.out.println(Arrays.toString(x)));
//        System.out.println(new P36().isValidSudoku(input));
    }

}

//[['5','3','.','.','7','.','.','.','.'],['6','.','.','1','9','5','.','.','.'],['.','9','8','.','.','.','.','6','.'],['8','.','.','.','6','.','.','.','3'],['4','.','.','8','.','3','.','.','1'],['7','.','.','.','2','.','.','.','6'],['.','6','.','.','.','.','2','8','.'],['.','.','.','4','1','9','.','.','5'],['.','.','.','.','8','.','.','7','9']]

