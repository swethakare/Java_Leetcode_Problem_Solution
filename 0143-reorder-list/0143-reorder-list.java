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
    public void reorderList(ListNode head) {
        ListNode start = head;
        ListNode end = head;
        ListNode prevend = null;
        int len = 0;
        while(end.next != null){
            end = end.next;
            len++;
        }
        if(len < 2 || head == null){
            return;
        }
        int i = 0 ;
        ListNode dummy = null;
        while(i < len){
             dummy = start;
             while(dummy.next != null){
                prevend = dummy;
                dummy = dummy.next;
            }
            prevend.next = null;
            dummy.next = start.next;
            start.next = dummy;
            start = start.next.next;
            i++;
            len--; 
        }
        
        
    }
}