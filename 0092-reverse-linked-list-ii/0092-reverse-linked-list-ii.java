class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        int i = 1;
        
        // Move cur pointer to the node at left index
        while (cur != null && i < left) {
            prev = cur;
            cur = cur.next;
            i++;
        }
        
        // Store the nodes before and after the sublist to be reversed
        ListNode dummy1 = prev;
        ListNode dummy2 = cur;
        
        // Reverse the sublist
        while (cur != null && i <= right) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        
        // Update connections
        if (dummy1 != null) {
            dummy1.next = prev;
        } else {
            head = prev; // If reversing starts from the head, update head to the new start of the sublist
        }
        dummy2.next = cur; // Connect the end of the sublist to the node after the sublist
        
        return head;
    }
}
