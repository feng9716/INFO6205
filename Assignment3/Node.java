public class Node<T>{
    public T val;
    public Node next;
    public Node prev;

    public Node(T val){
        this.val = val;
        next = null;
        prev = null;
    }
}