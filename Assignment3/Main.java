public class Main {
    public static void main(String[] args) {
        // Create a null head;
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(0);
        //3-2-1-0
        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        //3-2-1-0-1-2-3
        list.addToTail(1);
        list.addToTail(2);
        list.addToTail(3);
        


        System.out.println("This size of list is: " + list.size());
        list.printList();

    }
}
