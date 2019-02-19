public class Main {

    Parent p = new Child();

    public static void main(String[] args) {
        System.out.println("start main");
    }

    public static class Parent {
        static {
            System.out.println("parent static block");
        }

        public void print() {
            System.out.println("print parent");
        }
    }

    public static class Child extends Parent {
        static {
            System.out.println("child static block");
        }

        public void print() {
            System.out.println("print child");
        }
    }

}
