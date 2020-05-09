package study.list.single

import study.list.single.MyLinkedList.MyLinkedList
import java.util.*

fun IntArray.toLinkedList(): ListNode? {
    var mockHead = ListNode(0)
    var p = mockHead;
    for (i in this) {
        p.next = ListNode(i)
        p = p.next
    }
    p = mockHead.next
    mockHead.next = null
    return p

}

fun ListNode?.toArrayList(): MutableList<Int> {
    var p:ListNode? = this
    var arrayList: MutableList<Int> = ArrayList()
    while (p != null) {
        arrayList.add(p.`val`)
        p = p.next
    }
    return arrayList
}

fun MyLinkedList.ListNode?.toArrayList(): MutableList<Int> {
    var p = this
    var arrayList: MutableList<Int> = ArrayList()
    while (p != null) {
        arrayList.add(p.`val`)
        p = p.next
    }
    return arrayList
}


fun IntArray.print(): String {
    return Arrays.toString(this)
}
