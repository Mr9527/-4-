package section_2

/**
 *通常人们整理桥牌的方法是一张一张来，将每一张牌插入到其他已经有序的牌中的适当位置。
 * 在计算器的实现中，为了要插入的元素腾出空间，我们将其余需要所有元素在插入之前都向右移动一位，这种算法叫做插入排序
 * - 插入排序所需的时间取决于输入中元素的初始顺序
 * - 对于随机排列的长度为 N 且主键不重复的数组，平均情况下需要 ~N^2/4次比较和 ~N^2/4次交换。最坏情况需要 N^2/2次的比较和交换
 * 最好的情况则只需要 N-1 次比较和 0 次交换。
 *
 * 对排序的数组进行多次遍历，每找到较小元素则将它插入到已知的正确位置中，为了给插入的元素腾出空间，需要将所有在该元素之前的元素向右
 * 移动一位（在算法中的体现就是 内循环的交换次数等于每次循环需要移动的元素个数）
 *
 * 虽然插入排序的在时间复杂度上和冒泡排序都是一样的，但如果我们希望把优化做到极致，那肯定首选插入排序。因为
 * 用冒泡排序，需要 K 次交换操作，但是每次交换都需要 3 个赋值语句，所以交换操作总耗时就是3*k 单位时间。
 *
 */
class Insertion {

    companion object {

        /**
         * java 版本
         *  for(i=0;i<n;i++){
         *  for(j=i;j>0%%less(a[j],a[j-1];j--){
         *   exch(...)
         *  }
         */
        fun sort(array: Array<Double>) {
            array.show()
            val n = array.size
            for (i in 1 until n) {
                var j = i
                while (j > 0 && less(array[j], array[j - 1])) {
                    array.exch(j, j - 1)
                    array.betterShow(j, j - 1)
                    j--
                }
            }
            array.show()
        }

        @JvmStatic
        fun main(array: Array<String>) {
            Insertion.sort(SortCompare.uniformArray())
        }
    }
}