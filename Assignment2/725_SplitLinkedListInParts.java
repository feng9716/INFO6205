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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        
        // count the number of nodes in root;
        int count = 0;
        ListNode cur = root;
        while(cur!=null){
            cur = cur.next;
            count++;
        }
        
        // Number of nodes in each element of array
        int size = count/k;
        
        // Number of nodes that have one extra node
        int extra = count % k;
    
        // have  pointers to record the windown of root
        ListNode right =root;
        
        //Iterate for the length of array (k)
        for(int i = 0; i < k;i++){
            // When we have array pointer i greater than number of nodes
            // we can set that array[i] = null
            if(i >= count){
                res[i] = null;
            }
            // else, we iterate the LinkedList and add node.
            else{
                // 1st case, we add nodes to element with 1 extra
                ListNode temp = new ListNode(right.val);
                ListNode pointer = temp;
                int j = 1;
                if(i < extra){
                    while(j < size + 1){
                        pointer.next = new ListNode(right.next.val);
                        right = right.next;
                        pointer = pointer.next;
                        j++;
                    }
                    pointer.next = null;
                    res[i] = temp;
                }
                // then we add nodes to element without extra
                else{
                    while(j < size){
                        pointer.next = new ListNode(right.next.val);
                        right = right.next;
                        pointer = pointer.next;
                        j++;
                    }
                    pointer.next = null;
                    res[i] = temp;
                }
                right = right.next;
            }
        }
        
        return res;
    }
}