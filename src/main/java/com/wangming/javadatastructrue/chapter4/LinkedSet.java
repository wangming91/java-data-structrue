package com.wangming.javadatastructrue.chapter4;

import com.wangming.javadatastructrue.SetADT;

import java.util.Iterator;
import java.util.Random;

/**
 * @Author: ming.wang
 * @Date: 2019/7/11 15:29
 * @Description:
 */
public class LinkedSet<T> implements SetADT<T> {

    private static Random random = new Random();

    private int count;

    private LinearNode<T> contents;

    public LinkedSet() {
        count = 0;
        contents = null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void add(T element) {

        if (!contains(element)) {
            LinearNode<T> tLinearNode = new LinearNode<>(element);
            tLinearNode.setNext(contents);
            contents = tLinearNode;
            count++;
        }

    }

    @Override
    public void addAll(SetADT<T> target) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public T removeRandom() throws Exception {
        LinearNode<T> previous, current;
        T result = null;
        if (isEmpty()) {
            return result;
        }

        int choice = random.nextInt(count) + 1;

        if (choice == 1) {
            result = contents.getElement();
            contents = contents.getNext();
        } else {

            previous = contents;
            for (int i = 2; i < choice; i++) {
                previous = previous.getNext();
            }
            current = previous.getNext();
            result = current.getElement();
            previous.setNext(current.getNext());
        }
        count--;
        return result;
    }

    @Override
    public T remove(T target) throws Exception {
        return null;
    }

    @Override
    public SetADT<T> union(SetADT<T> target) {
        return null;
    }

    @Override
    public boolean contains(T target) {
        return false;
    }

    @Override
    public boolean equals(SetADT<T> target) throws Exception {
        return false;
    }
}
