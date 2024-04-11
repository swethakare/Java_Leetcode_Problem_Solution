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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null){
            return l2;
        }else if(l1 != null && l2 == null){
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode newlist = new ListNode(-1);
        ListNode save = newlist;
        int carry = 0;
        while(cur1!= null && cur2!= null){
            int sum = cur1.val + cur2.val + carry;
            int val = sum >= 10 ? sum%10 : sum ;
            ListNode dummy = new ListNode(val);
            carry = sum/10;
            newlist.next = dummy;
            cur1 = cur1.next;
            cur2 = cur2.next;
            newlist = newlist.next;
            System.out.println(newlist.val);
        }
        while(cur1 != null){
            if(carry > 0){
                int sum = cur1.val + carry;
                ListNode dummy = new ListNode(sum%10);
                carry = sum/10;
                newlist.next = dummy;
                cur1 = cur1.next;
                newlist = newlist.next;
                
            }else{
                newlist.next = cur1;
                newlist = newlist.next;
                cur1 = cur1.next;
            }
        }
        while(cur2 != null){
            if(carry > 0){
                int sum = cur2.val + carry;
                ListNode dummy = new ListNode(sum%10);
                carry = sum/10;
                newlist.next = dummy;
                cur2 = cur2.next;
                newlist = newlist.next;
                
            }else{
                newlist.next = cur2;
                newlist = newlist.next;
                cur2 = cur2.next;
            }
        }
        

        if(carry > 0){
            newlist.next = new ListNode(carry);
        }
        
        return save.next;        
    }
}