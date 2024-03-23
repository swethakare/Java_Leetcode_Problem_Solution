class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return; // No need to reorder if the list is empty or has only one node
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = null;

        // Find the middle of the list using the slow and fast pointers
        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        ListNode right = slow.next;
        slow.next = null; // Break the link from the first half to the second half

        // Reverse the second half of the list
        ListNode reversedSecondHalf = reverse(right);

        // Merge the two halves of the list
        merge(head, reversedSecondHalf);
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Helper function to merge two linked lists alternately
    private void merge(ListNode first, ListNode second) {
        while (first != null && second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
