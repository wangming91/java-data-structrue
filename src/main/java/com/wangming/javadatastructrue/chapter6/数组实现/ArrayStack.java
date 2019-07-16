package com.wangming.javadatastructrue.chapter6.数组实现;

import com.wangming.javadatastructrue.chapter6.StackADT;

/**
 * @Author: ming.wang
 * @Date: 2019/7/16 10:51
 * @Description:
 */
public class ArrayStack<T> implements StackADT<T> {

    //数组默认大小
    private final int DEFAULT_CAPACITY = 100;
    T[] contents;
    private int top;

    public ArrayStack() {
        contents = (T[]) new Object[DEFAULT_CAPACITY];
        top = 0;
    }

    @Override
    public void push(T element) {
        if (size() == contents.length)
            expandCapacity();
        contents[top] = element;
        top++;

    }

    private void expandCapacity() {

        T[] larger = (T[]) new Object[contents.length * 2];
        for (int i = 0; i < contents.length; i++) {
            larger[i] = contents[i];
        }
        contents = larger;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new RuntimeException("集合为空，不能执行pop操作！");
        top--;
        T result = contents[top];
        contents[top] = null;
        return result;
    }

    @Override
    public T peek() {
        T result = contents[top - 1];
        return result;
    }

    @Override
    public boolean isEmpty() {
        return 0 == top;
    }

    @Override
    public int size() {
        return top;
    }
}
