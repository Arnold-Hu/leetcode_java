package leetcodeContest;

import java.util.*;

public class T2 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        Set<String> mark = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (String s : folder) {
            sb.setLength(0);
            String[] pwd = s.split("/");
            boolean isHas = false;
//            System.out.println(mark);
            for (int i = 1; i< pwd.length; i++) {
                sb.append("/");
                sb.append(pwd[i]);
//                System.out.println(sb.toString());
                if (mark.contains(sb.toString())) {
                    isHas = true;

                    break;
                }
            }
            if (isHas) {
                continue;
            } else {
                mark.add(s);
            }
        }
        return new ArrayList<>(mark);
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.removeSubfolders(new String[]{"/a","/a/b/c","/a/b/d"}));
    }


}
