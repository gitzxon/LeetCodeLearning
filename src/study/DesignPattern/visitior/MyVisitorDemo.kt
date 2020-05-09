package study.DesignPattern.visitior

fun main(args: Array<String>) {
    Manager().handleStart()
    Manager().handleEnd()
}

class Manager {

    val listenerHolder = ListenerHolder()

    init {
        for (i in 0 until 10) {
            listenerHolder.mListeners.add(ListenerHolder.Listener("listener_$i"))
        }
    }

    fun handleStart() {
        println("Manager.handleStart")
        listenerHolder.accept(
                object: ListenerVisitor {
                    override fun visit(listener: ListenerHolder.Listener) {
                        println("Manager.visit ${listener.name}")
                        listener.onStart()
                    }
                }
        )
    }


    fun handleEnd() {
        println("Manager.handleEnd")
        listenerHolder.accept(
                object: ListenerVisitor {
                    override fun visit(listener: ListenerHolder.Listener) {
                        println("Manager.visit ${listener.name}")
                        listener.onEnd()
                    }
                }
        )
    }
}

interface ListenerVisitor {
    fun visit(listener: ListenerHolder.Listener)
}

class ListenerHolder {
    var mListeners: MutableList<Listener> = ArrayList()

    class Listener(val name: String) {

        fun onStart() {
            println("Listener.onStart")
        }
        
        fun onEnd() {
            println("Listener.onEnd")
        }
    }

    fun accept(visitor: ListenerVisitor) {
        mListeners.forEach {
            visitor.visit(it)
        }
    }

}

