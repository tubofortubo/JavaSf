package com.tubo.linkedlist;

import com.tubo.stack.ArrsyStack;
import com.tubo.stack.LinkedListStack;
import com.tubo.stack.Stack;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        LinkedList<Integer> linkedlist=new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkedlist.addFirst(i);
            System.out.println(linkedlist);
        }
        linkedlist.add(2,666);
        System.out.println(linkedlist);
        linkedlist.remove(2);
        System.out.println(linkedlist);
        linkedlist.removeFirst();
        System.out.println(linkedlist);
        linkedlist.removeLast();
        System.out.println(linkedlist);
        ArrsyStack<Integer> arrsyStack = new ArrsyStack<>();
       System.out.println( testStack(arrsyStack,1000));
        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        System.out.println(testStack(listStack,1000));
    }

    public  static double testStack(Stack<Integer> stack,int opCount){
        
        long startTime=System.nanoTime();
        Random r=new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(r.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        
        long endTime=System.nanoTime();
        return  (endTime-startTime)/1000000000.0;
    }
}
