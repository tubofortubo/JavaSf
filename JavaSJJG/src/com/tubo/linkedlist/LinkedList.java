package com.tubo.linkedlist;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新的元素
     *
     * @param e
     */
    public void addFirst(E e) {
//        Node node=new Node(e);
//        node.next=head;
//        head=node;
        add(0, e);
    }

    /**
     * 在链表中间添加一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("ADD filed,Index Illegal");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }


    /**
     * 在链表末尾添加一个元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取第i个元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed,index Illegal");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed,Illegal index");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找;链表中是否有这个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
        }
        return false;
    }

    /**
     * 删除链表第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表的最后删除一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prve = dummyHead;
        while (prve.next != null) {
            if (prve.next.e.equals(e))
                break;
            prve = prve.next;
        }
        if (prve.next!=null){
            Node delNode=prve.next;
            prve.next=delNode.next;
            delNode.next=null;
        }
    }

    /**
     * 从链表中删除第index个元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed,Index is illegal");
        Node prve = dummyHead;
        for (int i = 0; i < index; i++) {
            prve = prve.next;
        }
        Node retNode = prve.next;
        prve.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
//        Node cur=dummyHead.next;
//        while (cur!=null){
//            res.append(cur+"->");
//            cur=cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("null");
        return res.toString();
    }
}
