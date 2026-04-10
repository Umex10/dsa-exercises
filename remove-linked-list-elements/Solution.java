class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        // needed to be able to delete the head like all the ather notes
        dummy.next = head;

        ListNode c = dummy;

        while (c.next != null) {

            if (c.next.val == val) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }

        return dummy.next;
    }
}