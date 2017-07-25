package algo.graphs

/**
 * Created by sHIVAM on 7/25/2017.
 */

class AdjacencyList<T: Comparable<T>> : Graphable<T> {


    var adjacencyMap : MutableMap<Vertex<T>, MutableList<Edge<T>>> = mutableMapOf()

    private fun addDirectedEdge(src: Vertex<T>, dest: Vertex<T>, weight: Double?) {
        adjacencyMap[src]?.add(Edge(src, dest, weight))
    }

    private fun addUndirectedEdge(pair: Pair<Vertex<T>, Vertex<T>>, weight: Double?) {
        val(src, dest) = pair
        addDirectedEdge(src, dest, weight)
        addDirectedEdge(dest, src, weight)
    }

    override fun newVertex(data: T): Vertex<T> {
        val vertex = Vertex(data)
        adjacencyMap[vertex]?: kotlin.run {
            adjacencyMap[vertex] = mutableListOf()
        }
        return vertex
    }

    override fun add(type:EdgeType, source: Vertex<T>, dest: Vertex<T>, weight: Double?) = when(type) {
        is Directed -> {
            addDirectedEdge(src = source, dest = dest, weight = weight)
        }
        is Undirected -> addUndirectedEdge(Pair(source, dest), weight)
    }

    override fun weight(src: Vertex<T>, dest: Vertex<T>): Double? {
        val edges = adjacencyMap[src]
        edges?.let { it.forEach {
            edge -> if(edge.dest == dest) return edge.weight
        } }
        return null
    }

    override fun edges(src: Vertex<T>): MutableList<Edge<T>>? {
        return adjacencyMap[src]
    }

    override fun toString(): String {
        var result = ""
        for ((vertex, edges) in adjacencyMap) {
            var edgeString = ""
            for ((index, edge) in edges.withIndex()) {
                if (index != edges.count() - 1) {
                    edgeString += "${edge.dest}, "
                } else {
                    edgeString += "${edge.dest}"
                }
            }
            result += "$vertex ---> [ $edgeString ] \n"
        }
        return result
    }
}