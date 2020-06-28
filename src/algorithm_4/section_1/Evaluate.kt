package algorithm_4.section_1

import edu.princeton.cs.introcs.StdIn
import edu.princeton.cs.introcs.StdOut

//用两个栈来实现一个简易计算器，计算器必须附带括号优先级
fun main(args: Array<String>) {
    val options = MyStack<String>()
    val values = MyStack<Double>()
    while (!StdIn.isEmpty()) {
        val x = StdIn.readString()
        when (x) {
            "(" -> {
            }
            "+", "-", "*", "/", "sqrt" -> options.push(x)
            ")" -> {
                val option = options.pop()
                val value = values.pop()
                val v = when (option) {
                    "+" -> values.pop() + value
                    "-" -> values.pop() - value
                    "*" -> values.pop() * value
                    "/" -> values.pop() / value
                    "sqrt" -> Math.sqrt(value)
                    else -> throw NotImplementedError("not implement this compute")
                }
                values.push(v)
            }
            else -> values.push(x.toDouble())
        }
    }
    StdOut.print(values.pop())
}

