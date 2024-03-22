import java.util.ArrayList;

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode comp = head;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow);
        while(rev != null){
            if(comp.val != rev.val){
                return false;
            }
            comp = comp.next;
            rev = rev.next;
        }
        return true;
        
    }
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
