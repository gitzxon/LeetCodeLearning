package study.playground.ClassLoaderDemo;

// 准备阶段
// book = null
// amount = 0
// 因为要加载 main 方法，所以会触发类的初始化阶段
// 按照顺序的话，想触发 static Book book = new Book(); 于是把流程转到类对象的初始化上了。
// 书的普通代码块
// int price = 110;
// 书的构造方法
// "price=" + 110 +",amount=" + 0
// book = new Book() 完成了
// 书的静态代码块
// amount = 112
// 书的静态方法
public class Book {
    public static void main(String[] args)
    {
        staticFunction();
    }

    static Book book = new Book();

    static
    {
        System.out.println("书的静态代码块");
    }

    public static void staticFunction(){
        System.out.println("书的静态方法");
    }

    static int amount = 112;

    {
        System.out.println("书的普通代码块");
    }

    int price = 110;

    Book()
    {
        System.out.println("书的构造方法");
        System.out.println("price=" + price +",amount=" + amount);
    }
}