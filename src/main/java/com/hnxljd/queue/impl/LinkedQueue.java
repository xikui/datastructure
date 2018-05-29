package com.hnxljd.queue.impl;

import com.hnxljd.queue.Queue;

public class LinkedQueue<E> implements Queue<E> {
    class Node<E> {
        Node<E> next = null;
        E data;
        public Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E pop() {
        if (isEmpty())
            return null;
        E e = head.data;
        head = head.next;
        size--;
        return e;
    }

    @Override
    public int push(E e) {
        Node<E> node = new Node<>(e);
        if (isEmpty()){
            head = node;
            tail = node;
            return ++size;
        }
        tail.next=node;
        tail = node;
        return ++size;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
       Queue<String> queue = new LinkedQueue<>();
        System.out.println(queue.push("a"));
        System.out.println(queue.push("b"));
        System.out.println(queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.size());
    }
}
