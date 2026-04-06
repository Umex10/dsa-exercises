public class Solution {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    // Start node
    ListNode dummy = new ListNode(0);
    // Our current node
    ListNode current = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }
      // Move one forward
      current = current.next;
    }

    // If list1 has still 5 elements and list 2 is null, then we only need to
    // set the start of list1 remaining elements to current.next
    if (list1 != null) {
      current.next = list1;
    } else {
      current.next = list2;
    }

    // Since we initialized dummy with 0, we only need to return the next of it
    return dummy.next;
  }

}
