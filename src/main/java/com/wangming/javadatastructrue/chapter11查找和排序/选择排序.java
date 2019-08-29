package com.wangming.javadatastructrue.chapter11查找和排序;

/**
 * @Author: ming.wang
 * @Date: 2019/7/29 15:09
 * @Description:
 */
public class 选择排序<T> {


    public void selectedSort(Comparable[] data) {

        int min;
        Comparable temp;

        for (int i = 0; i < data.length; i++) {
            min = i;

            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[min]) < 0)
                    min = j;
            }
            temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }

    }

}
