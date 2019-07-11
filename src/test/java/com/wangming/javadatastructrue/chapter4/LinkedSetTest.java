package com.wangming.javadatastructrue.chapter4;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedSetTest {

    @Test
    public void removeRandomTest() throws Exception {
        LinkedSet<Integer> set = new LinkedSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);

        set.removeRandom();
    }
}