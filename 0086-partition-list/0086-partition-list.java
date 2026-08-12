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
    public ListNode partition(ListNode head, int x) {
        // Dummy heads to build the two lists easily
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        
        // Pointers to track the end of both lists
        ListNode less = lessHead;
        ListNode greater = greaterHead;
        
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;
                less = less.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }
        
        // Prevent cycle in the linked list
        greater.next = null;
        
        // Connect the 'less' list with the 'greater' list
        less.next = greaterHead.next;
        
        return lessHead.next;
    }
}