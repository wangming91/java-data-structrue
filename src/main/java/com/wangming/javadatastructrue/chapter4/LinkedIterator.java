package com.wangming.javadatastructrue.chapter4;

import java.util.Iterator;

/**
 * @Author: ming.wang
 * @Date: 2019/7/15 10:05
 * @Description:
 */
public class LinkedIterator<T> implements Iterator<T> {

    private int count;
    private LinearNode<T> current;

    public LinkedIterator(int count, LinearNode<T> current) {
        this.count = count;
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new RuntimeException("没有下一个元素了");

        T result=current.getElement();
        current=current.getNext();

        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
