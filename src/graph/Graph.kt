package graph

import sun.security.provider.certpath.AdjacencyList
import java.util.*

class Graph(private var v: Int) {
    private var adjacencyList: LinkedList<LinkedList<Int>> = LinkedList()


    init {
        for (i in 0 until v) {
            adjacencyList[i] = LinkedList()
        }
    }

    fun addEdge(s: Int, t: Int) {
        adjacencyList[s].add(t)
        adjacencyList[t].add(s)
    }
}