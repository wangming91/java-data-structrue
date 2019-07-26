package com.wangming.javadatastructrue.chapter7.队列实现基数排序;

import com.wangming.javadatastructrue.chapter7.数组实现.ArrayQueue;

/**
 * @Author: ming.wang
 * @Date: 2019/7/17 11:10
 * @Description:
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] list = {7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241, 6589, 6622, 1211};
        String temp;
        Integer numObj;
        int digit, num;
        ArrayQueue<Integer>[] digitQueue = new ArrayQueue[10];

        for (int i = 0; i <= 9; i++) {
            digitQueue[i] = new ArrayQueue<>();
        }

        for (int position = 0; position <= 3; position++) {
            for (int i = 0; i < list.length; i++) {
                temp = String.valueOf(list[i]);
                digit = Character.digit(temp.charAt(3 - position), 10);

            }
        }
    }

//    public static void main(String[] args) {
//        int digit = Character.digit(51, 6);//正常
//        int digit2 = Character.digit(50,2);//越界
//        int digit3 = Character.digit(47,2);//非数字ASCII码
//
//        boolean digitb = Character.isDigit(51);
//        System.out.println("digit = " + digit);
//
//        boolean digit2b = Character.isDigit(50);
//        System.out.println("digit2 = " + digit2);
//
//        boolean digit3b = Character.isDigit(47);
//        System.out.println("digit3 = " +digitb+digit2b+digit3b +digit3);
//    }

}
