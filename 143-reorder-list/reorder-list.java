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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        while(curr!=null){
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;
        int size = stack.size();

        ListNode tail;
        for(int i=0;i<size/2;i++){
            tail = stack.pop();
            tail.next = curr.next;
            curr.next = tail;
            curr = tail.next;
        }
        curr.next = null;
    }
}