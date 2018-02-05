package section_1

import edu.princeton.cs.introcs.StdIn
import edu.princeton.cs.introcs.StdOut

fun main(args: Array<String>) {

    val bag = Stats.MyBag<Double>()
    while (!StdIn.isEmpty()) {
        bag.add(StdIn.readDouble())
    }
    val size = bag.size();
    var sum = bag.sum()
    val mean = sum / size
    sum = bag.sumByDouble { (it - mean) * (it - mean) }
    val std = Math.sqrt(sum / (size - 1))
    StdOut.printf("Mean: %.2f\n", mean)
    StdOut.printf("Std dev: %.2f\n", std)
}

class Stats {
    //背包的简单实现
    interface Bag<in T> {
        fun add(item: T)

        fun isEmpty(): Boolean

        fun size(): Int
    }

    class MyBag<T> : Bag<T>, Iterable<T> {

        private var first: Node<T>? = null
        private var size: Int = 0;

        override fun add(item: T) {
            val oldNode = first
            first = Node(item, oldNode);
            size++
        }

        override fun isEmpty(): Boolean {
            return first == null
        }

        override fun size(): Int {
            return size
        }

        override fun iterator(): Iterator<T> {
            return ListIterator()
        }

        inner class ListIterator : Iterator<T> {

            private var current: Node<T>? = first;


            override fun hasNext(): Boolean {
                return current != null
            }

            override fun next(): T {
                val item = current!!.item
                current = current!!.next
                return item
            }

        }

        data class Node<T>(var item: T, var next: Node<T>?)
    }

}