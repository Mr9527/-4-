package section_1;



import java.util.Iterator;

/**
 * 基于链表编写的简单的下压栈
 * @param <T>
 */
public class MyStack<T> implements Iterable<T> {

    private int size;

    private Node<T> first;

    public void push(T t) {
        Node node = first;
        first = new Node();
        first.item = t;
        first.next = node;
        size++;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first != null;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class Node<T> {
        private T item;
        private Node next;
    }

    private class StackIterator implements Iterator<T> {
        private Node<T> iteratorNode = first;

        public StackIterator() {

        }

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

    public static void main(String[] args) {

        MyStack<String> stack = new MyStack<>();

        for (int i = 0; i < 10; i++) {
            stack.push("Label: " + i);
        }
        stack.forEach(System.err::println);

        System.err.println("pop" + stack.pop());
    }
}
