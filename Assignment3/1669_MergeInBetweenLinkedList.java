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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        ListNode end = list1;
        ListNode list2_tail = list2;
        for(int i = 0; i<a-1;i++){
            start = start.next;
            end = end.next;
        }
        for(int i = a;i <= b+1;i++){
            end = end.next;
        }
        while(list2_tail.next!=null){
            list2_tail = list2_tail.next;
        }
        
        start.next = list2;
        list2_tail.next = end;
        
        return list1;
    }
}