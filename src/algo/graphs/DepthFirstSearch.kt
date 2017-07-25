package algo.graphs

import java.util.*

/**
 * Created by sHIVAM on 7/25/2017.
 */

class DepthFirstSearch<T : Comparable<T>>(val graph: AdjacencyList<T>, private val start: Vertex<T>) {
    private var marked: MutableSet<Vertex<T>> = mutableSetOf()
    private var edgeTo: MutableMap<Vertex<T>, Vertex<T>> = mutableMapOf()

    init {
        dfs(graph, start)
    }

    private fun dfs(graph: AdjacencyList<T>, vertex: Vertex<T>) {

        marked.add(vertex)
        graph.edges(vertex)?.let {
            it.forEach {
                edge ->
                if (!marked.contains(edge.dest)) {
                    edgeTo[edge.dest] = vertex
                    dfs(graph, edge.dest)
                }
            }
        }
    }

    private fun isMarked(vertex: Vertex<T>): Boolean {
        return this.marked.contains(vertex)
    }

    fun count(): Int = marked.count()

    fun search(vertex: Vertex<T>): Boolean {
        return isMarked(vertex)
    }

    fun hasPathTo(dest: Vertex<T>): Boolean {
        return isMarked(dest)
    }

    fun pathTo(dest: Vertex<T>): Iterable<Vertex<T>> {
        if (!hasPathTo(dest))
            return Stack<Vertex<T>>()
        var path = Stack<Vertex<T>>()
        var v: Vertex<T> = dest
        while (v != start) {
            path.push(v)
            v = edgeTo[v] as Vertex<T>
        }
        path.push(v)
        return path

    }

}