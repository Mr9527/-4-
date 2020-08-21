package greedy_algorithm

data class Beans(val name: String, var count: Int, val widget: Int) {
    fun unitPrice(): Double = count / widget.toDouble()
}

/**
 *  有容纳 100 kg 的背包，可以装各种物品。我们有 5 种豆子，每种豆子的总量和价值都各不相同。求背包总价最大的合理方式
 */
fun distributionBackpack() {
    val beanArray = arrayOf(
        Beans("红豆", 60, 120),
        Beans("黄豆", 100, 100),
        Beans("绿豆", 30, 90),
        Beans("黑豆", 20, 80),
        Beans("青豆", 50, 75)
    )
    beanArray.forEachIndexed { index, bean ->
        beanArray.forEachIndexed { childIndex, childBean ->
            if (childBean.unitPrice() > bean.unitPrice()) {
                val tmp = beanArray[index]
                beanArray[index] = beanArray[childIndex]
                beanArray[childIndex] = tmp
            }
        }
    }

    val backpack = HashSet<Beans>()
    val maxCount = 100
    var currentCount = 0
    var i = 0
    while (currentCount < maxCount && i < beanArray.size) {
        val element = beanArray[i]
        if (element.count + currentCount > maxCount) {
            element.count = maxCount - currentCount
        }
        backpack.add(element)
        currentCount += element.count
        i++
    }
    backpack.forEach {
        println(it)
    }
}


fun main(args: Array<String>) {
    distributionBackpack()
}