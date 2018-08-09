package com.tubo.quene;

import com.tubo.linkedlist.LinkedList;
import sun.dc.pr.PRError;

public class LinkedListQunue<E> implements   Queue<E>{

    private class Node {
        public E e;
        public Node next;

        public Node(E e,Node next) {
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

    private  Node head,tail;
    private  int size;

    public LinkedListQunue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enquene(E e) {
           if (tail==null){
               tail=new Node(e);
               head=tail;
           }else{
               tail.next=new Node(e);
               tail=tail.next;
           }
           size++;
    }

    @Override
    public E dequene() {
        if (isEmpty())
            throw new IllegalArgumentException(" Cannot dequeue from an emoty");
        Node resNode=head;
        head=head.next;
        resNode.next=null;
        if (head==null)
            tail=null;
        size--;
        return resNode.e;
    }

    @Override
    public E getFront() {
          if (isEmpty())
              throw  new IllegalArgumentException("Qunue is empty");
          return  head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Qunue :front");
        Node cur=head;
        while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
    public static void main(String[] args){

        LinkedListQunue< Integer> qunue=new LinkedListQunue<>();
        for (int i = 0; i < 10; i++) {
            qunue.enquene(i);
            System.out.println(qunue);
            if (i%3==2){
                qunue.dequene();
                System.out.println(qunue);
            }
        }
    }
}
