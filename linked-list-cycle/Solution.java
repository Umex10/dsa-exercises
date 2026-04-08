/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head; // will always move 1 forward
        ListNode fast = head; // will always move 2 forward

        // Lets say there is a node difference of 5:
        // 5 - 2 (fast) + 1 (slow) = 4
        while (fast != null && fast.next != null) {
            slow = slow.next;      
            fast = fast.next.next;  

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
