package NiukeTOP101;

import java.util.HashMap;
import java.util.Map;

public class BM100 {
    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;
    private int used;
    // 设置双向链表结构
    static class Node{
        int key;
        int val;
        Node pre;
        Node next;
        // 初始化
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    public BM100(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.used = 0;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    // 把 key 对应的结点移到链表头部
    private void makeRecently(int key) {
        Node t = map.get(key);
        if(t != head){
            if(t == tail){
                tail = tail.pre;
                tail.next = null;
            }else{
                t.pre.next = t.next;
                t.next.pre = t.pre;
            }
            t.pre = null;
            t.next = head;
            head.pre = t;
            head = t;
        }
    }

    public void set(int key, int value) {
        // 如果 key 已存在，直接修改值，再移到链表头部
        if(map.containsKey(key)){
            map.get(key).val = value;
            makeRecently(key);
            return;
        }
        // 如果达到容量上限，就要移除尾部结点，注意HashMap要remove
        if(used == capacity){
            map.remove(tail.key);
            tail = tail.pre;
            tail.next = null;
            used--;
        }
        // 头结点为空，单独处理
        if(head == null){
            head = new Node(key, value);
            tail = head;
        }else{
            Node t = new Node(key, value);
            t.next = head;
            head.pre = t;
            head = t;
        }
        map.put(key, head);
        used++;
    }
}
