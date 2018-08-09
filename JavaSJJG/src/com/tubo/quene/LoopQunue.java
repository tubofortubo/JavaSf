package com.tubo.quene;

public class LoopQunue<E> implements  Queue<E> {

    private  E[] data;
    private  int front,tail;
    private  int size;

    public LoopQunue(int capacity) {
        this.data = (E[])new Object[capacity+1];
        front=0;
        tail=0;
        size=0;
    }
    public LoopQunue() {
        this(10);
    }
    public  int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enquene(E e) {
        if ((tail+1)%data.length==front)
            resize(getCapacity()*2);
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }

    @Override
    public E dequene() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequene from an empty qunue");
        E res=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if (size==getCapacity()/4&&getCapacity()/2!=0)
            resize(getCapacity()/2);
        return  res;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Qunue is empty");
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i]=data[(front+i)%data.length];
        }
        data=newData;
        front=0;
        tail=size;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("Qunue: size=%d ,capacity=%d\n front[",size,getCapacity()));
        for (int i = front; i < size; i=(i+1)%data.length) {
            res.append(data[i]);
            if ((i+1)%data.length!=tail)
                res.append(",");
        }
        res.append("] tail");
        return res.toString();
    }
    public static void main(String[] args){
        LoopQunue< Integer> qunue=new LoopQunue<>();
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
