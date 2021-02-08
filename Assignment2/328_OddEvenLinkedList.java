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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        
        // Create node for odd numbers and even numbers;
        ListNode odd = head, even = head.next;
        ListNode evenhead = even;
        
        while(even != null && even.next != null){
            // Add the next of even node to odd
            // Since the next of even node must be odd
            odd.next = even.next;
            // update the odd pointer;
            odd = odd.next;
            
            // Do the same for even side
            even.next = odd.next;
            even = even.next;
            
        }
        
        odd.next = evenhead;
        return head;
    }
}