package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {

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


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> treeList = new ArrayList<>();
        if (start > end) {
            treeList.add(null);
            return treeList;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            treeList.add(node);
            return treeList;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = buildTrees(start, i - 1);
            List<TreeNode> rightTree = buildTrees(i + 1, end);
            for (TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    treeList.add(node);
                }
            }
        }
        return treeList;
    }
}
