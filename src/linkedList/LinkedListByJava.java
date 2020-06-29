package linkedList;

public class LinkedListByJava {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void print() {
            System.err.println("");
            ListNode node = next;
            while (node != null) {
                System.err.print(node.val + " ");
                node = node.next;
            }
            System.err.println("");
        }
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }
        // 新链表的头部
        ListNode head = node1.val <= node2.val ? node1 : node2;

        // 两个起始结点，1号起始结点更小
        ListNode head1 = head == node1 ? node1 : node2;
        ListNode head2 = head == node1 ? node2 : node1;

        ListNode pre = null;
        ListNode next;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                pre = head1;
                head1 = head1.next;
            } else {
                next = head2.next;
                pre.next = head2;
                head2.next = head1;
                pre = head2;
                head2 = next;
            }
        }
        pre.next = head1 == null ? head2 : head1;
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode fast = sentry;
        ListNode tmp = sentry;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return sentry.next;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (true) {
            next = head.next;
            head.next = pre;
            if (next == null) {
                return head;
            }
            pre = head;
            head = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        mid = slow.next;
        slow = head;
        ListNode reverse = reverseList(mid);
        if (reverse == null) {
            return false;
        }
        while (reverse != null) {
            if (reverse.val != slow.val) {
                return false;
            }
            reverse = reverse.next;
            slow = slow.next;
        }
        reverseList(mid);
        return true;
    }

    public static void main(String[] args) {
//        ListNode note = MergeLinkedListKt.createNote_();
//        note.print();
//        removeNthFromEnd(note, 2);
//        note.print();
        ListNode n6 = new ListNode(1, null);
        ListNode n5 = new ListNode(1, n6);
        ListNode n4 = new ListNode(2, n5);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode node = new ListNode(1, n2);
        System.err.println(isPalindrome(node));
        node.print();
    }
}
