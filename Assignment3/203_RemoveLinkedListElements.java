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
    public ListNode removeElements(ListNode head, int val) {
        
        /*
        ListNode dummy = new ListNode(-1);
        dummy.next= head;
        ListNode prev = dummy, curr = head;
        
        while(curr != null){
            if(curr.val==val) {
                prev.next= curr.next;
                
            }
            else{
                prev = prev.next;
            }
            curr = curr.next;
        }
        
        
        return dummy.next;
        */
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(cur!=null){
            if(cur.val == val){
                prev.next= cur.next;   
            }
            else prev = prev.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}