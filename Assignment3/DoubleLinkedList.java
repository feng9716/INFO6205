public class DoubleLinkedList<T> {
    public Node<T> head;

    public DoubleLinkedList(T val){
        head = new Node<>(val);
    }

    public DoubleLinkedList(){
        head = null;
    }

    /**
     * Add a val to the tail of the list
     * @param val
     */
    public void addToTail(T val){
        //Find the tail of LinkedList
        if(head == null) head = new Node<>(val);
        
        Node<T> cur = head;
        Node<T> temp = new Node<>(val);

        // Iterate until cur reaches the last element of list
        while(cur.next!=null){
            cur = cur.next;
        }

        cur.next = temp;
        temp.prev = cur;

    }

    /**
     * Add a val to the head of the list
     * @param val
     */
    public void addToHead(T val){
        if(head == null){
            head = new Node<>(val);
        }
        Node<T> temp = new Node<T>(val);
        temp.next = head;
        head.prev = temp;
        // update head node
        head = temp;
    }

    /**
     * Count number of Nodes in the list
     * @return
     */
    public int size(){
        int count = 0;
        Node<T> cur = head;
        while(cur != null){
            count ++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * print the all Nodes' val in this linked list 
     */
    public void printList(){
        Node<T> node = head;
        while(node!=null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.print("null\n");
    }
}
