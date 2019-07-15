package com.wangming.javadatastructrue.chapter6;

/**
 * @Author: ming.wang
 * @Date: 2019/7/15 17:28
 * @Description:
 */
public interface StackADT<T> {
    //向堆栈顶部添加一个元素
    public void push(T element);

    //从堆栈顶部删除元素并将其返回
    public T pop();

    //从堆栈顶部返回元素并不将其删除
    public T peek();

    public boolean isEmpty();

    public int size();

    public String toString();
}
