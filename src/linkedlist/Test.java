package linkedlist;

public class Test {
    public static void main(String[] args) {
        DblListnode<String> head = new DblListnode<String>("cat", null);
        LinkedList<String> list = new LinkedList<String>(head);
        list.addNodeToFront("bb");
        list.addNodeToEnd("vv");
        list.addNodeAtIndex("dog", 1);
//        list.removeByIndex(1);
        list.removeByData("cat");
        list.printList();
        int numNodes = list.getNumNodes();
        System.out.print("\n" + numNodes + "\n");

        /*
        Question 1: Write code to change the contents of the second node's data field from "bat" to "cat".

        Question 2: Write code to insert a new node with "rat" in its data field between the two existing nodes.

         */

        DblListnode<String> node = new DblListnode<String>("ant", null);
        node.setNext(new DblListnode<String>("bat", null));
        node.getNext().setData("cat");
        DblListnode<String> node2 = new DblListnode<String>("rat", null);
        node2.setNext(node.getNext());
        node.setNext(node2);
        node2.setPrevious(node);
        while(node.getNext() != null) {
            System.out.print(node.getData());
            System.out.print(", ");
            node = node.getNext();
        }
        System.out.print(node.getData());
    }
}
