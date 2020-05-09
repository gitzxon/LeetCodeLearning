package study.playground.InterfaceWithDefaultMethod

interface TestInterface {
    fun method1() {
        println("default impl for method1() called")
    }

    fun method2()
}

class TestInterfaceCaller {
    fun getTestInterfaceImpl(): TestInterface {
        return object : TestInterface {
            override fun method2() {
                println("method2 called")
            }
        }
    }
}