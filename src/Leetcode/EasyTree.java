package Leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EasyTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。*/
    public static List<List<Integer>> treeLevel(TreeNode node) {
        if (node == null) return new ArrayList<>(0);
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        LinkedList<TreeNode> currentLevelQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode pop = queue.poll();
            currentLevelQueue.offer(pop);
            if (queue.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<>();
                while (!currentLevelQueue.isEmpty()) {
                    TreeNode poll = currentLevelQueue.poll();
                    level.add(poll.val);
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }

                results.add(level);
            }
        }
        return results;
    }

    public static boolean isBalanced(TreeNode root) {

        if (root == null) {
            return false;
        }

        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(TreeNode node) {

        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * 检查树从根节点到任意子节点的和是否能够为 sum
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;

        return levelCheckPathSum(root.left, sum, root.val) || levelCheckPathSum(root.right, sum, root.val);
    }

    private static boolean levelCheckPathSum(TreeNode node, int target, int current) {
        if (node == null) return false;
        if (node.left == null && node.right == null) {
            return target == current + node.val;
        }
        int sum = current + node.val;
        return levelCheckPathSum(node.left, target, sum) || levelCheckPathSum(node.right, target, sum);
    }

    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * <p>
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode leftNode;
        TreeNode rightNode;
        TreeNode node;
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null || t2 == null) {
            node = new TreeNode(t1 == null ? t2.val : t1.val);
            leftNode = t1 == null ? t2.left : t1.left;
            rightNode = t1 == null ? t2.right : t1.right;
        } else {
            node = new TreeNode(t1.val + t2.val);
            leftNode = mergeTrees(t1.left, t2.left);
            rightNode = mergeTrees(t1.right, t2.right);
        }
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }

    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * <p>
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static TreeNode mergeTreesEasy(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        t1.val += t2.val;
        t1.left = mergeTreesEasy(t1.left, t2.left);
        t1.right = mergeTreesEasy(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(10);
        node.left.left.left = new TreeNode(10);
        node.left.right = new TreeNode(20);
        List<List<Integer>> list = treeLevel(node);
        list
                .forEach(integers -> {
                    System.out.println();
                    for (Integer integer : integers) {
                        System.out.print(integer + " ");
                    }
                    System.out.println();
                });

        System.out.println(isBalanced(node));
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(hasPathSum(root, 1));
    }
}
