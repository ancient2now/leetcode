package com.akikun.leetcode.struct;

public class ListNode {

    public int val;

    /**
     * if this is double linked list, will use the property 'pre'
     */
    public ListNode pre;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode from(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        if (arr.length == 1) {
            return head;
        }
        ListNode lastOne = head;
        for (int i = 1; i < arr.length; ++i) {
            ListNode node = new ListNode(arr[i]);
            lastOne.next = node;
            lastOne = node;
        }
        return head;
    }

    public void print() {
        ListNode p = this;
        StringBuilder sb = new StringBuilder("ListNode: [");
        while (p != null && p.next != null) {
            sb.append(p.val).append(" -> ");
            p = p.next;
        }
        sb.append(p.val).append(']');
        System.out.println(sb.toString());
    }
}
