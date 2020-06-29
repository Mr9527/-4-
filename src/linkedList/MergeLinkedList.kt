package linkedList

fun main() {

    val merge = merge(createNote(), createNote1())
    merge.print()
}

fun createNote(): LinkedNode<Int> {
    val node: LinkedNode<Int> = LinkedNode(0, null)
    var tmp: LinkedNode<Int> = node
    for (i in 1..10) {
        val linkedNode = LinkedNode(i, null)
        tmp.next = linkedNode
        tmp = linkedNode
    }
    node.print()
    return node
}

fun createNote1(): LinkedNode<Int> {
    val node: LinkedNode<Int> = LinkedNode(0, null)
    var tmp: LinkedNode<Int> = node
    for (i in 4..12 step 2) {
        val linkedNode = LinkedNode(i, null)
        tmp.next = linkedNode
        tmp = linkedNode
    }
    node.print()
    return node
}

fun merge(node1: LinkedNode<Int>, node2: LinkedNode<Int>): LinkedNode<Int> {
    var head = if (node1.item < node2.item) node1 else node2
    var prev: LinkedNode<Int>? = null
    var curr1: LinkedNode<Int>? = if (head==node1) node1 else node2
    var curr2: LinkedNode<Int>? = if (head==node1) node2 else node1
    while (curr1 != null && curr2 != null) {
        if (curr1.item <= curr2.item) {
            prev = curr1
            curr1 = curr1.next
        } else {
            val next = curr2.next
            prev!!.next = curr2
            curr2.next = curr1
            prev = curr2
            curr2 = next
        }
    }
    prev!!.next = curr1 ?: curr2
    return head
}