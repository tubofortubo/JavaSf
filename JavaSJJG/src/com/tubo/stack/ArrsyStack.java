package com.tubo.stack;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.tubo.array.Array;

public class ArrsyStack<E> implements  Stack<E> {

    Array<E> array;
    public ArrsyStack(int capacity) {
        array=new Array<>(capacity);
    }
    public ArrsyStack() {
        array=new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }


    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Stack:[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i!=array.getSize()-1)
                res.append(",");
        }
        res.append("] top");
        return res.toString();
    }
}
