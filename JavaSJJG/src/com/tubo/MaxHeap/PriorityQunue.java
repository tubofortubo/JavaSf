package com.tubo.MaxHeap;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tubo.quene.Queue;

public class PriorityQunue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQunue() {
        this.maxHeap = new MaxHeap<>();
    }

    @Override
    public void enquene(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequene() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
