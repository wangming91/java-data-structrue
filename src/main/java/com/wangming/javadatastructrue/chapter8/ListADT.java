package com.wangming.javadatastructrue.chapter8;

import java.util.Iterator;

public interface ListADT<T> {

    T removeFirst();

    T removeLast();

    T remove(T element);

    T first();

    T last();

    boolean contains(T target);

    int size();

    Iterator<T> iterator();

    String toString();


}
