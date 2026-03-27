
class Solution {
    public ListNode reverseLis1t(ListNode head) {
        ListNode newhead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newhead;
            newhead = head;
            head = next;
        }
        return newhead;  
    }
    public ListNode reverseList(ListNode head) {
        ListNode newhead = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = newhead;
            newhead = head;
            head = next;
        }  
        return newhead;
    }
}