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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        
        // we use two pointer to point the start of deletion
        ListNode cur = head;
        ListNode tail = cur;
        
        while(cur!=null){
            // 1st part, we dont delete Node in this part
            // we move cur and tail together to find start of deletion 
            for(int i = 0;i < m-1;i++){
                cur = cur.next;
                // If we find cur point to null when we are finding the
                // next deletion, we can end whole search and return head
                if(cur == null) return head;
                tail = tail.next;
            }
            
            // 2nd part, we will delete Node
            // Only move tail pointer in this part
            for(int i = 0; i <= n;i++){
                tail= tail.next;
                // when we have reached beyond the tail
                // we stop moving tail pointer, we can directly point the 
                // cur pointer to tail
                if(tail == null) break;
            }
            cur.next = tail;
            cur = cur.next;
        }
        return head;
    }
}