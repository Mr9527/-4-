package section_1;

public class Node {

    public int value;
    public Node next;

    public Node(Node next) {
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
    }
}
