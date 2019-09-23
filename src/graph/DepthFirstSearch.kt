package graph

import java.util.*

fun main(args: Array<String>) {
    val a = LinkedList<String>()
    a.add("H")
    a.add("C")
    val b = LinkedList<String>()
    b.add("E")
    val c = LinkedList<String>()
    c.add("D")
    val d = LinkedList<String>()
    d.add("B")
    val e = LinkedList<String>()
    e.add("F")
    e.add("H")
    val f = LinkedList<String>()
    f.add("G")
    val g = LinkedList<String>()
    g.add("H")
    g.add("E")
    val h = LinkedList<String>()
    h.add("F")


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
    val dfsVisited = HashMap<String, Boolean>()
    dfs(graph, dfsVisited, "A", "B")
}

fun dfs(graph: HashMap<String, LinkedList<String>>, dist: HashMap<String, Boolean>, startVisited: String) {
    vertical(graph, dist, startVisited)
}

fun dfs(
    graph: HashMap<String, LinkedList<String>>,
    dist: HashMap<String, Boolean>,
    startVisited: String,
    endVisited: String
) {
    val visit = visit(graph, dist, startVisited, endVisited)
    if (visit) {
        println(startVisited)
        println("搜索成功")
    } else {
        println("搜索失败")
    }
}


private fun vertical(
    graph: HashMap<String, LinkedList<String>>,
    dist: HashMap<String, Boolean>,
    startVisited: String
) {
    val counter = counter()
    return allVisit(graph, dist, startVisited, counter)
}


private fun counter(): () -> Int {
    var count = 0
    return {
        count++
    }
}

private fun allVisit(
    graph: HashMap<String, LinkedList<String>>,
    dist: HashMap<String, Boolean>,
    startVisited: String,
    count: () -> Int
) {
    if (!dist.containsKey(startVisited)) {
        val num = count()
        println()
        println(" $startVisited : $num")
        dist[startVisited] = true
        graph[startVisited]!!.forEach {
            if (!dist.containsKey(it)) {
                allVisit(graph, dist, it, count)
            }
        }
    }
}

private fun visit(
    graph: HashMap<String, LinkedList<String>>,
    dist: HashMap<String, Boolean>,
    startVisited: String,
    endVisited: String
): Boolean {
    if (startVisited == endVisited) {
        return true
    }
    if (!dist.containsKey(startVisited)) {
        println()
        dist[startVisited] = true
        graph[startVisited]!!.forEach {
            if (!dist.containsKey(it)) {
                val visit = visit(graph, dist, it, endVisited)
                if (visit) {
                    println(it)
                    return true
                }
            }
        }
    }
    return false
}

