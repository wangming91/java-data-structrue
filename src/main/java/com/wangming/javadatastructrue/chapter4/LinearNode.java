package com.wangming.javadatastructrue.chapter4;

/**
 * @Author: ming.wang
 * @Date: 2019/7/11 15:31
 * @Description:
 */
public class LinearNode<T> {
    private LinearNode<T> next;

    private T element;

    public LinearNode() {
        next=null;
        element=null;
    }

    public LinearNode(T element) {
        next=null;
        this.element = element;
    }

    public LinearNode<T> getNext() {
        return next;
    }

    public void setNext(LinearNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
