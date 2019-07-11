package com.wangming.javadatastructrue.chapter3;


import com.wangming.javadatastructrue.SetADT;

import java.util.Iterator;
import java.util.Random;

/**
 * @Author: ming.wang
 * @Date: 2019/7/10 16:36
 * @Description:
 */
public class ArraySet<T> implements SetADT<T> {

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

    public void addAll(SetADT<T> target) {
        Iterator<T> iterator = target.iterator();
        if (null == iterator)
            return;

        while (iterator.hasNext()) {
            add(iterator.next());
        }
    }

    public Iterator<T> iterator() {
        return new ArrayIterator<>(count, contents);
    }

    /**
     * 随机删除一个元素
     *
     * @return
     */
    public T removeRandom() throws Exception {
        if (isEmpty())
            throw new Exception("The set is not allowed empty!");

        int choice = random.nextInt(count);

        T result = contents[choice];

        contents[choice] = contents[count - 1];

        contents[count - 1] = null;

        count--;
        return result;

    }

    /**
     * 随机删除一个元素
     *
     * @return
     */
    public T remove(T target) throws Exception {
        if (isEmpty())
            throw new Exception("The set is not allowed empty!");

        if (null == target)
            throw new Exception("The element of remove is not allowed empty!");

        int search = NOT_FOUND;

        for (int i = 0; i < count && search == NOT_FOUND; i++) {
            if (target.equals(contents[i])) {
                search = i;
            }
        }
        if (search == NOT_FOUND)
            throw new Exception("The element of remove is not in the set!");

        T result = contents[search];
        contents[search] = contents[count - 1];

        contents[count - 1] = null;

        count--;

        return result;

    }

    public ArraySet<T> union(SetADT<T> target) {
        ArraySet<T> both = new ArraySet<>();

        both.addAll(target);

        for (int i = 0; i < count; i++) {

            both.add(contents[i]);
        }

        return both;

    }

    /**
     * 此处扩容策略为原数组大小的两倍，可根据需要定制自己的扩容策略
     */
    private void expandCapacity() {

        T[] larger = (T[]) new Object[contents.length * 2];

        for (int i = 0; i < contents.length; i++) {
            larger[i] = contents[i];
        }
        contents = larger;
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

    public boolean equals(SetADT<T> target) throws Exception {

        if (null == target || target.isEmpty())
            return false;
        ArraySet<T> temp1 = new ArraySet<>();
        ArraySet<T> temp2 = new ArraySet<>();

        temp1.addAll(this);
        temp2.addAll(target);

        Iterator<T> iterator = target.iterator();

        boolean result = false;

        if (size() == target.size()) {
            while (iterator.hasNext()) {
                T next = iterator.next();
                if (temp1.contains(next)) {
                    temp1.remove(next);
                    temp2.remove(next);
                }
            }
            result = temp1.isEmpty() && temp2.isEmpty();
        }
        return result;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += contents[i] + "\n";
        }
        return result;
    }
}

