package com.akikun.leetcode.commons;

import org.junit.Test;

import java.util.List;

public class ListTest {

    @Test
    public void testOf() {
        List<String> list = Lists.of("hello", "", "world");
        Lists.print(list);
    }

    @Test
    public void testFrom() {
        List<String> list = Lists.from("[\"cats\", \"dog\", \"sand\", \"and\", \"cat\", \"\"]");
        Lists.print(list);
    }
}
