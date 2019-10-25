public class P67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int off = 0;
        for (int i=0; i < Math.max(a.length(), b.length()); i++) {
            int aa = i >= a.length() ? 0 : a.charAt(a.length() - 1 - i) - '0';
            int bb = i >= b.length() ? 0 : b.charAt(b.length() - 1 - i) - '0';
            if (aa + bb + off >= 2) {
                off = 1;
                sb.append(aa + bb + off - 2);
            } else {
                sb.append(aa + bb + off);
                off = 0;

            }
        }
        if (off > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
