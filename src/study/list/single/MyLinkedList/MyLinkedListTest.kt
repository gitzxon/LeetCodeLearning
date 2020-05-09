package study.list.single.MyLinkedList

import study.list.single.toArrayList
import org.junit.Test

class MyLinkedListTest {

    @Test
    fun test() {
        val myLinkedList = MyLinkedList()
        myLinkedList.addAtHead(1)
        println(myLinkedList.head.toArrayList())
        myLinkedList.addAtTail(3)
        println(myLinkedList.head.toArrayList())
        myLinkedList.addAtIndex(1, 2)
        println(myLinkedList.head.toArrayList())
        myLinkedList.get(1)
        println(myLinkedList.head.toArrayList())
        myLinkedList.deleteAtIndex(1)
        println(myLinkedList.head.toArrayList())
        myLinkedList.get(1)
        println(myLinkedList.head.toArrayList())
    }
}