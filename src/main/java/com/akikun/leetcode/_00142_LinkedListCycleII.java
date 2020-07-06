package com.akikun.leetcode;

import com.akikun.leetcode.struct.ListNode;

public class _00142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode p = head, q = head;
        while (p != null && q != null) {
            p = p.next;
            if (q.next == null) return null;
            q = q.next.next;

            if (p == q) {
                ListNode k = head;
                while (k != p) {
                    k = k.next;
                    p = p.next;
                }
                return k;
            }
        }
        return null;
    }
}
