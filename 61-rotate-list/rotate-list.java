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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null|| head.next == null || k==0) return head;
        
        int length = 1;
        ListNode curr = head;

        while(curr.next!=null){
            curr = curr.next;
            length++;
        }

        curr.next = head;
        k = k%length;
        int steps = length - k -1;
        ListNode newTail = head;

        for(int i=0;i<steps;i++){
            newTail = newTail.next;
        }

        ListNode newhead = newTail.next;
        newTail.next = null;

        return newhead;

    }
}