package offer;


import Leetcode.EasyTree;

import java.util.*;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(EasyTree.TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<EasyTree.TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<EasyTree.TreeNode> levelQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            EasyTree.TreeNode node = queue.poll();
            levelQueue.offer(node);
            if (queue.isEmpty()) {
                List<Integer> levelElements = new ArrayList<>();
                while (!levelQueue.isEmpty()) {
                    EasyTree.TreeNode treeNode = levelQueue.poll();
                    levelElements.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                list.add(levelElements);
            }
        }
        return list;
    }

}
