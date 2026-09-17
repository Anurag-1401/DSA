// class Solution {
//     public ListNode removeElements(ListNode head, int val) {
      
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
        
//         ListNode current = dummy;
        
//         while (current.next != null) {
//             if (current.next.val == val) {
//                 current.next = current.next.next;
//             } else {
//                 current = current.next;
//             }
//         }
        
//         return dummy.next;
//     }
// }


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        if (head.val == val) return head.next;
        return head;
    }
}