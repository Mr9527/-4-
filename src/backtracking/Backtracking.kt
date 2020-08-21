package backtracking


val result = arrayOfNulls<Int>(8)

private fun counter(): () -> Int {
    var count = 0
    return {
        count++
    }
}

fun cal8Queens(row: Int, count: () -> Int) {
    if (row == 8) {
        printlnQueens(result, count)
        return // 8 行旗子都放好了
    }
    for (column in 0 until 8) {
        if (isOk(row, column)) {
            result[row] = column
            cal8Queens(row + 1, count)
        }
    }
}

fun isOk(row: Int, column: Int): Boolean {
    var leftUp = column - 1
    var rightUp = column + 1
    for (i in row - 1 downTo 0) {
        if (result[i] == column) {
            return false
        }
        if (leftUp >= 0 && result[i] == leftUp) {
            return false
        }
        if (rightUp < 8 && result[i] == rightUp) {
            return false
        }
        --leftUp
        ++rightUp
    }
    return true
}

fun printlnQueens(result: Array<Int?>, count: () -> Int) {
    // 打印出一个二维矩阵
    for (row in 0 until 8) {
        for (column in 0 until 8) {
            if (result[row] == column) {
                print("▲ ")
            } else {
                print("■ ")
            }
        }
        println()
    }
    count()
    println()
}

fun main(args: Array<String>) {
    val count = counter()
    cal8Queens(0, count)
    println(count())


    allocationBackpack(0, 0, intArrayOf(1, 2, 4, 5, 4, 8, 9, 3, 3, 6, 7, 8), 10)
    println(max)
}


/**
 * 0-1 背包问题
 * 通过回溯算法来解决 0-1 背包问题
 * 当我们有一个背包，背包的总重要是 w kg 。现在我们有 n 个物品，每个物品的重量不能， 并且不能分割。我们现在期望选择几件物品，装
 * 到背包中。在不超过背包所能装载的前提下，如何让背包中的物品总重量最大
 */
var max = Integer.MIN_VALUE
val mem: Array<Array<Boolean>?>   by lazy {
    val array: Array<Array<Boolean>?> = arrayOfNulls(12)
    for (i in 0 until 12) {
        array[i] = Array(10) { false }
    }
    array
}


fun allocationBackpack(
    i: Int,
    currentWidget: Int,
    items: IntArray,
    widgetStandard: Int
): ArrayList<Int>? {

    if (currentWidget == widgetStandard || i == items.size) {
        if (currentWidget > max) {
            max = currentWidget
        }
        return null
    }
    // 重复的状态，不需要向下回溯了
    if (mem[i]!![currentWidget]) {
        return null
    }
    //记录当前状态已经被访问了
    mem[i]!![currentWidget] = true
    allocationBackpack(i + 1, currentWidget, items, widgetStandard)
    if (currentWidget + items[i] <= widgetStandard) {
        allocationBackpack(i + 1, currentWidget + items[i], items, widgetStandard)
    }
    return null
}

class Pattern(val pattern: String) {
    private var matched = false

    fun match(matchText: String): Boolean {
        matched = false

        return matched
    }

    private fun rematch(textIndex: Int, patternIndex: Int, matchText: String) {
        if (matched) {
            return
        }
        if (patternIndex == pattern.length) {
            if (textIndex == matchText.length) {
                matched = true
            }
            return
        }
        if (pattern[patternIndex] == '*') {
            for (k in 0..matchText.length - textIndex) {
                rematch(textIndex + 1, patternIndex + 1, matchText)
            }
        } else if (pattern[patternIndex] == '?') {
            // 匹配 0 个或多个任意字符，使用回溯来暴力匹配
            rematch(textIndex, patternIndex + 1, matchText)
            rematch(textIndex + 1, patternIndex + 1, matchText)
        } else if (textIndex < matchText.length && pattern[patternIndex] == matchText[textIndex]) {
            // 纯字符串匹配
            rematch(textIndex + 1, patternIndex + 1, matchText)
        }
    }
}
