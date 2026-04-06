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
    public ListNode reverseList(ListNode head) {
        
        // 1 --> 2 --> 3
        ListNode last = null;
        ListNode c = head;

        while (c != null) {
            // save the reference of c.next, because the next line overwrites it
            ListNode newHead = c.next;
            c.next = last;
            // move last to index + 1
            last = c;
            // move c to saved reference
            c = newHead;
        }

        return last;

    }
}