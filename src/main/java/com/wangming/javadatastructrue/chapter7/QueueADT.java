package com.wangming.javadatastructrue.chapter7;

public interface QueueADT<T> {

    //入队
    void enqueue(T element);

    //出队
    T dequeue();


    T first();

    boolean isEmpty();

    int size();

    String toString();
}
