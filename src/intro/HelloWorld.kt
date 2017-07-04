package intro

import algo.LinkedList

/**
 * Created by sHIVAM on 5/30/2017.
 */

fun main(args: Array<String>) {
    val list:LinkedList<Int> = LinkedList()
    list.append(1)
    list.append(2)
    list.append(3)
    list.append(4)
    list.append(5)
    println(list.toString())
}

fun sayHello() = "Hello World!"

fun sayHello1(): String {
    return "Hello World";
}