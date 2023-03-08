package HOT100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main17 {
    // 数字到号码的映射
    private String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    // 路径
    private StringBuilder sb = new StringBuilder();

    // 结果集
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return res;
        }
        backtrack(digits, 0);
        return res;
    }

    // 回溯函数
    private void backtrack(String digits, int index){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
        }
        String val = map[digits.charAt(index)-'2'];
        for(char ch: val.toCharArray()){
            sb.append(ch);
            backtrack(digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {

    }
}

class Main17_1{
    private List<String> res = new ArrayList<>();

    private StringBuilder sb = new StringBuilder();

    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0) {
            return res;
        }
        backtrack_1(digits, 0);
        return res;
    }

    public void backtrack_1(String digits, int index){
        if(digits.length()==index){
            res.add(sb.toString());
            return;
        }
        for(int i=0; i<phoneMap.get(digits.charAt(index)).length(); i++){
            sb.append(phoneMap.get(digits.charAt(index)).charAt(i));
            backtrack_1(digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

class Main17_2 {
    private String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private StringBuilder sb = new StringBuilder();

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0);
        return res;
    }
    
    private void backtrack(String digits, int index) {
        if(index == digits.length()) {
            res.add(String.valueOf(sb));
            return;
        }
        for (int i = 0; i < map[digits.charAt(index)-'2'].length(); i++) {
            sb.append(map[digits.charAt(index)-'2'].charAt(i));
            backtrack(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
