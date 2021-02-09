/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        // situation when head is null
        if(head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        
        
        Node prev = head, curr = head.next;
        Node add = new Node(insertVal);
        boolean insert = false;
        
        
        do{
            if(insertVal >= prev.val && insertVal <= curr.val) insert = true;
            else if(prev.val > curr.val){
                if(insertVal >= prev.val || insertVal <= curr.val){
                    insert = true;
                }
            }
            
            if(insert) {
                prev.next = add;
                add.next = curr;
                return head;
            }
            
            prev = curr;
            curr= curr.next;
            
        }while(prev!=head);
        
        prev.next = new Node(insertVal,curr);
        return head;
            
    }
    

}