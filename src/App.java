public class App {

    public static void main(String[] args) {
        System.out.println("hello");
    }

    private static App d = new App();
    {
        System.out.println("before");
    }
    private SubClass t = new SubClass();
    {
        System.out.println("after");
    }
    static {
        System.out.println(3);
    }

    public App() {
        System.out.println(4);
    }

    //定义父类
    static class SuperClass {
        static {
            System.out.println("static init super class");
        }
        SuperClass() {
            System.out.println("构造SuperClass");
        }
    }

    //定义子类
    static class SubClass extends SuperClass {
        static {
            System.out.println("static init sub class");
        }

        public SubClass() {
            //SuperClass();//有一个隐式的父类构造器
            System.out.println("构造 SubClass");
        }
    }
}



