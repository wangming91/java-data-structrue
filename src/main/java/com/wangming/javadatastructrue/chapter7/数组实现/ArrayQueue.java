package com.wangming.javadatastructrue.chapter7.数组实现;

import com.wangming.javadatastructrue.chapter7.QueueADT;

/**
 * @Author: ming.wang
 * @Date: 2019/7/16 14:22
 * @Description:
 */
public class ArrayQueue<T> implements QueueADT<T> {

    private T[] contents;
    private int count;
    private final int DEFAULT_CAPACITY = 100;

    public ArrayQueue() {
        count = 0;
        contents = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void enqueue(T element) {
        if (size() == contents.length)
            expandCapacity();
        contents[count] = element;
        count++;
    }

    private void expandCapacity() {
        T[] larger = (T[]) new Object[contents.length * 2];
        for (int i = 0; i < contents.length; i++) {
            larger[i] = contents[i];
        }
        contents = larger;
    }

    @Override
    public T dequeue() {
        T result = null;


        return result;
    }

    @Override
    public T first() {
        if (!isEmpty())
            return contents[0];
        return null;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
