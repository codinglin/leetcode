package HOT100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


// 待调整
public class Main394 {
    public static String decodeString(String s) {
        StringBuffer ans=new StringBuffer();
        LinkedList<Integer> multiStack=new LinkedList<>();
        LinkedList<StringBuffer> ansStack=new LinkedList<>();
        int multi=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c))multi=multi*10+c-'0';
            else if(c=='['){
                ansStack.add(ans);
                multiStack.add(multi);
                ans=new StringBuffer();
                multi=0;
            }else if(Character.isAlphabetic(c)){
                ans.append(c);
            }else{
                StringBuffer ansTmp=ansStack.pop();
                int tmp=multiStack.pop();
                for(int i=0;i<tmp;i++)ansTmp.append(ans);
                ans=ansTmp;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}

class Main394_1{
    public String decodeString(String s){
        LinkedList<Character> stack = new LinkedList<>();
        for(char c: s.toCharArray()){
            if(c != ']'){
                stack.push(c); // 把所有字母push进去，除了]
            }else{
                // step 1: 取出[]内的字符串
                StringBuffer sb = new StringBuffer();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())){
                    sb.insert(0, stack.pop());
                }
                String sub = sb.toString();
                stack.pop(); // 去除[

                // step 2: 获取倍数数字
                sb = new StringBuffer();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb.insert(0, stack.pop());
                }
                int count = Integer.valueOf(sb.toString());

                // step 3: 根据倍数把字母再push回去
                while (count>0){
                    for(char ch: sub.toCharArray()){
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }
        StringBuilder retv = new StringBuilder();
        while (!stack.isEmpty())
            retv.insert(0, stack.pop());
        return retv.toString();
    }
}
