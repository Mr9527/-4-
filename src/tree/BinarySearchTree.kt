package tree

import section_1.Node
import sun.reflect.generics.tree.Tree

class BinarySearchTree<T : Comparable<T>> {
    private var tree: TreeNode<T>? = null


    fun find(node: TreeNode<T>): TreeNode<T>? {
        if (node.data == null) {
            return null;
        }
        var p = tree
        while (p != null) {
            when (node.data!!.compareTo(p.data!!)) {
                -1 -> p = p.left
                1 -> p = p.right
                0 -> return p
            }
        }
        return null
    }


    fun insert(data: T) {
        if (tree == null) {
            tree = TreeNode(data = data)
            return
        }
        var p = tree
        while (p != null) {
            if (p.data!!.compareTo(data) == 1) {
                if (p.right == null) {
                    p.right = TreeNode(data = data)
                    return
                }
                p = p.right
            } else {
                if (p.left == null) {
                    p.left = TreeNode(data = data)
                    return
                }
                p = p.left
            }
        }
    }

    fun delete(data: T) {
        var currentNode = tree
        var currentNodeParent: TreeNode<T>? = null
        // 找到这个节点
        while (currentNode != null && currentNode.data!!.compareTo(data) == 0) {
            currentNodeParent = currentNode
            currentNode = if (currentNode.data!!.compareTo(data) == 1) currentNode.right else currentNode.left
        }
        if (currentNode == null) {
            return
        }
        // 如果这个节点有两个子节点
        if (currentNode.left != null && currentNode.right != null) {
            var minNode = currentNode.right
            var minNodeParent = currentNode
            while (currentNode.left != null) {
                minNodeParent = minNode
                minNode = minNode!!.left
            }
            currentNode.data = minNode!!.data
            currentNode = minNode
            currentNodeParent = minNodeParent
        }

        var child = when {
            currentNode.left != null -> currentNode.left
            currentNode.right != null -> currentNode.right
            else -> null
        }
        when {
            currentNodeParent == null -> tree = child
            currentNodeParent.left == currentNode -> currentNodeParent.left = child
            else -> currentNodeParent.right = child
        }
    }
}


