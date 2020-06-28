package algorithm_4.section_1;


import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    public void enqueue(T t) {
        Node next = last;
        last = new Node();
        last.item = t;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            next.next = last;
        }
        size++;
    }

    public T dequeuq() {
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class Node {
        private T item;
        private Node next;
    }

    private class QueueIterator implements Iterator<T> {
        private Node iteratorNode = first;

        @Override
        public boolean hasNext() {
            return iteratorNode != null;
        }

        @Override
        public T next() {
            T item = iteratorNode.item;
            iteratorNode = iteratorNode.next;
            return item;
        }
    }

    public T readIndex(int index) {
        int lastIndex = size - index;
        Node node = first;
        for (int i = 0; i < this.size(); i++) {
            if (i == lastIndex) {
                System.err.println(node.item);
                break;
            } else {
                node = node.next;
            }
        }
        return node.item;
    }

    private int size() {
        return size;
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue("label_" + i);
        }
        queue.readIndex(1);
        queue.forEach(System.out::println);
    }
}
