package study.tree.SerializeAndDeserialize

import org.junit.Test
import study.tree.TreeNode

class CodecTest {

    @Test
    fun test() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.right.left = TreeNode(4)
        root.right.right = TreeNode(5)
        val result = Codec().serialize(root)
        println("result = ${result}")

        val decode = Codec().deserialize(result)

    }

    @Test
    fun test_1() {
        val root = TreeNode(1)
        root.left = TreeNode(2)

        val result = Codec().serialize(root)
        println("result = ${result}")

        val decode = Codec().deserialize(result)

    }
}