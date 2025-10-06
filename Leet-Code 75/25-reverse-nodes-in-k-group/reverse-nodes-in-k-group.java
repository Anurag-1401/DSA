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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head,dummy = new ListNode(0),prev = dummy,next = null;
        dummy.next = head;
        int count =0;

        while(curr != null){
            count++;
            curr = curr.next;
        }

        while(count >= k){
            curr = prev.next;
            next = curr.next;

            for(int i=1;i<k;i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            count -=k;
            prev = curr;
        }
        return dummy.next;
    }
}