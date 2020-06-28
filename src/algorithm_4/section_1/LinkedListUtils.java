package algorithm_4.section_1;

import java.util.Random;

public class LinkedListUtils {

    public static void printAll(Node node) {
        Node temp = node;
        while (temp != null) {
            System.err.println(temp.value);
            temp = temp.next;
        }
    }

    public static void print(Node node) {
        System.err.println(node.value);
    }

    public static Node createNodeBySize(int size, boolean isSort) {
        Node node = new Node(isSort ? 1: new Random().nextInt(2));
        if (size == 1) {
            return node;
        }
        Node temp = node;
        for (int i = 1; i < size; i++) {
            Node next = new Node(isSort ? i+1 : new Random().nextInt(2));
            temp.next = next;
            temp = next;
        }
        return node;
    }
}