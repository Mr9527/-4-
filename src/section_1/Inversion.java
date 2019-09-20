package section_1;

public class Inversion {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node reverseNode = reverse(node1);
        LinkedListUtils.printAll(reverseNode);
        LinkedListUtils.printAll(reverseByList(reverseNode));
    }

    /**
     * 1234
     * temp=2
     * temp=3
     * temp=4
     * return 4 4->3->null
     * return 4 3->2->null
     * return 4 2->1>nul
     */
    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    private static Node reverseByList(Node node) {
        Node pre = null;
        Node next;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
