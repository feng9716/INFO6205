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
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null || head == null) return head;
        
        List<Integer> array = new ArrayList<>();
        
        ListNode cur = head;
        while(cur != null){
            array.add(cur.val);
            cur = cur.next;
        }
        
        int left = k-1;
        int right = array.size() - k;
        
        int temp = array.get(right);
        array.set(right,array.get(left));
        array.set(left,temp);
        cur = head;
        for(Integer i : array){
            cur.val = i;
            cur = cur.next;
        }
        return head;
    }
}