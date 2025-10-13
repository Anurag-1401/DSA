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

// 1
// class Solution {
//     public void reorderList(ListNode head) {
//         if(head == null || head.next == null) return;

//         Stack<ListNode> stack = new Stack<>();
//         ListNode curr = head;

//         while(curr!=null){
//             stack.push(curr);
//             curr = curr.next;
//         }
//         curr = head;
//         int size = stack.size();

//         ListNode tail;
//         for(int i=0;i<size/2;i++){
//             tail = stack.pop();
//             tail.next = curr.next;
//             curr.next = tail;
//             curr = tail.next;
//         }
//         curr.next = null;
//     }
// }

// 2
// class Solution {
//     static {
//         for (int i = 0; i <= 500; i++) {
//             reorderList(new ListNode());
//         }
//     }

//     public static ListNode FindMid(ListNode head){
//         ListNode slow = head;
//         ListNode fast = head;

//         while(fast.next != null && fast.next.next != null){
//              slow = slow.next;
//              fast = fast.next.next;
//         }
//         return slow;
//     }

//     public static ListNode reverse(ListNode head){
//         ListNode prev = null;
//         ListNode curr = head;
//         ListNode fwd = head;

//         while(curr != null){
//              fwd = curr.next;
//              curr.next = prev;
//              prev = curr;
//              curr = fwd;
//         }

//         return prev;
//     }
//     public static void reorderList(ListNode head) {
//         ListNode mid = FindMid(head);
//         ListNode RightHead = mid.next;
//         mid.next = null;
//         RightHead = reverse(RightHead);
       
//        ListNode ans = new ListNode(-1);
//        ListNode dummy = ans; 

//        while(head != null && RightHead != null){
//            dummy.next = head;
//           head =  head.next;
//           dummy = dummy.next ;
//           dummy.next = RightHead;
//           RightHead = RightHead.next;
//           dummy = dummy.next;
//        }
//     if(head != null){
//         dummy.next = head;
//     }

//      if(RightHead != null){
//         dummy.next = RightHead;
//     }
//        head = ans.next;

//     }
// }

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode second = reverse(slow.next);
        slow.next = null;  // split first half

        // Step 3: Merge two halves
        ListNode first = head;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
