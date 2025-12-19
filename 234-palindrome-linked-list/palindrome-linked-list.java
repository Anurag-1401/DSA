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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow=head,fast=head,prev=null,curr=head,next=head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        if(fast!=null) slow = slow.next;

        while(prev!=null){
            if(prev.val != slow.val) return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}