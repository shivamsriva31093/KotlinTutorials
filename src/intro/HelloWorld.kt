package intro

import algo.LinkedList
import algo.LinkedListOperations
import algo.graphs.AdjacencyList
import algo.graphs.DepthFirstSearch
import algo.graphs.Undirected

/**
 * Created by sHIVAM on 5/30/2017.
 */

fun main(args: Array<String>) {
    val adjacencyList = AdjacencyList<String>()
    val start = adjacencyList.newVertex("A")
    val b = adjacencyList.newVertex("B")
    val d = adjacencyList.newVertex("C")
    val e = adjacencyList.newVertex("D")
    val f = adjacencyList.newVertex("E")
    val m = adjacencyList.newVertex("K")
    val n = adjacencyList.newVertex("J")
    val end = adjacencyList.newVertex("I")

    adjacencyList.add(Undirected(), start, b)
    adjacencyList.add(Undirected(), b, d)
    adjacencyList.add(Undirected(), b, e)
    adjacencyList.add(Undirected(), b, f)
    adjacencyList.add(Undirected(), m, n)
    adjacencyList.add(Undirected(), m, e)
    adjacencyList.add(Undirected(), n, b)
    adjacencyList.add(Undirected(), n, end)

    val dfs = DepthFirstSearch(adjacencyList, start)
    print(adjacencyList)
    print(dfs.search(adjacencyList.newVertex("Z")))
    println()
    print(dfs.pathTo(n))
}

fun sayHello() = "Hello World!"

fun sayHello1(): String {
    return "Hello World";
}

