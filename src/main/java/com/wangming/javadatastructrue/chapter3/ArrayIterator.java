package com.wangming.javadatastructrue.chapter3;

import java.util.Iterator;

/**
 * @Author: ming.wang
 * @Date: 2019/7/11 14:35
 * @Description:
 */
public class ArrayIterator<T> implements Iterator<T> {

    private int count;
    private int current;
    private T[] items;

    public ArrayIterator(int count, T[] items) {
        this.count = count;
        this.current = 0;
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return current < count;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new RuntimeException("no such element!");

        current++;
        return items[current - 1];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
