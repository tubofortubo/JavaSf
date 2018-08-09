package com.tubo.quene;

import com.tubo.array.Array;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue() {
        this.array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public void enquene(E e) {
        array.addLast(e);
    }

    @Override
    public E dequene() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append("Qunue: front[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i!=array.getSize()-1)
                res.append(",");
        }
        res.append("] tail");
        return res.toString();

    }
   public static void main(String[] args){
       ArrayQueue< Integer> qunue=new ArrayQueue<>();
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
