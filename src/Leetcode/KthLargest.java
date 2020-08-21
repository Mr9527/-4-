package Leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class KthLargest {

    // 二叉搜索树的中序遍历为递增序列，该题的需要求第 K  大的节点的数值，为倒序递减序列，
    // 我们可以让中序遍历的左右子树遍历的过程调整一下，将递增改为递减然后计算层级就可以快速得出第 K 层的数值

    private int k, res = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        searchKValue(root);
        return res;
    }

    private void searchKValue(TreeNode root) {
        if (root == null) return;
        searchKValue(root.right);
        if (k == 0) return;
        if (k-- == 0) res = root.val;
        searchKValue(root.left);
    }
}
