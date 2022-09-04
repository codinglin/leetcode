package problems;

import java.util.HashMap;

public class LeetCode146 {

    private HashMap<Integer, Node> map;

    private DoubleList cache;

    private int cap;

    public LeetCode146(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        // 利用put方法把该数据提前
        put(key,val);
        return val;
    }

    public void put(int key, int value) {
        // 先把新结点x做出来
        Node x = new Node(key, value);
        if(map.containsKey(key)){
            // 删除旧的结点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新map中对应的数据
            map.put(key, x);
        }else{
            if(cap == cache.size()){
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}

class Node{
    public int key, val;
    public Node next, prev;
    public Node(int k, int v){
        this.key = k;
        this.val = v;
    }
}

class DoubleList{
    private Node head, tail;
    private int size;

    // 在链表头部添加结点x，时间O(1)
    public void addFirst(Node node){
        if(head==null){
            head=tail=node;
        }else{
            Node n = head;
            n.prev = node;
            node.next = n;
            head = node;
        }
        size++;
    }

    // 删除链表中的x结点（x一定存在）
    // 由于是双链表且给的是目标Node
    public void remove(Node node){
        if(head==node && tail==node){
            head=null;
            tail=null;
        }else if(tail==node){
            node.prev.next=null;
            tail=node.prev;
        }else if(head==node){
            node.next.prev=null;
            head=node.next;
        }else {
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        size--;
    }

    // 删除链表中最后一个结点，并返回该结点
    public Node removeLast(){
        Node node = tail;
        remove(tail);
        return node;
    }

    // 返回链表长度
    public int size(){
        return size;
    }

}
