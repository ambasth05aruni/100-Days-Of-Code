/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
       if (head == null) {
            return head;
        }

        ListNode next = head.next;
        if (next == null) {
            return head;
        }
        ListNode cur = next.next;

        head.next = cur;
        next.next = head;
        head = next;
        ListNode prev = head.next;

        if (cur == null || cur.next == null) {
            return head;
        }

        while (cur != null && cur.next != null) {
            prev.next = cur.next;
            boolean tonull=false;
            if (cur.next.next == null) {
                tonull = true;
            }
            ListNode tmp = cur.next.next;
            cur.next.next = cur;
            cur.next = tmp;
            prev = cur;
            cur = tmp;

        }

        return head;
    }
}  