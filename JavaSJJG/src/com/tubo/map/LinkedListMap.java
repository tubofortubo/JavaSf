package com.tubo.map;

import com.tubo.linkedlist.LinkedList;

import java.util.EmptyStackException;

public class LinkedListMap<K,V> implements Map<K,V> {
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key,null,null);
        }

        public Node() {
            this(null,null, null);
        }

        @Override
        public String toString() {
            return key.toString()+":"+value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node==null){
            dummyHead.next=new Node(key,value,dummyHead.next);
            size++;
        }else{
            node.value=value;
        }


    }

    @Override
    public V remove(K key) {
        Node prve=dummyHead;
        while (prve.next!=null){
            if (prve.next.key.equals(key))
                break;
            prve=prve.next;
        }
        if (prve.next!=null){
            Node delNode=prve.next;
            prve.next=delNode.next;
            delNode.next=null;
            return  delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node==null)
            throw new IllegalArgumentException(key+"doesn't exsit");
        node.value=newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private Node getNode(K key){
        Node cur=dummyHead.next;
        while (cur!=null){
            if (cur.key.equals(key))
                return cur;
            cur=cur.next;
        }
        return null;
    }
}
