package NiukeTOP101;

public class BM84 {
    public String longestCommonPrefix (String[] strs) {
        if(strs.length == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int minLength = 5010;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length() < minLength){
                minLength = strs[i].length();
            }
        }
        boolean flag = true;
        for (int i = 0; i < minLength && flag; i++) {
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != strs[0].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if (flag)
                sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
