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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode newlist = new ListNode(-1);
    ListNode savelist = newlist;
    ListNode temp1 = new ListNode(-1);
        
        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                newlist.next = list2;
                newlist = newlist.next;
                list2 = list2.next;
                newlist.next = null;
            }else{
                newlist.next = list1;
                newlist = newlist.next;
                list1 = list1.next;
                newlist.next = null;
            }
        }
        if(list1 != null){
            newlist.next = list1;
        }
        if(list2 != null){
            newlist.next = list2;
        }
        return savelist.next;
            
    }
}