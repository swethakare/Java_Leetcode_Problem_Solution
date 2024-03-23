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
    public ListNode rotateRight(ListNode head, int k) {

        ListNode cur = head;
        int len = 0;
        while(cur != null){
            cur = cur.next;
            len++;
        }
       if( head == null || len < 2 || k == len || k%len == 0){
            return head;
        }
        int rem = k%len;
        for(int i = 0 ; i < rem; i++){
            
            ListNode last = head;
            ListNode prevlast = null;
            while(last.next != null){
                prevlast = last;
                last = last.next;
            }
            prevlast.next = null;
            last.next = head;
            head = last;
        }
        return head;
        
    }
}