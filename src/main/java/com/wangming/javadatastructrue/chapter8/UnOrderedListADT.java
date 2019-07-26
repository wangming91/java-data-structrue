package com.wangming.javadatastructrue.chapter8;

public interface UnOrderedListADT<T> extends ListADT<T> {

    void addToFront(T element);

    void addToRear(T element);

    void addAfter(T element, T target);

}
