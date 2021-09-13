package com.alogrithm.learn.leetcode;

/**
 * @ClassName LinkedReverse
 * @Description leetcode-203
 * @Author Administrator
 * @Date 2021/8/24 0024 22:22
 * @Version 1.0
 */
public class LinkedReverse {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!= null) {
            ListNode next = cur.next;
            cur.next = pre;
            cur = next;
            pre = cur;
        }
        return pre;
    }

    public ListNode reverseListByRecursive(ListNode head) {
        if (head.next == null || head == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
