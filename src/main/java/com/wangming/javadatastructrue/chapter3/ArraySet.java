package com.wangming.javadatastructrue.chapter3;

import java.util.Random;

/**
 * @Author: ming.wang
 * @Date: 2019/7/10 16:36
 * @Description:
 */
public class ArraySet<T> {

    private static Random random = new Random();

    //数组默认大小
    private final int DEFAULT_CAPACITY = 100;
    //未找到标志
    private final int NOT_FOUND = -1;

    //
    private int count;
    private T[] contents;

    public ArraySet() {
        this.count = 0;
        this.contents = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArraySet(int initcapacity) {
        this.count = 0;
        this.contents = (T[]) new Object[initcapacity];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(T element) {

        if (contains(element))
            return;

        if (size() == contents.length)
            //自动扩容
            expandCapacity();

        contents[count] = element;
        count++;

    }

    private void expandCapacity() {

    }


    public boolean contains(T target) {
        int search = NOT_FOUND;
        for (int i = 0; i < count && search == NOT_FOUND; i++) {
            if (contents[i].equals(target)) {
                search = i;
            }
        }
        return search != NOT_FOUND;
    }
}

