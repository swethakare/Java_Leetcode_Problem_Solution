class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        int i = 1;
        while (cur != null && i < left) {
            prev = cur;
            cur = cur.next;
            i++;
        }
        ListNode dummy1 = prev;
        ListNode dummy2 = cur;
        while (cur != null && i <= right) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        if (dummy1 != null){
            dummy1.next = prev;
        } else {
            head = prev; 
        }
        dummy2.next = cur; 
        return head;
    }
}
