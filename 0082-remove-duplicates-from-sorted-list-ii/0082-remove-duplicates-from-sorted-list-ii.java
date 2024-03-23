class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0, head);
        ListNode prev = temp;

        while(head != null){
            if(head.next != null && head.val == head.next.val){
                //Skip the nodes
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                prev.next = head.next;
            }

            else {
                prev = prev.next;
            }

            head = head.next;
        }

        return temp.next;
    }
}