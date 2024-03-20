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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        ListNode prev= null;
        ListNode nexttoattach = null;
        int i = 0;
        while(i < a){
            prev = cur;
            cur = cur.next;
            i++;
        }
        prev.next = list2;
        ListNode cur2 = list2;
        while(cur2.next!=null){
            cur2 = cur2.next;
        }
        nexttoattach = cur;
        while(i <= b){
            nexttoattach = nexttoattach.next;
            i++;
        }
        cur2.next = nexttoattach;
        return list1;
    }
}