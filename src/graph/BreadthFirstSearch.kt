package graph

import java.util.*
import java.util.HashMap


fun main(args: Array<String>) {
    val a = LinkedList<String>()
    a.add("B")
    a.add("D")
    a.add("H")
    a.add("C")
    val b = LinkedList<String>()
    b.add("A")
    b.add("C")
    b.add("D")
    b.add("F")
    val c = LinkedList<String>()
    c.add("E")
    c.add("B")
    c.add("D")
    val d = LinkedList<String>()
    d.add("A")
    d.add("E")
    d.add("G")
    val e = LinkedList<String>()
    e.add("D")
    e.add("F")
    e.add("C")
    val f = LinkedList<String>()
    f.add("E")
    f.add("G")
    f.add("B")
    val g = LinkedList<String>()
    g.add("D")
    g.add("H")
    g.add("F")
    val h = LinkedList<String>()
    h.add("A")
    h.add("G")


    val graph = HashMap<String, LinkedList<String>>()
    graph["A"] = a
    graph["B"] = b
    graph["C"] = c
    graph["D"] = d
    graph["E"] = e
    graph["F"] = f
    graph["G"] = g
    graph["H"] = h

    graph.forEach { (tag, list) ->
        println()
        print("$tag :")
        list.forEach {
            print(" $it")
        }
    }
    // 记录每个顶点
    val dist = HashMap<String, Int>()
    val visited = "H"
    println()
    println("get the shortest distance  from all the points to point $visited")
    bfs(graph, dist, visited)
    println("搜索完毕")
    println("____________")
    println("search the path between two points  through BFS")
    val startVisited = "A"
    val endVisited = "E"
    println("point $startVisited to point $endVisited, path: ")
    bfs(graph, startVisited, endVisited)
}


/**
 * Breadth First Search (广度优先遍历)
 * 其主要思想是从起点开始，将其临近的所有顶点都加到一个队列中去，然后标记下这些顶点的距离为1.最后将起始顶点标记为已访问，今后就不
 * 会再访问。然后再从队列取出最先进队的顶点A,同时也取出其周边临近节点。加入队列末尾，将这些顶点的距离相对 A 再+1，最后离开这个顶
 * 点 A.依次下去，直到队列为空为止。
 */
fun bfs(graph: HashMap<String, LinkedList<String>>, dist: HashMap<String, Int>, visited: String) {

    val queue: Queue<String> = LinkedList()
    queue.add(visited)
    dist[visited] = 0
    var i = 0
    while (!queue.isEmpty()) {
        val top = queue.poll()
        i++
        println("The $i th element $top shortest distance from $visited is ${dist[top]} ")
        // 得出其周边还未被访问的顶点的距离
        val d = dist[top]!! + 1
        graph[top]!!.forEach {
            // 如果 dist 中还没有该元素说明没有被访问
            if (!dist.containsKey(it)) {
                dist[it] = d
                queue.add(it)
            }
        }
    }
}

/**
 * 利用广度搜索一条从起点到终点的路径
 */
fun bfs(graph: HashMap<String, LinkedList<String>>, startVisited: String, endVisited: String) {
    if (startVisited == endVisited) {
        return
    }
    val vertexCount = graph.size
    val visited = HashMap<String, Boolean>(vertexCount)
    val queue: Queue<String> = LinkedList()
    queue.add(startVisited)
    val prev = HashMap<String, String>(vertexCount)
    graph.forEach { (tag, _) ->
        prev[tag] = ""
        visited[tag] = false
    }
    while (queue.size != 0) {
        val tag = queue.poll()
        val list = graph[tag]
        list!!.forEach {
            // 如果这个顶点没有被访问过
            if (!visited[it]!!) {
                prev[it] = tag
                if (it == endVisited) {
                    output(prev, startVisited, endVisited)
                    return
                }
                visited[it] = true
                queue.add(it)
            }
        }
    }
}


private fun output(prev: HashMap<String, String>, startVisited: String, endVisited: String) {
    if (prev[endVisited] != "" && endVisited != startVisited) {
        output(prev, startVisited, prev[endVisited]!!)
    }
    print(endVisited)
}
