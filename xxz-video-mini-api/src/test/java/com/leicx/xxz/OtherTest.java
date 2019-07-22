package com.leicx.xxz;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class OtherTest {

    private List<Integer> arrayList = new ArrayList<>(2 << 13);
    private List<Integer> linkedList = new LinkedList<>();

    @Before
    public void init() {
        for (int i = 0; i < 5000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @Test
    public void test() {
        long before = System.currentTimeMillis();
        for (int i = 0, len = arrayList.size(); i < len; i++) {
            arrayList.get(i);
        }
        long after = System.currentTimeMillis();
        System.out.println("arraylist用for循环：" + (after - before));

        long before1 = System.currentTimeMillis();
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long after1 = System.currentTimeMillis();
        System.out.println("arraylist用iterator循环：" + (after1 - before1));

        long before2 = System.currentTimeMillis();
        for (int i = 0, len = linkedList.size(); i < len; i++) {
            linkedList.get(i);
        }
        long after2 = System.currentTimeMillis();
        System.out.println("linkedList用for循环：" + (after2 - before2));

        long before3 = System.currentTimeMillis();
        Iterator<Integer> iterator1 = linkedList.iterator();
        while (iterator1.hasNext()) {
            iterator1.next();
        }
        long after3 = System.currentTimeMillis();
        System.out.println("linkedList用iterator循环：" + (after3 - before3));
    }

    @Test
    public void forTest() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.valueOf(i));
        }

        // 复现方法一
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                arrayList.remove(integer);
            }
        }

        // 复现方法二
        iterator = arrayList.iterator();
        for (Integer value : arrayList) {
            Integer integer = iterator.next();
            if (integer.intValue() == 5) {
                arrayList.remove(integer);
            }
        }
    }
}
