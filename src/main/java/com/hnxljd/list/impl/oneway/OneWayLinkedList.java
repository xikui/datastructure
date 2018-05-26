package com.hnxljd.list.impl.oneway;

import com.hnxljd.list.List;

/**
 * @author : hnxljd
 * @date : Created in 22:12 2018/5/26
 */
public class OneWayLinkedList<E> implements List<E> {

    private int size = 0;

    /**
     * 头结点
     */
    private Node<E> firstNode;

    /**
     * 尾结点
     */
    private Node<E> lastNode;

    @Override
    public final int size() {
        return size;
    }

    @Override
    public final int add(E e) {

        Node<E> eNode = new Node<>(e);
        if (firstNode == null) {
            firstNode = eNode;
            lastNode = firstNode;
        }
        lastNode.setNext(eNode);
        lastNode = eNode;
        return size++;
    }

    @Override
    public final E remove(final int index) {
        Node<E> eNode = getNode(index);

        E oldObj = eNode.obj;
        Node<E> next = eNode.next;
        eNode.obj = next.obj;
        eNode.next = next.next;
        --size;
        return oldObj;
    }

    @Override
    public final E replace(int index, E e) {
        Node<E> node = getNode(index);
        E obj = node.obj;
        node.obj = e;
        return obj;
    }

    @Override
    public final E get(final int index) {
        return getNode(index).obj;
    }

    private Node<E> getNode(final int index) {
        indexOutOfBounds(index);
        int i = 0;
        Node<E> eNode = firstNode;
        do {
            if (i == index) {
                return eNode;
            } else {
                eNode = eNode.next;
                i++;
            }
        } while (true);
    }

    private void indexOutOfBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
