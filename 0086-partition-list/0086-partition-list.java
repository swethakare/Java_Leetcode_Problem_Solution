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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode more = new ListNode(-1);
        ListNode gret = more;
        ListNode small = less;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                less.next = new ListNode(cur.val);
                less = less.next;
            }else if(cur.val >= x){
                more.next = new ListNode(cur.val);
                more = more.next;
            }
            cur = cur.next;
        }
        less.next = gret.next;
        
        return small.next;
    
    }
    
}