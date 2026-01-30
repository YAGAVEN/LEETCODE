class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null ||head.next==null || k==0)return head;

        ListNode cur = head;
        int len = 1;
        while(cur.next!=null){
            cur=cur.next;
            len++;
        }
        cur.next = head;
        k  = k%len;
        k = len - k;
        while(k-- >0) cur = cur.next;
        head = cur.next;
        cur.next = null;
        return head;
    }
}