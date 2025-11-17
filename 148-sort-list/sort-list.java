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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        ListNode temp = head;
        while (temp != null) {
            min = Math.min(min, temp.val);
            max = Math.max(max, temp.val);
            temp = temp.next;
        }
        int[] freq = new int[max - min + 1];
        temp = head;
        while (temp != null) {
            freq[temp.val - min]++;
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < freq.length; i++) {
            while (freq[i]-- > 0) {
                temp.val = i + min;
                temp = temp.next;
            }
        }
        return head;
    }
}