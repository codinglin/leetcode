package HOT100;

import java.util.*;

public class Main20 {
    public boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<c.length; i++){
            if(c[i]=='(' || c[i]=='{' || c[i]=='['){
                stack.push(c[i]);
            }else if(stack.isEmpty()||(c[i]==')'&&stack.pop()!='(')||(c[i]==']'&&stack.pop()!='[')||(c[i]=='}'&&stack.pop()!='{')){
                return false;
            }
        }
        return stack.isEmpty();
    }
}

class Main20_1{
    public boolean isValid(String s){
        int n = s.length();
        if(n % 2==1){
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(pairs.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != pairs.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}