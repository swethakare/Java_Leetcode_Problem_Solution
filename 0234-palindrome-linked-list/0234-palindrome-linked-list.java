import java.util.ArrayList;

class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> ar = new ArrayList<>();
        ListNode cur = head;
        
        // Copy the values of the linked list to the ArrayList
        while(cur != null){
            ar.add(cur.val);
            cur = cur.next;
        }
        
        // Check if the ArrayList is a palindrome
        int start = 0;
        int end = ar.size() - 1;
        
        while (start < end) {
            if (!ar.get(start).equals(ar.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}
