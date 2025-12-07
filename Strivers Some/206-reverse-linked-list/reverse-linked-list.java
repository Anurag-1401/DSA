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

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode prev = null, curr = head;

//         while (curr != null) {
//             ListNode next = curr.next;
//             curr.next = prev;
//             prev = curr;       
//             curr = next;  
//         }
//         return prev;
//     }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) return head;

        // Reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Fix the links
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}

