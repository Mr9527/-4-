package algorithm_4.section_1;

public class Merge {


    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node3;
        node3.next = node5;
        node2.next = node4;
        node4.next = node6;

//        Node list = mergeByList(node1, node2);
        Node list = mergeByRecursion(node1, node2);
        LinkedListUtils.printAll(list);
    }

    private static Node mergeByList(Node node1, Node node2) {
        Node node = node1.value > node2.value ? node2 : node1;

        Node pointer1 = node == node1 ? node1 : node2;
        Node pointer2 = node == node1 ? node2 : node1;

        Node prev = null;
        Node next = null;

        while (pointer1 != null && pointer2 != null) {
            if (pointer1.value < pointer2.value) {
                prev = pointer1;
                pointer1 = pointer1.next;
            } else {
                prev.next = pointer2;
                next = pointer2.next;
                pointer2.next = pointer1;
                prev = pointer2;
                pointer2 = next;
            }
        }
        prev.next = pointer1 == null ? pointer2 : pointer1;
        return node;
    }

    private static Node mergeByRecursion(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node node = null;

        if (node1.value > node2.value) {
            node = node2;
            node.next = mergeByRecursion(node1, node2.next);
        } else {
            node = node1;
            node.next = mergeByRecursion(node1.next, node2);
        }
        return node;
    }
}
