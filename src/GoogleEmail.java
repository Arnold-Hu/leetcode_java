import java.util.HashMap;

public class GoogleEmail {
    public int solution(String[] emails) {
        // write your code in Java SE 8
        HashMap<String, Integer> hs = new HashMap<>();
        for(String email: emails){
            StringBuilder sb = new StringBuilder();
            int at_index = email.indexOf("@");
            int plus_index = email.indexOf("+");
            if(plus_index == -1){
                sb.append(email.substring(0,at_index).replace(".", ""));
            }else{
                sb.append(email.substring(0,plus_index).replace(".", ""));
            }
            sb.append(email.substring(at_index));
            String s = sb.toString();
            hs.put(s,hs.getOrDefault(s,0)+1);
//            hs.add(sb.toString());
        }
        int max = 0;
        //String maxs = "";
        for(String key: hs.keySet()){
            if(hs.get(key) > max){
                max = hs.get(key);
                //maxs = key;
            }
        }
        return max;
    }
}
