package Leetcode;

public class isValid {

    static class EasyStack {
        static class ListNode {
            char val;
            ListNode next;

            ListNode() {
            }

            ListNode(char val) {
                this.val = val;
            }

            ListNode(char val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        ListNode head;

        public void push(char val) {
            ListNode node = head;
            head = new ListNode();
            head.val = val;
            head.next = node;
        }

        public char pop() {
            if (head == null) return '_';
            char val = head.val;
            head = head.next;
            return val;
        }
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        EasyStack stack = new EasyStack();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                stack.push(aChar);
            } else if (aChar == ')') {
                char pop = stack.pop();
                if (pop != '(') return false;
            } else if (aChar == '}') {
                char pop = stack.pop();
                if (pop != '{') return false;
            } else if (aChar == ']') {
                char pop = stack.pop();
                if (pop != '[') return false;
            }
        }
        return stack.pop() == '_';
    }

    public static void main(String[] args) {
        System.err.println(isValid("{[]}"));
    }

}
