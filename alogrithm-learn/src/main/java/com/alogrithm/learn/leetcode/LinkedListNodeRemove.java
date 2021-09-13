package com.alogrithm.learn.leetcode;

/**
 * @ClassName LinkedListNodeRemove
 * @Description
 * @Author Administrator
 * @Date 2021/8/24 0024 19:36
 * @Version 1.0
 */
public class LinkedListNodeRemove {


    public ListNode removeElements(ListNode head, int val) {
        /*while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null) {
            return null;
        }*/
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }




    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
