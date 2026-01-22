public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headB;
        while(a!=null){
        ListNode b = headA;
            while(b!=null){
                if(a==b){
                    return a;
                }
                b=b.next;
            }
            a=a.next;
        }
        return null;
        
    }
}