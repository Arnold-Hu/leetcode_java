public class P151 {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        if (s.length() == 0) {
            return s;
        }
        char[] ss = s.toCharArray();


        int head = 0;
        char last = ' ';
        for (int i = 0; i<ss.length ; i++) {
            if (ss[i] != ' ') {
                ss[head] = ss[i];
                head++;
            } else if (last != ' '){
                ss[head] = ss[i];
                head++;
            }
            last = ss[i];
        }

        if (head == 0) {
            return "";
        }

        if (ss[head-1] == ' '){
            head--;
        }

        for (int u=head;u<ss.length;u++) {
            ss[u] = ' ';
        }


        for (int index = 0; index < head; index++) {
            char temp;
            if ((index == 0 && ss[index] != ' ') || (index > 0 && ss[index] != ' ' && ss[index-1] == ' ')) {
                int nhead = index;
                int tail = index;
                while (tail != head-1 && ss[tail+1] != ' ') {
                    tail++;
                }
                while (nhead < tail) {
                    temp = ss[nhead];
                    ss[nhead] = ss[tail];
                    ss[tail] = temp;
                    nhead++;
                    tail--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = head -1; i>=0; i--) {
            sb.append(ss[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        P151 p151 = new P151();
        System.out.println(p151.reverseWords("  "));
    }
}
