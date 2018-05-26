package com.hnxljd.list;


/**
 * 链表的基本操作
 *
 * @author : hnxljd
 * @date : Created in 22:16 2018/5/26
 */
public interface List<E> {

    int size();

    int add(E e);

    E remove(int index);

    E replace(int index, E e);

    E get(int index);
}
