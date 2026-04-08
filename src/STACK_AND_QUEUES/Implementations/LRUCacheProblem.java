package STACK_AND_QUEUES.Implementations;

import java.util.HashMap;

public class LRUCacheProblem {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int _key, int _val){
            key = _key;
            val = _val;
        }
    }
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    int cap;

    HashMap<Integer, Node> m = new HashMap<>();

    public LRUCacheProblem(int capacity){
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    void deleteNode(Node delNode){
        Node delPrev = delNode.prev;
        Node delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }

    public int get(int key_){
        if(m.containsKey(key_)){
            Node resNode = m.get(key_);
            int res = resNode.val;
            m.remove(key_);
            deleteNode(resNode);
            addNode(resNode);
            m.put(key_, head.next);
            return res;
        }
        return -1;
    }

    public void put(int key_, int value){
        if(m.containsKey(key_)){
            Node existingNode = m.get(key_);
            m.remove(key_);
            deleteNode(existingNode);
        }
        if(m.size() == cap){
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key_, value));
        m.put(key_, head.next);
    }
}