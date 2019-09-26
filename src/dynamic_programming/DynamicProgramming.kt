package dynamic_programming

import org.omg.CORBA.INTERNAL


fun knapsack(widget: IntArray, n: Int, w: Int): Int {
    val states = Array(n) { Array(w + 1) { false } }
    // 哨兵
    states[0][0] = true
    if (widget[0] <= w) {
        states[0][widget[0]] = true
    }
    for (i in 1 until n) {
        println()
        // 动态规划状态转移
        for (j in 0..w) {
            // 不把 i 个物品放进背包
            if (states[i - 1][j]) {
                states[i][j] = states[i - 1][j]
            }
        }
        for (j in 0..w - widget[i]) {
            // 把第 i 个物品放进背包
            if (states[i - 1][j]) {
                states[i][j + widget[i]] = true
            }
        }
    }
    for (i in w downTo 0) {
        if (states[n - 1][i]) {
            println()
            println("组合 :")
            var size = i
            for (k in n - 1 downTo 1) {
                if (size - widget[k] >= 0 && states[k - 1][size - widget[k]]) {
                    print(widget[k])
                    size -= widget[k]
                }
            }
            return i
        }
    }

    return 0
}

fun knapsack2(item: IntArray, w: Int) {

}

fun printArray(array: Array<Array<Boolean>>) {
    println()
    array.forEach { a ->
        a.forEach {
            print(if (it) " 1 " else " 0 ")
        }
    }
    println()
}

fun main() {
    val array = intArrayOf(2, 2, 4, 6, 3)
    knapsack(array, array.size, 10)
    println()
    double11advance(intArrayOf(2, 2, 4, 6, 3), 10)
}


fun double11advance(items: IntArray, w: Int) {
    val size = items.size
    val states = Array(size) { Array(3 * w + 1) { false } }
    states[0][0] = true
    if (items[0] <= 3 * w) {
        states[0][items[0]] = true
    }
    for (i in 1 until size) {
        for (j in 0..3 * w) {
            if (states[i - 1][j]) {
                states[i][j] == states[i - 1][j]
            }
        }
        for (j in 0..3 * w - items[i]) {
            if (states[i - 1][j]) {
                states[i][j + items[i]] = true
            }
        }
    }
    var j = w
    while (j < 3 * w + 1) {
        if (states[size - 1][j]) {
            break
        }
        j++
    }
    // 没有可行解
    if (j == 3 * w + 1) {
        return
    }
    for (i in size - 1 downTo 1) {
        if (j - items[i] >= 0 && states[i - 1][j - items[i]]) {
            print(items[i])
            j -= items[i]
        }
    }
    if (j != 0) {
        print(items[0])
    }
}
