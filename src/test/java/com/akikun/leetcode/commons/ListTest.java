package com.akikun.leetcode.commons;

import org.junit.Test;

import java.util.List;

public class ListTest {

    @Test
    public void testOf() {
        List<String> list = MyLists.of("hello", "", "world");
        MyLists.print(list);
    }

    @Test
    public void testFrom() {
        List<String> list = MyLists.from("[\"cats\", \"dog\", \"sand\", \"and\", \"cat\", \"\"]");
        MyLists.print(list);
    }
}
