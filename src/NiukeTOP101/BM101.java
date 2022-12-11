package NiukeTOP101;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BM101 {
    // 设置节点结构
    static class Node{
        int freq;
        int key;
        int val;
        public Node(int freq, int key, int val){
            this.freq = freq;
            this.key = key;
            this.val = val;
        }
    }
    // 频率到双向链表的哈希表
    private Map<Integer, LinkedList<Node>> freq_mp = new HashMap<>();
    // key到节点的哈希表
    private Map<Integer, Node> mp = new HashMap<>();
    // 记录缓存剩余容量
    private int size = 0;
    // 记录当前最小频次
    private int min_freq = 0;
    public int[] LFU (int[][] operators, int k) {
        //构建初始化连接
        //链表剩余大小
        this.size = k;
        //获取操作数
        int len = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        //遍历所有操作
        for(int i = 0, j = 0; i < operators.length; i++){
            if(operators[i][0] == 1)
                //set操作
                set(operators[i][1], operators[i][2]);
            else
                //get操作
                res[j++] = get(operators[i][1]);
        }
        return res;
    }

    // 调用函数时更新频率或者val值
    private void update(Node node, int key, int val){
        // 找到频率
        int freq = node.freq;
        // 原频率中删除该节点
        freq_mp.get(freq).remove(node);
        // 哈希表中该频率已无节点，直接删除
        if(freq_mp.get(freq).isEmpty()){
            freq_mp.remove(freq);
            // 若当前频率为最小，最小频率加1
            if(min_freq == freq){
                min_freq ++;
            }
        }
        if (!freq_mp.containsKey(freq + 1)){
            freq_mp.put(freq + 1, new LinkedList<>());
        }
        // 插入频率加一的双向链表表头，链表中对应：freq key value
        freq_mp.get(freq + 1).addFirst(new Node(freq + 1, key, val));
        mp.put(key, freq_mp.get(freq + 1).getFirst());
    }

    // set操作函数
    private void set(int key, int value){
        // 在哈希表中找到key值
        if(mp.containsKey(key)){
            // 若是哈希表中有，则更新值和频率
            update(mp.get(key), key, value);
        }else{
            // 哈希表中没有，即链表中没有
            if(size == 0){
                // 满容量取频率最低且最早的删除
                int oldKey = freq_mp.get(min_freq).getLast().key;
                // 频率哈希表的链表中删除
                freq_mp.get(min_freq).removeLast();
                if(freq_mp.get(min_freq).isEmpty()){
                    freq_mp.remove(min_freq);
                }
                mp.remove(oldKey);
            }else{
                size--;
            }
            // 最小频率置为1
            min_freq = 1;
            // 在频率为一的双向链表表头插入该建
            if(!freq_mp.containsKey(1)){
                freq_mp.put(1, new LinkedList<>());
            }
            freq_mp.get(1).addFirst(new Node(1, key, value));
            // 哈希表key值指向链表中的该位置
            mp.put(key, freq_mp.get(1).getFirst());
        }
    }

    private int get(int key) {
        int res = -1;
        // 查找哈希表
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            // 根据哈希表直接获取值
            res = node.val;
            // 更新频率
            update(node, key, res);
        }
        return res;
    }
}
