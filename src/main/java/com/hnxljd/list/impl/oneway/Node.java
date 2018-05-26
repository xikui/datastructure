package com.hnxljd.list.impl.oneway;


import com.hnxljd.util.Iterator;
import lombok.Data;

/**
 * 链表结点，当前对象，和指向后一个结点
 *
 * @author : hnxljd
 * @date : Created in 22:04 2018/5/26
 */
@Data
class Node<E> implements Iterator<Node<E>> {
    E obj;

    Node<E> next;

    Node(E e) {
        this.obj = e;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Node<E> next() {
        return next;
    }
}
