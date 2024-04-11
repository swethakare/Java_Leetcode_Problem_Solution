class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        
        int len = 0;
        ListNode cur1 = head;
        while(cur1 != null) {
            len++;
            cur1 = cur1.next;
        }
        
        for (int i = 0; i < len / k; i++) {
            for (int j = 1; j < k; j++) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
