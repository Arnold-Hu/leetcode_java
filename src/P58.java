public class P58 {
    public int lengthOfLastWord(String s) {

        int lastIndexOfNoNumber = -1;
        if (s.equals("")) {
            return 0;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            } else  {
                lastIndexOfNoNumber = i;
                break;
            }
        }

        if (lastIndexOfNoNumber == -1) {
            return 0;
        }

        if (lastIndexOfNoNumber == 0) {
            return 1;
        }

        int l = 0;
        for (int i = lastIndexOfNoNumber - 1; i>=0; i--) {
            if (s.charAt(i) == ' ') {
                l = lastIndexOfNoNumber - i;
                break;
            }
        }

        if (l == 0) {
            l = lastIndexOfNoNumber + 1;
        }
        return l;
    }
}
