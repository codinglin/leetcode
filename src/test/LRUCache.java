package test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Node> map;

    private DoubleList cache;

    private Integer capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).value;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key, node);
        } else {
            if (capacity == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(node);
            map.put(key, node);
        }
    }
}

class Node {
    public int key, value;

    public Node pre, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleList {
    private Node head, tail;

    private int size;

    // 在链表头部添加结点x，时间O(1)
    public void addFirst(Node node){
        if (head == null) {
            head = tail = node;
        } else {
            Node n = head;
            n.pre = node;
            node.next = n;
            head = node;
        }
        size ++;
    }

    // 删除链表中的x结点（x一定存在）
    // 由于是双链表且给的是目标Node
    public void remove(Node node){
        if(head == node && tail == node) {
            head = tail = null;
        } else if(head == node) {
            node.next.pre = null;
            head = node.next;
        } else if(tail == node) {
            tail.pre.next = null;
            tail = node.pre;
        } else {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }
        size --;
    }

    // 删除链表中最后一个结点，并返回该结点
    public Node removeLast(){
        Node node = tail;
        remove(tail);
        return node;
    }

    // 返回链表长度
    public int size() {
        return size;
    }
}