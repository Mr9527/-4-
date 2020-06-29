package linkedList

data class LinkedNode<T>(var item: T, var next: LinkedNode<T>?) {

    fun print() {
        var node: LinkedNode<T>? = this
        println()
        while (node != null) {
            print(" ${node.item}")
            node = node.next
        }
        println()
    }
}
