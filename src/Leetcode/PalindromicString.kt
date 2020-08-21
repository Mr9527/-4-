package Leetcode

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    assertEquals(check("AaBBAA"), false, "error")
    assertEquals(check("AABBAA"), true, "error")

    val n6 = Node("A", null)
    val n5 = Node("A", n6)
    val n4 = Node("B", n5)
    val n3 = Node("B", n4)
    val n2 = Node("A", n3)
    val node = Node("A", n2)

    assertEquals(checkByLinkedList(node), true, "implement error")
}

// 数组实现
fun check(str: String): Boolean {
    var flag = true
    val charArray = str.toCharArray()
    val size = str.length
    for (i in 0 until size) {
        val j = size - 1 - i
        if (i == j) {
            break
        }
        flag = charArray[i] == charArray[j]
        if (!flag) {
            return false
        }
    }
    return flag
}

// 单链表实现
// 使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。
fun <T> checkByLinkedList(node: Leetcode.Node<T>): Boolean {
    if (node.next == null) {
        return false
    }
    var fast: Leetcode.Node<T>? = node
    var slow: Leetcode.Node<T>?  = node
    var prev: Leetcode.Node<T>? = null;

    while (fast?.next != null) {
        fast = fast.next?.next
        val next = slow?.next
        slow?.next = prev
        prev = slow
        slow = next
    }


    while (slow != null) {
        if (slow.item != prev?.item) {
            return false;
        }
        slow = slow.next;
        prev = prev?.next;
    }

    return true;
}

data class Node<T>(var item: T, var next: Leetcode.Node<T>?)
