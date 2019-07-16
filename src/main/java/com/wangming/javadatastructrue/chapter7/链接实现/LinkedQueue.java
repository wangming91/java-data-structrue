package com.wangming.javadatastructrue.chapter7.链接实现;

import com.wangming.javadatastructrue.chapter4.LinearNode;
import com.wangming.javadatastructrue.chapter7.QueueADT;

/**
 * @Author: ming.wang
 * @Date: 2019/7/16 14:10
 * @Description:
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private LinearNode<T> front, rear;
    private int count;

    public LinkedQueue() {
        front = null;
        rear = null;
        count = 0;
    }


    @Override
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<>(element);

        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }

        rear = node;
        count++;

    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new RuntimeException("队列为空，不能执行出队操作");

        T result = front.getElement();
        front = front.getNext();

        count--;
        if (isEmpty())
            rear = null;

        return result;
    }

    @Override
    public T first() {
        return front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return 0 == count;
    }

    @Override
    public int size() {
        return count;
    }
}
