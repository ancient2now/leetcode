package com.akikun.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

class CQueue {

    private Queue<Integer> queue;

    public CQueue() {
        this.queue = new LinkedList<>();
    }

    public void appendTail(int value) {
        queue.add(value);
    }

    public int deleteHead() {
        Integer headValue = queue.poll();
        return headValue == null ? -1 : headValue;
    }
}
