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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Base case: empty list or nothing to reverse
        if (head == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        // Step 1: Move `pre` to the node immediately before the `left` position
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        
        // Step 2: Set up pointers for the reversal process
        ListNode start = pre.next; // The first node to be reversed
        ListNode then = start.next; // The node that will be moved next
        
        // Step 3: Reverse the sublist by shifting nodes to the front of the sublist
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}