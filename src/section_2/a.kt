package section_2

/**
 * @author chenzhaojun
 * @date 2018/4/12
 * @description
 */

internal class a {
    private fun adjustDownToUp(array: IntArray, k: Int, length: Int) {
        var k = k
        val temp = array[k]
        var i = 2 * k + 1
        while (i < length - 1) {
            //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if (i < length && array[i] < array[i + 1]) {  //取节点较大的子节点的下标
                i++   //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if (temp >= array[i]) {  //根节点 >=左右子女中关键字较大者，调整结束
                break
            } else {   //根节点 <左右子女中关键字较大者
                array[k] = array[i]  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i //【关键】修改k值，以便继续向下调整
            }
            i = 2 * i + 1
        }
        array[k] = temp  //被调整的结点的值放人最终位置
    }
}
