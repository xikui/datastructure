package com.hnxljd.queue;

public interface Queue<E> {

    E pop();
    int push(E e);
    int size();
    boolean isEmpty();

}
