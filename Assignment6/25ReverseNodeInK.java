/*
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // IF k == 1, we dont need to reverse anything
        if(k == 1) return head;
        
        int count = 0;
        ListNode cur = head;
        while(cur!=null){
            cur = cur.next;
            count++;
        }
        
        if(k > count) return head;
        // Count the number of Nodes in this linkedList

        //Identify where to break the Group
        ListNode pointer = head;
        int i = 0; 
        while(i < k){
            pointer = pointer.next;
            i++;
        }
        // Reverse the Group
        ListNode newHead = reverse(head,k);
        head.next = reverseKGroup(pointer,k);
        
        return newHead;
    }
    
    public ListNode reverse(ListNode head, int k){
        ListNode newHead = null;
        ListNode pointer = head;
        
        while(k>0){
            ListNode second = pointer.next;
            pointer.next = newHead;
            newHead = pointer;
            pointer = second;
            
            k--;
        }

        return newHead;
    }

}
