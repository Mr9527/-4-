package offer;

import java.util.Stack;

public class ReversePrintLinkList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode node){
        Stack<ListNode> stack =new Stack<>();
        ListNode c=node;
        while (c != null) {
            stack.push(c);
            c=c.next;
        }
        int size =stack.size();
        int[] array=new int[size];
        for (int i = 0; i < size; i++) {
            array[i]=stack.pop().val;
        }
        return array;
    }
}
