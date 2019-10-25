package leetcodeContest;

import java.util.Arrays;

public class T3 {
    public int balancedString(String s) {
        int[] mark = new int[4];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            mark[change(c)]++;
        }
        System.out.println(Arrays.toString(mark));

        int balance = s.length() / 4;
        // slide need these letters;
        int sum = 0;
        for (int i = 0 ; i < mark.length; i++) {
            if (mark[i] > balance) {
                mark[i] = mark[i] - balance;
            } else {
                mark[i] = 0;
            }
            sum += mark[i];
        }
        System.out.println(Arrays.toString(mark));

        if (sum == 0) {
            return 0;
        }

        int[] newMark = new int[4];
        int windowLeft = 0;
        newMark[change(chars[0])]++;
        int windowRight = findRight(chars, 0, newMark, mark);


        int minLength = Integer.MAX_VALUE;

        while (windowRight >= 0) {
            System.out.println("left " + windowLeft);
            System.out.println("right " + windowRight);
            System.out.println(s.substring(windowLeft, windowRight+1));
            int l = windowRight - windowLeft + 1;
            if (l < minLength) {
                minLength = l;
            }

            // leftBound move right
            newMark[change(chars[windowLeft])]--;
            windowLeft++;
            windowRight = findRight(chars, windowRight, newMark, mark);
        }
        return minLength;
    }

    private int findRight(char[] chars, int right, int[] now, int[] target) {
        while (right < chars.length) {
            System.out.println(Arrays.toString(now));
//            System.out.println(Arrays.toString(target));
//            System.out.println("right now " + right);
//            System.out.println("=====");
            if (isFit(now, target)) {
                return right;
            } else {
                right++;
                if (right < chars.length) {
                    now[change(chars[right])]++;
                }
            }
        }
        return -1;
    }

    private boolean isFit(int[] now, int[] target) {
        for (int i = 0; i < 4; i++) {
            if (now[i] < target[i]) {
                return false;
            }
        }
        return true;
    }

    private int change(char c) {
        if (c == 'Q') {
            return 0;
        } else if (c == 'W') {
            return 1;
        } else if (c == 'E') {
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        T3 t3 = new T3();
        System.out.println(t3.balancedString("WWWEQRQEWWQQQWQQQWEWEEWRRRRRWWQE"));
    }
}
