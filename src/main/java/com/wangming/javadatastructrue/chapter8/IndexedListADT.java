package com.wangming.javadatastructrue.chapter8;

public interface IndexedListADT<T> extends ListADT<T> {

    void add(int index, T element);

    //    将元素添加到list尾部
    void add(T element);

    void set(int index, T element);

    T get(int index);

    int indexOf(T target);

    T remove(int index);

}
