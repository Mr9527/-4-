package linkedList

fun main(args: Array<String>) {

    val node: LinkedNode<Int> = LinkedNode(0, null)
    var tmp: LinkedNode<Int> = node
    for (i in 1..10) {
        val linkedNode = LinkedNode(i, null)
        tmp.next = linkedNode
        tmp = linkedNode
    }
    node.print()
    val remove = remove(node, 5)
    remove.print()
}

fun <T> remove(nodeList: LinkedNode<T>, count: Int): LinkedNode<T> {
    val node: LinkedNode<T> = nodeList
    var currentNode = node
    while (currentNode.next != null) {
        var tmpNode: LinkedNode<T>? = currentNode
        for (i in 0 until  count) {
            if (tmpNode?.next == null) {
                break
            }
            tmpNode = tmpNode.next
        }
        if (tmpNode?.next == null) {
            val next = currentNode.next
            val linkedNode = next!!.next
            currentNode.next = linkedNode
            return node
        }
        currentNode = tmpNode
    }
    return node
}