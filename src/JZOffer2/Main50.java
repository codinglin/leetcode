package JZOffer2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 使用哈希表存储频数
 */
public class Main50 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}

/**
 * 队列
 */
class Main50_1{
    public char firstUniqChar(String s) {
        Map<Character, Integer> position = new HashMap<>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!position.containsKey(ch)){
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            }else{
                position.put(ch, -1);
                while(!queue.isEmpty() && position.get(queue.peek().ch) == -1){
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? ' ':queue.poll().ch;
    }

    class Pair{
        char ch;
        int pos;

        Pair(char ch, int pos){
            this.ch = ch;
            this.pos = pos;
        }
    }
}