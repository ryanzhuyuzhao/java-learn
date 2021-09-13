package com.alogrithm.learn.leetcode;

/**
 * @ClassName LinkedListNodeRemoveByrecursive
 * @Description leetcode-203
 * @Author Administrator
 * @Date 2021/8/24 0024 19:53
 * @Version 1.0
 */
public class LinkedListNodeRemoveByrecursive {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        /*ListNode res = removeElements(head.next,val);
        if (head.val == val) {
            return res;
        }else {
            head.next = res;
            return head;
        }*/
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
