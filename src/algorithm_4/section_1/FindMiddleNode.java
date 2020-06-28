package algorithm_4.section_1;

public class FindMiddleNode {

    public static void main(String[] args) {
        Node evenNode = LinkedListUtils.createNodeBySize(11, true);
        Node unevenNode = LinkedListUtils.createNodeBySize(14, true);

        LinkedListUtils.print(middleNode(evenNode));
        LinkedListUtils.print(middleNode(unevenNode));
    }


    private static Node middleNode(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node fast = node.next;
        Node slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return fast == null ? slow : slow.next;
    }
}
