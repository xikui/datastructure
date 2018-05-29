package com.hnxljd.queue.impl;

import com.hnxljd.queue.Queue;

public class ArrayQueue<E> implements Queue<E>{

    private Object[] queue;
    private int size;

    public ArrayQueue(){
        queue = new Object[10];
    }

    private void ensureCapacity(int size) {
        if (size > queue.length) {
            int len = queue.length + 10;
            Object [] temp = queue;
            queue = new Object[size+10];

            System.arraycopy(temp,0,queue,0,len-10);
        }
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E pop() {
        if (isEmpty())
            return null;
        E e = (E) queue[0];
        System.arraycopy(queue, 1, queue, 0, size-1);
        size--;
        return e;
    }

    @Override
    public int push(E e) {
        ensureCapacity(size+1);
        queue[size++] = e;
        return size;
    }

    @Override
    public int size() {
        return size;
    }
}
