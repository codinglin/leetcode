package NiukeTOP101;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BM85 {
    public static String solve (String IP) {
        if(IP.indexOf('.') > 0){
            String[] str = IP.split("\\.");
            if(str.length != 4){
                return "Neither";
            }
            String regex=".*[a-zA-Z]+.*";
            Matcher m= Pattern.compile(regex).matcher(IP);
            if(m.matches()){
                return "Neither";
            }
            for (int i = 0; i < str.length; i++) {
                //不可缺省，有一个分割为零，说明两个点相连
                if(str[i].length() == 0) {
                    return "Neither";
                }
                if(str[i].length() > 3 || str[i].charAt(0) == '0' && str[i].length() != 1) {
                    return "Neither";
                }
                int num = 0;
                //遍历每个分割字符串，必须为数字
                for(int j = 0; j < str[i].length(); j++){
                    char c = str[i].charAt(j);
                    if (c < '0' || c > '9')
                        return "Neither";
                    //转化为数字比较，0-255之间
                    num = num * 10 + (int)(c - '0');
                    if(num < 0 || num > 255)
                        return "Neither";
                }
            }
            return "IPv4";
        }
        if(IP.indexOf(':') > 0){
            String[] str = IP.split(":", -1);
            if(str.length != 8){
                return "Neither";
            }
            for (int i = 0; i < str.length; i++) {
                if(str[i].length() == 0 || str[i].length() > 4){
                    return "Neither";
                }
                for(int j = 0; j < str[i].length(); j++){
                    //不能出现a-fA-F以外的大小写字符
                    char c = str[i].charAt(j);
                    boolean expr = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') ;
                    if(!expr){
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        String IP = "1.0.1.";
        solve(IP);
    }
}
