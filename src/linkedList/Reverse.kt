package linkedList

import backtracking.result

fun main(args: Array<String>) {
    var node: LinkedNode<Int> = LinkedNode(0, null)
    var tmp: LinkedNode<Int> = node
    for (i in 1..10) {
        val linkedNode = LinkedNode(i, null)
        tmp.next = linkedNode
        tmp = linkedNode
    }
    node.print()
    val reverse = reverse(node)
    reverse.print()
}

// kotlin 的函数参数为 final 无法修改
fun <T> reverse(nodeList: LinkedNode<T>): LinkedNode<T> {
    var node = nodeList
    val firstNode = node;
    var prev: LinkedNode<T>? = null
    while (true) {
        val next = node.next
        node.next = prev
        if (next == null) {
            break
        }
        prev = node
        node = next!!
    }
    firstNode.next = null
    return node
}

