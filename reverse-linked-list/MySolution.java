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
    // public ListNode reverseList(ListNode head) {

    //     int i = 0;
    //     int o = 1;
    //     ListNode c = head;
    //     ListNode nextNode = head;
    //     while (head != null) {

    //         if (head.next == null) {
    //             break;
    //         }

    //         if (head.next != null && head.next.next == null) {
    //             head.next.next = head; // 3 --> 2
    //             ListNode newHead = head.next;
    //             if (i == 0) {
    //                 head.next = null;
    //             } else {
    //                  head.next = c; // 2 -- 1
    //                  if (i == 1) {
    //             c.next = null;
    //             i++;
    //         }
    //             } 
    //             head = newHead;
    //             break;
    //         }

    //         if (i == 0) {
    //             i++;
    //             head = head.next; // 1 wird zu 2
    //             continue;
    //         }
    //         // 1 --> 2 --> 3 | 2 --> 3 --> 4
    //         nextNode = head.next; // save 3 | save 4
    //         head.next = c; // 2 --> 1 | 3 --> 2

    //         if (i == 1) {
    //             c.next = null;
    //             i++;
    //         }

    //         c = head; // c = 2 --> c = 3
    //         head = nextNode; // wir sind nun auf der 3
    //     }
        
    //     return head;
    // }
}