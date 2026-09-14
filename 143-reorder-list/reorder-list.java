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
//     public void reorderList(ListNode head) {
//         if (head == null || head.next == null) return;

//         ListNode slow = head, fast = head;
//         while (fast.next != null && fast.next.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         ListNode second = reverse(slow.next);
//         slow.next = null;

//         ListNode first = head;
//         while (second != null) {
//             ListNode temp1 = first.next;
//             ListNode temp2 = second.next;

//             first.next = second;
//             second.next = temp1;

//             first = temp1;
//             second = temp2;
//         }
//     }

//     private ListNode reverse(ListNode head) {
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
    public void reorderList(ListNode head) {
        recurse(head, head);
    }

    private ListNode recurse(ListNode head, ListNode fast){
        if(fast.next == null){
            ListNode tail = head.next;
            head.next = null;
            return tail;
        } else if(fast.next.next == null){
            ListNode tail = head.next.next;
            head.next.next = null;
            return tail;
        }

        ListNode tail = recurse(head.next, fast.next.next);
        ListNode nextTail = tail.next;
        tail.next = head.next;
        head.next = tail;
        return nextTail;
    }
}