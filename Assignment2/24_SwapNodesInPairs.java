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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;
        
        swap(head);
        return head;
    }
    
    public void swap(ListNode head){
        if(head == null) return;
        if(head.next == null) return;
        
        int copy = head.val;
        ListNode next = head.next;
        
        head.val = next.val;
        next.val = copy;
        
        swap(head.next.next);
    }
}