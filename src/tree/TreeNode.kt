package tree

data class TreeNode<T : Comparable<T>>(var left: TreeNode<T>? = null, var right: TreeNode<T>? = null, var data: T?)