package com.wangming.javadatastructrue;

import com.wangming.javadatastructrue.chapter3.ArraySet;

import java.util.Iterator;

public interface SetADT<T> {

    int size();

    boolean isEmpty();

    void add(T element);

    void addAll(SetADT<T> target);

    Iterator<T> iterator();

    T removeRandom() throws Exception;

    T remove(T target) throws Exception;

    SetADT<T> union(SetADT<T> target);

    boolean contains(T target);

    boolean equals(SetADT<T> target)throws Exception;


}
