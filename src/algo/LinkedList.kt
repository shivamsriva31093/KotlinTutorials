package algo

/**
 * Created by sHIVAM on 7/4/2017.
 */

class Node<T>(var value: T) {
    var next:Node<T>? = null
    var prev:Node<T>? = null
}

class LinkedList<T> {
    private var head:Node<T>? = null
    var isEmpty:Boolean = head==null

    fun first():Node<T>? = head

    fun last(): Node<T>? {
        var node: Node<T>? = head ?: return null
        while (node?.next != null) {
            node = node.next
        }
        return node
    }

    fun length():Int {
        var node:Node<T>? = head ?: return  0
        var count = 0
        while (node?.next != null) {
            node = node.next
            count++
        }
        return count
    }

    fun append(value : T) {
        var node = Node(value)
        var tail = last()
        if(tail == null)
            head = node
        else {
            tail.next = node
        }
    }

    fun removeAll() {
        head = null
    }

    fun remove(node : Node<T>):T {
        var temp = head
        while (temp?.value != node.value) {
            temp = temp?.next
        }
        temp?.next = node.next
        return node.value
    }

    override fun toString(): String {
        var s = "["
        var node = head
        while (node != null) {
            s += "${node.value}"
            node = node.next
            if(node!=null) {
                s += "->"
            }
        }
        return s + "]"
    }
}