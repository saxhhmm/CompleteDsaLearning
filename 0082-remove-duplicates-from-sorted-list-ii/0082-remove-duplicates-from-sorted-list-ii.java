class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // If the current node is part of a duplicate sequence
        if (head.val == head.next.val) {
            // Skip all identical nodes
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            // Recursively evaluate the rest of the list, completely bypassing the duplicates
            return deleteDuplicates(head.next);
        } else {
            // If the current node is unique, attach the cleaned up suffix to it
            head.next = deleteDuplicates(head.next);
            return head; // Keep this unique node
        }
    }
}