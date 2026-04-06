/**
 * Definition for singly-linked list.
 * public class Solution {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        // 1, 1, 1, 2, 3, 4
        // 1 -> 1 -> 1 -> 2 -> 3 -> 4
        // [1,2,3,3]
        ListNode start = head; // our return
        ListNode i = head; // 0

        if (i == null) {
            return start;
        }

        ListNode j = head.next; // 1

        while (i != null && j != null) {

            if (i.val != j.val) {
                i.next = j;
                i = i.next;
            }

            if (i.val == j.val && j.next == null) {
                i.next = null;
            }

            j = j.next;

        }

        return start;

    }
}
