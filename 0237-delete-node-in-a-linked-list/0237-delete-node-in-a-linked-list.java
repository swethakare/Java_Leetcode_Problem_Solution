/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode savecur = null;
        while(cur.next != null){
            cur.val = cur.next.val;
            savecur = cur;
            cur = cur.next;            
        }
        savecur.next = null;
        
    }
}