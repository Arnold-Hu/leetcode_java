//Given a time (in 24-hour format) with missing digits marked as '?',
// we want to replace all of the question marks by digits (0-9) in such a
// way as to obtain the latest possible time. The earliest possible time
// is 00:00 and the latest valid time is 23:59.
//        Write a function:
//class Solution { public String solution(String T); }
//that, given a string T, returns the latest valid time that
// can be obtained from T, as a string in the format "HH:MM",
// where HH denotes a two-digit value for hours and MM denotes a two-digit value for minutes.
//        Examples:
//        1. Given T = "2?:?8", the function should return "23:58".
//        2. Given T = "?8:4?", the function should return "18:49".
//        3. Given T = "??:??", the function should return "23:59".
//        4. Given T = "06:34", the function should return "06:34".
//        Assume that
//        T consists of exactly five characters; the third one is ':'; the others are digits (0-9) or '?';
//        there always exists a valid time obtained by substituting '?' with digits.
//
//        In your solution, focus on correctness.
//        The performance of your solution will not be the focus of the assessment

public class GoogleTime {
    public String maxTime(String T) {
        char[] chars = T.toCharArray();
        char[] max = new char[chars.length];
        // hour
        if (chars[0] != '?' && chars[1] != '?') {
            max[0] = chars[0];
            max[1] = chars[1];
        } else if (chars[0] == '?' && chars[1] == '?') {
            max[0] = '2';
            max[1] = '3';
        } else if (chars[0] == '?') {
            max[1] = chars[1];
            if (chars[1] <= '3') {
                max[0] = '2';
            } else {
                max[0] = '1';
            }
        } else {
            max[0] = chars[0];
            if (chars[0] <= '1') {
                max[1] = '9';
            } else {
                max[1] = '3';
            }
        }
        // min
        if (chars[3] != '?' && chars[4] != '?') {
            max[3] = chars[3];
            max[4] = chars[4];
        } else if (chars[3] == '?' && chars[4] == '?') {
            max[3] = '5';
            max[4] = '9';
        } else if (chars[3] == '?') {
            max[4] = chars[4];
            max[3] = '5';
        } else {
            max[3] = chars[3];
            max[4] = '9';
        }
        max[2] = ':';

        return new String(max);
    }

    public static void main(String[] args) {
        GoogleTime googleTime = new GoogleTime();
        System.out.println(googleTime.maxTime("?4:5?"));
        System.out.println(googleTime.maxTime("23:5?"));
        System.out.println(googleTime.maxTime("2?:22"));
        System.out.println(googleTime.maxTime("0?:??"));
        System.out.println(googleTime.maxTime("?8:4?"));
        System.out.println(googleTime.maxTime("06:34"));
        System.out.println(googleTime.maxTime("2?:?8"));
        System.out.println(googleTime.maxTime("?3:?0"));
    }
}
