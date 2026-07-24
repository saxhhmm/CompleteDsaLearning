/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Agar kisi bhi list ka head null hai, toh intersection possible hi nahi
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        // Loop tab tak chalega jab tak pA aur pB same node par na aa jayein
        while (pA != pB) {
            // Agar pA null par pahunch gaya, toh use List B ke head par bhej do
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next; // Warna ek step aage badhao
            }
            
            // Agar pB null par pahunch gaya, toh use List A ke head par bhej do
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next; // Warna ek step aage badhao
            }
        }
        
        // Jab loop break hoga, toh pA ya toh intersection node hoga, ya phir null hoga
        return pA;
    }
}