package leetcodeContest;

import com.sun.tools.doclets.formats.html.HelpWriter;

public class T1 {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] dot1 = coordinates[0];
        int[] dot2 = coordinates[1];

        if (dot1[0] == dot2[0]) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != dot1[0]) {
                    return false;
                }
            }
            return true;
        } else if (dot1[1] == dot2[1]) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][1] != dot1[1]) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 2; i < coordinates.length; i++) {
                int xdiff = dot2[0] - dot1[0];
                int ydiff = dot2[1] - dot1[1];
                int[] next = coordinates[i];
                if (xdiff * (next[1] - dot1[1]) != ydiff * (next[0] - dot1[0])) {
                    return false;
                }
            }
            return true;
        }
    }

}
