package com.tubo.quene;

public interface Queue<E> {

    void enquene(E e);
    E dequene();
    E getFront();
    int getSize();
    boolean isEmpty();
}
