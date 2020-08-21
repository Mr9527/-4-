package Leetcode;

import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortListToBST {


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
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private ListNode globalNode = null;

    public TreeNode sortListToBST(ListNode node) {
        globalNode = node;
        int length = getLength(node);
        return buildTree(0, length - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode node = new TreeNode();
        node.left = buildTree(left, mid - 1);
        node.val = globalNode.val;
        globalNode = globalNode.next;
        node.right = buildTree(mid + 1, right);

        System.out.print("node :" + node.val);
        if (node.right != null) {
            System.out.print("node.right : " + node.right.val);
        }
        if (node.left != null) {
            System.out.print("node.left : " + node.left.val);
        }
        return node;
    }

    private int getLength(ListNode node) {
        int length = 0;
        ListNode cur = node;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        SortListToBST sortListToBST = new SortListToBST();
        ListNode n = new ListNode(0);
        ListNode f = n;
        for (int i = 1; i < 10; i++) {
            f.next = new ListNode(i);
            f = f.next;
        }
        TreeNode treeNode = sortListToBST.sortListToBST(n);

        while (treeNode != null) {
            System.out.print(" left " + treeNode.left);
            System.out.print(" node " + treeNode.val);
            System.out.print(" right " + treeNode.right);
            
        }
    }
}
