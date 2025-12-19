/*
Definition of singly linked list:
class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
}
*/

class Solution {
    public ListNode sortList(ListNode head) {
        ListNode zero = new ListNode(-1),one = new ListNode(-1),two = new ListNode(-1);
        ListNode z=zero,o=one,t=two,curr = head;

        while(curr!=null){
            if(curr.data == 0){
                z.next = curr;
                z = z.next;
            }else if(curr.data == 1){
                o.next = curr;
                o = o.next;
            }else{
                t.next = curr;
                t = t.next;
            }
            curr = curr.next;
        }

        z.next = (one.next != null) ? one.next : two.next;
        o.next = two.next;
        t.next = null;

        return zero.next;
    }
}
