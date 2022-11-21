package NiukeTOP101;

import java.util.Stack;

public class BM44 {
    public boolean isValid (String s) {
        char[] c = s.toCharArray();
        if(c.length == 0){
            return true;
        }
        if(c.length % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if(c[i] == '(' || c[i] == '[' || c[i] == '{'){
                stack.push(c[i]);
            }else{
                if(stack.size() == 0){
                    return false;
                }
                char ch = stack.peek();
                if(ch == '(' && c[i] != ')'){
                    return false;
                }
                else if(ch == '[' && c[i] != ']'){
                    return false;
                }
                else if(ch == '{' && c[i] != '}'){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public boolean isValid1 (String s) {
        //辅助栈
        Stack<Character> st = new Stack<Character>();
        //遍历字符串
        for(int i = 0; i < s.length(); i++){
            //遇到左小括号
            if(s.charAt(i) == '(')
                //期待遇到右小括号
                st.push(')');
                //遇到左中括号
            else if(s.charAt(i) == '[')
                //期待遇到右中括号
                st.push(']');
                //遇到左打括号
            else if(s.charAt(i) == '{')
                //期待遇到右打括号
                st.push('}');
                //必须有左括号的情况下才能遇到右括号
            else if(st.isEmpty() || st.pop() != s.charAt(i))
                return false;
        }
        //栈中是否还有元素
        return st.isEmpty();
    }
}
