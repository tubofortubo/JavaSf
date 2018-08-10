package com.tubo.MaxHeap;

import com.tubo.array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MaxHeap() {
        this.data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        this.data = new Array<>(arr);
        for (int i = parent(arr.length-1); i >=0 ; i--) {
            siftDown(i);
        }
    }

    //返回堆中元素的个数
    public int size() {

        return data.getSize();
    }

    //返回一个布尔值,表死堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的一个索引表示元素的父亲节点
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1) / 2;
    }

    //返回完全二叉树的一个索引表示元素的左孩子节点
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的一个索引表示元素的右孩子节点
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k)<data.getSize()){
            int j=leftChild(k);
            if (j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0)
                j=rightChild(k);
            if (data.get(k).compareTo(data.get(j))>=0)
                break;
            data.swap(k,j);
            k=j;
        }
    }

    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("can not findMx when heap is empty");
        return data.get(0);
    }

    public E replace(E e){
        E ret=findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }
}
