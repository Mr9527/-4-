package linkedList

import Leetcode.Node
import graph.bfs
import kotlin.test.assertEquals


fun main(args: Array<String>) {
    val n6 = LinkedNode("A", null)
    val n5 = LinkedNode("A", n6)
    val n4 = LinkedNode("B", n5)
    val n3 = LinkedNode("B", n4)
    val n2 = LinkedNode("A", n3)
    val node = LinkedNode("A", n2)
    n5.next = n3
    assertEquals(loopCheck(node), true,"implement error")
}


fun <T> loopCheck(node: LinkedNode<T>): Boolean {
    var fast: LinkedNode<T>? = node.next
    var slow: LinkedNode<T>? = node
    while (slow?.next != null) {
        if (fast?.next == slow.next) {
            return true
        }
        slow = slow.next
        fast = fast?.next?.next
    }


    return false
}