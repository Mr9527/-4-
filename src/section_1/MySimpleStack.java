package section_1;


import java.util.Iterator;
import java.util.Stack;

/**
 * 基于数组编写的简单的下压栈
 * @param <T>
 */
public class MySimpleStack<T> implements Iterable<T> {


    public int index;

    public T[] nodes;

    public MySimpleStack() {

        nodes = (T[]) new Object[16];
    }

    public void push(T node) {
        if (index == nodes.length) {
            resize(nodes.length * 2);
        }
        nodes[index++] = node;
    }

    public T pop() {
        T node = nodes[--index];
        nodes[index] = null;
        if (index > 0 && index == nodes.length / 4) {
            resize(nodes.length / 2);
        }
        return node;
    }

    public void resize(int max) {
        T[] copyArray = (T[]) new Object[max];
        System.arraycopy(nodes, 0, copyArray, 0, index);
        nodes = copyArray;
    }

    public int size() {
        return index;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new StackArray();
    }

    public class StackArray implements Iterator<T> {

        public int s = index;

        @Override
        public boolean hasNext() {
            return s > 0;
        }

        @Override
        public T next() {
            return nodes[--s];
        }
    }
    public static void main(String[] args) {

        MySimpleStack<String> stack = new MySimpleStack<>();
        for (int i = 0; i < 34; i++) {
            stack.push(String.valueOf(i));
        }
//        stack.forEachRemaining(System.err::println);
        Stack<String> stacks = new Stack<>();


    }
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if (i == j) {
                    continue;
                }
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
