package study.playground.ClassLoaderDemo;

public class Father extends Grandpa {
    static
    {
        System.out.println("爸爸在静态代码块");
    }

    public static int factor = 25;

    public Father()
    {
        System.out.println("我是爸爸~");
    }
}
