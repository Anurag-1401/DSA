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
        
        ListNode s = head;
        ListNode f = head;
        
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        
        ListNode prev = null;
        ListNode cur = s;
        
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        
        ListNode l = head;
        ListNode r = prev;
        
        while(r != null){
            if(r.val != l.val) return false;
            l = l.next;
            r = r.next;
        }
            
        return true;
        
    }
}