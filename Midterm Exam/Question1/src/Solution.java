class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class Solution {

    public static void main(String[] args) {
	// write your code here
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);
        ListNode nine = new ListNode(9);

        //1->2->3->4->5
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        //6->7->8->9->3->4->5
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = three;


        ListNode n1 = one;
        ListNode n2 = six;

        System.out.println(areConverging(n1,n2));

    }

    // Time Complexity O(n+m), where n and m are size of two ListNode
    // Space Complexity O(1), we did not use any extra space to store data;
    public static boolean areConverging(ListNode n1, ListNode n2){
        int length1 = 0, length2 = 0;
        length1 = getLength(n1);
        length2 = getLength(n2);
        ListNode p1 = n1, p2 = n2;

        int diff = Math.abs((length1-length2));
        for(int i = 0; i < diff;i++){
            if(length1 > length2) {
                p1 = p1.next;
            }
            else if(length2 > length1){
                p2 = p2.next;
            }
        }

        while(p1!= null && p2 != null){
            if(p1 == p2){
                return true;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return false;
    }

    private static int getLength(ListNode node){
        int count = 0;
        ListNode head = node;
        while(head != null){
            count += 1;
            head = head.next;
        }
        return count;
    }
}
