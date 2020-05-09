package study.tree

import java.util.*
import kotlin.collections.ArrayList

public fun Int.toTreeNode(): TreeNode {
    return TreeNode(this)
}

public fun TreeNode?.toList(): List<String> {
    val result: MutableList<String> = ArrayList()
    if (this == null) {
        result.add("null")
        return result
    }
    val queue: Queue<TreeNode?> = LinkedList()
    queue.offer(this)
    while (queue.size != 0) {
        val treeNode = queue.poll()
        result.add(treeNode?.`val`?.toString() ?: "null")
        if (treeNode != null) {
            if (treeNode.left != null || treeNode.right != null) {
                queue.offer(treeNode.left)
                queue.offer(treeNode.right)
            }
        }
    }

    while (result.last() == "null") {
        result.removeAt(result.size - 1)
    }

    return result
}

public fun String?.toSingleTreeNode(): TreeNode? {
    return if (null == this || "null" == this) {
        null
    } else {
        Integer.parseInt(this).toTreeNode()
    }
}

public fun String.toTree(): TreeNode? {
//    val input = "[10,5,15,3,7,null,18]".split(",", "[", "]")
    val list = this.split(",", "[", "]").filter { it.isNotEmpty() }

    val queue: Queue<String> = LinkedList(list)
    val first = queue.poll()
    if ("null" == first) {
        return null
    }
    val root = Integer.parseInt(first).toTreeNode()
    val queueForTree: Queue<TreeNode> = LinkedList()
    queueForTree.offer(root)
    while (queueForTree.size != 0 && queue.size != 0) {
        val treeNode = queueForTree.poll()
        treeNode.left = queue.poll().toSingleTreeNode()
        treeNode.right = queue.poll().toSingleTreeNode()
        if (treeNode.left != null) {
            queueForTree.offer(treeNode.left)
        }

        if (treeNode.right != null) {
            queueForTree.offer(treeNode.right)
        }
    }

    return root
}