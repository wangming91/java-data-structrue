package com.wangming.javadatastructrue.chapter6.链接实现;

import com.wangming.javadatastructrue.chapter4.LinearNode;
import com.wangming.javadatastructrue.chapter6.StackADT;

/**
 * @Author: ming.wang
 * @Date: 2019/7/15 17:37
 * @Description:
 */
public class LinkedStack<T> implements StackADT<T> {

    LinearNode<T> top;
    private int count;

    public LinkedStack() {
        top = null;
        count = 0;
    }

    @Override
    public void push(T element) {

        LinearNode<T> temp = new LinearNode<>(element);
        temp.setNext(top);
        top = temp;
        count++;

    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new RuntimeException("空集合，不能pop操作");
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("空集合，不能pop操作");
        T result = top.getElement();
        return result;
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
