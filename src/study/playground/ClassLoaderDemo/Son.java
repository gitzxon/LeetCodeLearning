package study.playground.ClassLoaderDemo;

class Son extends Father {
    static {
        System.out.println("儿子在静态代码块");
    }

    public Son() {
        System.out.println("我是儿子~");
    }
}